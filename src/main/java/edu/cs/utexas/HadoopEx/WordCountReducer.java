package edu.cs.utexas.HadoopEx;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.join.TupleWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends  Reducer<Text, TupWritable, Text, TupWritable> {

   public void reduce(Text text, Iterable<TupWritable> tuples, Context context)
           throws IOException, InterruptedException {
	   
        int flightSum = 0;
        float departureSum = 0;
        for (TupWritable tuple : tuples) {
            // System.out.println("XXXXXXXXXXXXXXXXXXXXXXtuplefloat: " + ((FloatWritable) tuple.get(1)).get());
            flightSum += ((IntWritable) tuple.get(0)).get();
            departureSum += ((FloatWritable) tuple.get(1)).get();
        }
        // System.out.println("XXXXXXXXXXXXXXXXXXXXXXflightSum: " + flightSum);
        // System.out.println("XXXXXXXXXXXXXXXXXXXXXXdepartureSum: " + departureSum);

        Writable[] reducedout = {new IntWritable(flightSum), new FloatWritable(departureSum)};
        context.write(text, new TupWritable(reducedout));
   }
}