package edu.cs.utexas.HadoopEx;


import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;


public class WordAndCount implements Comparable<WordAndCount> {

        private final Text word;
        private final FloatWritable delayRatio;

        public WordAndCount(Text word, FloatWritable delayRatio) {
            this.word = word;
            this.delayRatio = delayRatio;
        }

        public Text getWord() {
            return word;
        }

        public FloatWritable getDelayRatio() {
            return delayRatio;
        }
    /**
     * Compares two sort data objects by their value.
     * @param other
     * @return 0 if equal, negative if this < other, positive if this > other
     */
        @Override
        public int compareTo(WordAndCount other) {

            float diff = delayRatio.get() - other.delayRatio.get();
            if (diff > 0) {
                return 1;
            } else if (diff < 0) {
                return -1;
            }
            return 0;
        }


        public String toString(){

            return "("+word.toString() +" , "+ delayRatio.toString()+")";
        }
    }

