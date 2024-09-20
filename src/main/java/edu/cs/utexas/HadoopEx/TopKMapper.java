package edu.cs.utexas.HadoopEx;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.join.TupleWritable;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.PriorityQueue;


import org.apache.log4j.Logger;


public class TopKMapper extends Mapper<Text, Text, Text, FloatWritable> {

	private Logger logger = Logger.getLogger(TopKMapper.class);
	private static int K = 3;

	private PriorityQueue<WordAndCount> pq;

	public void setup(Context context) {
		pq = new PriorityQueue<>();

	}

	/**
	 * Reads in results from the first job and filters the topk results
	 *
	 * @param key
	 * @param value a float value stored as a string
	 */
	public void map(Text key, Text tuple, Context context)
			throws IOException, InterruptedException {

		String strTuple = tuple.toString();
		// System.out.println("XXXXXXXXXXXXXXXXXXXXXXX: " + strTuple);
		// cut off '(' and ')'
		strTuple = strTuple.substring(1, strTuple.length() - 1);
		String[] tup_vals = strTuple.split(",");

		int flightSum = Integer.parseInt(tup_vals[0]);
		float delaySum = Float.parseFloat(tup_vals[1]);
		float delayRatio = delaySum / flightSum;

		pq.add(new WordAndCount(new Text(key), new FloatWritable(delayRatio)) );

		if (pq.size() > K) {
			pq.poll();
		}
	}

	public void cleanup(Context context) throws IOException, InterruptedException {


		while (pq.size() > 0) {
			WordAndCount wordAndCount = pq.poll();
			context.write(wordAndCount.getWord(), wordAndCount.getDelayRatio());
			logger.info("TopKMapper PQ Status: " + pq.toString());
		}
	}

}