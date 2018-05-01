package com.practice.data.process

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by sesadasivam on 12/1/17.
  */
object TestSparkCode {


  def main(args: Array[String]): Unit ={
    println("Welcome to world of Scala");
    /* if (args.length < 2) {
       System.err.println("Usage: TestSparkCode")
       System.exit(1)
     }*/
    val logFile = "file:////Users/1395764/Work/input/InputDataFile.txt" // Should be some file on your system
    val jobName = "TestSparkCode"
    val conf = new SparkConf().setAppName(jobName).setMaster("local[*]")
    val sc = new SparkContext(conf)
    val pathToFiles = logFile //args(0)
    val outputPath = "file:///Users/1395764/Work/input/result" //args(1)
    val lines = sc.textFile(pathToFiles)
    var loopCount = 0;


    //applying value one to all words
   // val pairs = words.map(word => (word,1))
    //applying word count logic here
   // val wordCounts= pairs.reduceByKey(_+_)

    //displaying result in console
   // wordCounts.collect().foreach(println)
    // Saving the output
    //wordCounts.saveAsTextFile(outputPath)


  }
}
