package reduceJoin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class CustomerOrderMapReduce {
	
	public static void main(String[] args) throws Exception {
		Configuration configuration = new Configuration();
		//1.get Job
		Job job = Job.getInstance(configuration);
		
		//2.set Jar
		job.setJarByClass(CustomerOrderMapReduce.class);
		
		//3.set Mapper
		job.setMapperClass(CustomerOrderMapper.class);
		job.setMapOutputKeyClass(LongWritable.class);
		job.setMapOutputValueClass(CustomerOrderBean.class);
		
		
		//4.set Reducer
		job.setReducerClass(CustomerOrderReducer.class);
		job.setOutputKeyClass(LongWritable.class);
		job.setOutputValueClass(Text.class);
		
		//5.PathIn  PathOut
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		//6.submit
		job.waitForCompletion(true);
	}
	
	/**
	 * 1,Stephanie Leung,555-555-5555
	 *
	 */
	public static class CustomerOrderMapper extends Mapper<LongWritable, Text, LongWritable, CustomerOrderBean>{
		CustomerOrderBean bean = new CustomerOrderBean();
		LongWritable longWritable = new LongWritable();
		@Override
		protected void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException {
			String[] split = value.toString().split(",");
			/*
			 * 根据数组的长度来区分来自哪张表
			 * 如果长度=3,说明是customer表的数据
			 */
			if (split.length == 3) {
				bean.set("customer", split[1]+","+split[2]);
				long k = Long.valueOf(split[0]);
				longWritable.set(k);
				context.write(longWritable, bean);
			}
			
			//length=4 说明是order表的数据
			if (split.length == 4) {
				bean.set("order", split[1]+","+split[2]+","+split[3]);
				long k = Long.valueOf(split[0]);
				longWritable.set(k);
				context.write(longWritable, bean);
			}
		}
	}
	
	/**
	 * key:{value1,value2...}
	 * 1:{(customer,Stephanie Leung,555-555-5555),(order,B,88.25,20-May-2008)}
	 * 2:
	 * 3:{(customer,Jose Madriz,281-330-8004),(order,A,12.95,02-Jun-2008),(order,D,25.02,22-Jan-2009)}
	 * 4:
	 */
	public static class CustomerOrderReducer extends Reducer<LongWritable, CustomerOrderBean, LongWritable, Text>{
		Text text = new Text();
		@Override
		protected void reduce(LongWritable key,
				Iterable<CustomerOrderBean> iterable,
				Context context)
				throws IOException, InterruptedException {
			Map<Long, String> customerMap = new HashMap<Long, String>();
			List<String> orderList = new ArrayList<String>();
			
			for (CustomerOrderBean customerOrderBean : iterable) {
				String flag = customerOrderBean.getFlag();
				if (flag.equals("customer")) {
					customerMap.put(key.get(), customerOrderBean.getData());
				}else {
					//String num = String.valueOf(key.get());
					orderList.add(customerOrderBean.getData());
				}
			}
			
			for (String orderStr : orderList) {
				String customerStr = customerMap.get(key.get());
				text.set(customerStr+","+orderStr);
				context.write(key, text);
			}
		}
	}
}
