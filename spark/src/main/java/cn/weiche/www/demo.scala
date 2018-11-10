package cn.weiche.www

import java.util.Properties

import org.apache.spark.sql.{DataFrame, SQLContext}
import org.apache.spark.sql.execution.SparkSQLParser
import org.apache.spark.{SparkConf, SparkContext}

object demo {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("demo").setMaster("local[2]")
    val context: SparkContext = new SparkContext(conf)
    val sql: SQLContext = new SQLContext(context)
    val properties: Properties = new Properties()
    properties.put("user","root")
    properties.put("password","123")
    val frame: DataFrame = sql.read.jdbc("jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf-8","demo",properties)
    val unit1: Unit = frame.registerTempTable("demo")
    val df2: DataFrame = sql.sql("select * from demo limit 10")
    df2.show()
    println(df2.show())
    println("hello")
    context.stop()
  }
}