package org.sourygna;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class AnalisisLogsDriver {
	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.out.printf("Usage: AnalisisLogs <input dir> <output dir>\n");
			System.exit(-1);
		}

		Job job = new Job();
		job.setJarByClass(AnalisisLogsDriver.class);
		job.setJobName("Analisis Logs");

		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.setMapperClass(AnalisisLogsMapper.class);
		job.setReducerClass(AnalisisLogsReducer.class);

		job.setNumReduceTasks(1);

		job.setInputFormatClass(KeyValueTextInputFormat.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);

		boolean success = job.waitForCompletion(true);
		System.exit(success ? 0 : 1);
	}
}