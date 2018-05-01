package com.practice.data.process

/**
  * Created by sesadasivam on 12/9/17.
  */
import java.io._

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.input.PortableDataStream
import org.apache.tika.parser.AutoDetectParser
import org.apache.tika.sax.WriteOutContentHandler
import org.apache.tika.metadata.Metadata
import org.apache.tika.parser.ParseContext

object TikaFileParser {

  def tikaFunc (a: (String, PortableDataStream)) = {

    val file : File = new File(a._1.drop(5))
    val myparser : AutoDetectParser = new AutoDetectParser()
    val stream : InputStream = new FileInputStream(file)
    val handler : WriteOutContentHandler = new WriteOutContentHandler(-1)
    val metadata : Metadata = new Metadata()
    val context : ParseContext = new ParseContext()

    myparser.parse(stream, handler, metadata, context)

    stream.close
    
    println(handler.toString())
    println("------------------------------------------------")
  }


  def main(args: Array[String]) {

    //val filesPath = "/home/user/documents/*"
    val filesPath = "/Users/1395764/Work/input/Notes/*"
    val conf = new SparkConf().setAppName("TikaFileParser").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val fileData = sc.binaryFiles(filesPath)
    fileData.foreach( x => tikaFunc(x))
  }
}
