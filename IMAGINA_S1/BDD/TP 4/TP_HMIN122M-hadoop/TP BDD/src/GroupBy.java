
import java.io.IOException;
import java.time.Instant;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class GroupBy {
	private static final String INPUT_PATH = "input-groupBy/";
	private static final String OUTPUT_PATH = "output/groupBy-";
	private static final Logger LOG = Logger.getLogger(GroupBy.class.getName());

	static {
		System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s%n%6$s");

		try {
			FileHandler fh = new FileHandler("out.log");
			fh.setFormatter(new SimpleFormatter());
			LOG.addHandler(fh);
		} catch (SecurityException | IOException e) {
			System.exit(1);
		}
	}

	public static class Map extends Mapper<LongWritable, Text, Text, DoubleWritable> {
		
		public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			// TODO: à compléter
			double valeur;
			String line = value.toString();
		
			
			String[] tuples = line.split("\n");
			
			for(String tuple : tuples) {
				
				String[] vals = tuple.split(",");
				
				try {
				
				
				valeur = 1;
				
				
				
				}
				catch(NumberFormatException e)
				{
					LOG.warning(e.getMessage());
				}
				
				
			}
		
		/*
		@Override
		public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			// TODO: à compléter
			double valeur;
			String line = value.toString();
		
			
			String[] tuples = line.split("\n");
			
			for(String tuple : tuples) {
				String[] vals = tuple.split(",");
				
				try {
				
				
				valeur = 1;
				
				//group by par profit: context.write(new Text(vals[2]), new DoubleWritable(valeur));
				
				//group by date et category : context.write(new Text(vals[2] +" " +vals[14]), new DoubleWritable(valeur));
				
				//group by date et state : context.write(new Text(vals[2] +" " +vals[10]), new DoubleWritable(valeur));
				
				//Calcul du nombre distincts de produits diff
				
				context.write(new Text(vals[13]), new DoubleWritable(valeur));
				
				}
				catch(NumberFormatException e)
				{
					LOG.warning(e.getMessage());
				}
				
				
			}*/
			
			
		}
	}

	public static class Reduce extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {
		
		/*@Override
		public void reduce(Text key, Iterable<DoubleWritable> values, Context context)
				throws IOException, InterruptedException {
			// TODO: à compléter
			float sum = 0;
			for (DoubleWritable val : values)
				sum += val.get();
			
			context.write(key, new DoubleWritable(sum));
		}*/
		
		@Override
		public void reduce(Text key, Iterable<DoubleWritable> values, Context context)
				throws IOException, InterruptedException {
			// TODO: à compléter
			float sum = 0;
			for (DoubleWritable val : values)
				sum += val.get();
			
			context.write(key, new DoubleWritable(sum));
		}
	}

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();

		Job job = new Job(conf, "GroupBy");

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);

		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);

		job.setOutputValueClass(DoubleWritable.class); 

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path(INPUT_PATH));
		FileOutputFormat.setOutputPath(job, new Path(OUTPUT_PATH + Instant.now().getEpochSecond()));

		job.waitForCompletion(true);
	}
}