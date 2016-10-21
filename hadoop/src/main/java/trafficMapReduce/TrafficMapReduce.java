package trafficMapReduce;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class TrafficMapReduce {
	public static void main(String[] args) throws Exception {
		Configuration configuration = new Configuration();
		//1.get Job
		Job job = Job.getInstance(configuration);

		//2.set Jar
		job.setJarByClass(TrafficMapReduce.class);

		//3.set Mapper
		job.setMapperClass(TrafficMapper.class);
		job.setMapOutputKeyClass(Traffic.class);
		job.setMapOutputValueClass(Text.class);

		//3.5 set Partition
		//job.setPartitionerClass(MyPartitioner.class);
		//set number of Reducer
		//job.setNumReduceTasks(new Integer(args[2]));
		//job.setNumReduceTasks(3);

		//3.6 set Combiner
		//job.setCombinerClass(PVReducer.class);

		//4.set Reducer
		//		job.setReducerClass(PVReducer.class);
		//		job.setOutputKeyClass(Text.class);
		//		job.setOutputValueClass(LongWritable.class);

		//5.PathIn  PathOut
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		//6.submit
		job.waitForCompletion(true);
	}

	public static class TrafficMapper extends Mapper<LongWritable, Text,Traffic, Text>{
		Text v = new Text();
		Traffic traffic = new Traffic();
		@Override
		protected void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException {
			String[] split = value.toString().split("\t");
			String phoneStr = split[1];
			v.set(phoneStr);
			traffic.set(Integer.valueOf(split[6]), 
					Integer.valueOf(split[7]), 
					Integer.valueOf(split[8]), 
					Integer.valueOf(split[9]));
			context.write(traffic, v);
		}
	}
}
