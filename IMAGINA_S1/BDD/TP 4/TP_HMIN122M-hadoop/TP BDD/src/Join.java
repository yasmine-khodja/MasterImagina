import java.io.IOException;
import java.time.Instant;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;



public class Join {
	
	private static final String INPUT_PATH = "input-join-compact/";
	private static final String OUTPUT_PATH = "output/join-";
	private static final Logger LOG = Logger.getLogger(Join.class.getName());
	
	
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
	
	public static class Map extends Mapper<LongWritable, Text, Text, Text> {

		//join customers.name et orders.comment dans les deux tables customers et orders
		@Override
		/*public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			// TODO: à compléter
			
			
			String line = value.toString();
			
			String[] tuples = line.split("\n");
			
			for(String tuple : tuples) {
				
				String[] vals = tuple.split("\\|");
				
				
				try {
					
				if(vals.length==9) { //order
					//vals[8] : commentaire
					context.write(new Text(vals[1]), new Text(vals[8] + ";;order"));
				}
				if(vals.length==8) { //client
					//vals[8] : nom
					context.write(new Text(vals[0]), new Text(vals[1] + ";;customer"));
				}
				
				}catch(NumberFormatException e) {
					LOG.warning(e.getMessage());
				}
				
			}
		}*/
		
		public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			// TODO: à compléter
			
			
			String line = value.toString();
			
			String[] tuples = line.split("\n");
			
			for(String tuple : tuples) {
				
				String[] vals = tuple.split("\\|");
				
				
				try {
					
				if(vals.length==9) { //order
					//vals[8] : commentaire
					context.write(new Text(vals[1]), new Text(vals[3] + ";;order"));
				}
				if(vals.length==8) { //client
					//vals[8] : nom
					context.write(new Text(vals[0]), new Text(vals[1] + ";;customer"));
				}
				
				}catch(NumberFormatException e) {
					LOG.warning(e.getMessage());
				}
				
			}
		}
	}

	public static class Reduce extends Reducer<Text, Text, Text, Text> {
		
		public void reduce(Text key, Iterable<Text> values, Context context)
				throws IOException, InterruptedException {

			// TODO: à compléter
			for (Text val1 : values) {
				
				String[] tab1 = val1.toString().split(";;");
				
				for(Text val2 : values) {
					
					String[] tab2 = val2.toString().split(";;");
					
					if(tab1[1].equals("customer")&&tab2[1].equals("order")) {
						context.write(key, new Text(tab1[0]+ " " + tab2[0]));
					}
				}
			}
			
		}
		
		/*joiture entre customers et orders
		public void reduce(Text key, Iterable<Text> values, Context context)
				throws IOException, InterruptedException {

			// TODO: à compléter
			for (Text val1 : values) {
				
				String[] tab1 = val1.toString().split(";;");
				
				for(Text val2 : values) {
					
					String[] tab2 = val2.toString().split(";;");
					
					if(tab1[1].equals("customer")&&tab2[1].equals("order")) {
						context.write(key, new Text(tab1[0]+ " " + tab2[0]));
					}
				}
			}
			
		}*/
	}
	
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();

		Job job = new Job(conf, "Join");

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);

		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);

		//job.setOutputValueClass(DoubleWritable.class); 

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path(INPUT_PATH));
		FileOutputFormat.setOutputPath(job, new Path(OUTPUT_PATH + Instant.now().getEpochSecond()));

		job.waitForCompletion(true);
	}
	
}	
