package edu.cs.utexas.HadoopEx;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.join.TupleWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<Object, Text, Text, TupWritable> {

	// Create a counter and initialize with 1
	private final IntWritable counter = new IntWritable(1);
	// Create a hadoop text object to store words
	private Text word = new Text();

	public void map(Object key, Text value, Context context) 
			throws IOException, InterruptedException {

		try {
			String[] records = value.toString().split("\\R");
			for(int i = 0; i < records.length; ++i) {
				String[] vals = records[i].split(",");
				word.set(vals[7]);
				FloatWritable departureDelay = new FloatWritable(Float.parseFloat(vals[11]));
				Writable[] valueout = {counter, departureDelay};
				TupWritable tuple = new TupWritable(valueout);
				// System.out.println("XXXXXXXXXXXXXXXXXXXXXXdepartureDelay: " + departureDelay);
				// System.out.println("XXXXXXXXXXXXXXXXXXXXXXtuple: " + tuple.get(1));
				context.write(word, tuple);
			}
		} catch (NumberFormatException e) {

		}
	}
}