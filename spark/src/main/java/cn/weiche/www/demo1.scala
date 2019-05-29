package cn.weiche.www

import java.util

import kafka.serializer.StringDecoder
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}


object ConfigurationManager {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("读取kafka").setMaster("local[1]")
    val sc: SparkContext = new SparkContext(conf)
    val topics = Set[String]("demo")
//    val group_id = "test-consumer-group"
    val kafkaParams = Map("metadata.broker.list" -> "uhadoop-h5mkyw-core8:9092,uhadoop-h5mkyw-core10:9092,uhadoop-h5mkyw-core13:9092")
    val ssc: StreamingContext = new StreamingContext(sc,Seconds(5))
   // ssc.checkpoint("/home/youjie/checkpoint")
    val dstream: InputDStream[(String, String)] = KafkaUtils.createDirectStream[String, String, StringDecoder, StringDecoder](ssc, kafkaParams, topics)
    val value: DStream[(String, Int)] = dstream.flatMap(x => x._2.split(",").map((_,1))).reduceByKey(_+_)
    value.print()
    value.saveAsTextFiles("/home/youjie")
    ssc.start()  //spark stream系统启动
    ssc.awaitTermination() //

  }
}
