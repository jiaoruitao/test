package hadoop.ibeifeng.com;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCountMapReduce {

	public static void main(String[] args) throws Exception {
		//1.get Job object
		Job job = Job.getInstance(new Configuration());

		//2.setJar
		job.setJarByClass(WordCountMapReduce.class);

		//3.set Mapper class and Mapper output parameter type
		job.setMapperClass(WCMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(LongWritable.class);

		//4.set Reducer class
		job.setReducerClass(WCReduce.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);

		//5.set in and out path
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		//6.submit
		//true: print information
		job.waitForCompletion(true);
	}

	//map() method
	public static class WCMapper extends Mapper<LongWritable, Text, Text, LongWritable>{
		@Override
		protected void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException {
			//value is line String
			String valueStr = value.toString();
			String[] split = valueStr.split(" ");
			for (String string : split) {
				context.write(new Text(string), new LongWritable(1));
			}
		}
	}


	public static class WCReduce extends Reducer<Text, LongWritable, Text, LongWritable>{
		@Override
		protected void reduce(Text arg0, Iterable<LongWritable> arg1,
				Context arg2)
						throws IOException, InterruptedException {
			long count = 0;
			for (LongWritable longWritable : arg1) {
				long l = longWritable.get();
				count += l;
			}
			arg2.write(arg0, new LongWritable(count));
		}
	}
}
