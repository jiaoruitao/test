package hadoop.ibeifeng.com;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class PVMapReduce {
	public static void main(String[] args) throws Exception {
		//1.get Job
		Job job = Job.getInstance(new Configuration());
		
		//2.set Jar
		job.setJarByClass(PVMapReduce.class);
		
		//3.set Mapper
		job.setMapperClass(PVMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(LongWritable.class);
		
		//4.set Reducer
		job.setReducerClass(PVReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		
		//5.PathIn  PathOut
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		//6.submit
		job.waitForCompletion(true);
	}
	
	
	//map method
	public static class PVMapper extends Mapper<LongWritable, Text, Text, LongWritable>{
		Text text = new Text();
		LongWritable longWritable = new LongWritable(1);
		@Override
		protected void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException {
			String line = value.toString();
			String[] split = line.split("\t");
			
			// length >= 30 is useful
			if (split.length < 30) {
				//counter defination
				context.getCounter("my error counter", "length is less than 30").increment(1);
				return;
			}
			
			// url is null is useless
			if ( StringUtils.isBlank(split[1])) {
				context.getCounter("my error counter", "url is null").increment(1);
				return;
			} 
			
			// provinceId null is useless
			if (StringUtils.isBlank(split[23])) {
				context.getCounter("my error counter", "provinceId is null").increment(1);
				return;
			}
			
			// provinceId should be a number
			try {
				new Integer(split[23]);
			} catch (NumberFormatException e) {
				context.getCounter("my error counter", "provinceId is not a number").increment(1);
				e.printStackTrace();
				return ;
			}
			
			//text.set(provinceId)
			text.set(split[23]);
			context.write(text, longWritable);
		}
	}
	
	public static class PVReducer extends Reducer<Text, LongWritable, Text, LongWritable>{
		LongWritable value = new LongWritable();
		
		@Override
		protected void reduce(Text key, Iterable<LongWritable> iterable,
				Context context)
				throws IOException, InterruptedException {
			long count = 0;
			for (LongWritable longWritable : iterable) {
				long l = longWritable.get();
				count += l;
			}
			value.set(count);
			//key:provinceId	value:number of provinceId
			context.write(key, value);
		}
		
	}
}	
