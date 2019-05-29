//package cn.weiche.www
//
//import java.sql.{DriverManager, ResultSetMetaData}
//import java.util.Properties
//
//import org.apache.spark.sql.execution.QueryExecution
//import org.apache.spark.sql.{DataFrame, SQLContext}
//import org.apache.spark.{SparkConf, SparkContext}
//
//object demo {
//
//def main(args: Array[String]): Unit = {
////  val conf: SparkConf = new SparkConf().setAppName("demo").setMaster("local[*]")
////  val context: SparkContext = new SparkContext(conf)
////  val sql: SQLContext = new SQLContext(context)
////  val properties: Properties = new Properties()
////  properties.put("user","bigdata_dev")
////  properties.put("password","fDNdCFAOfP")
////
////  JDBCSSHChannel.goSSH(3306,"hostname",3306,"youjie","跳板机",22)
////  val frame: DataFrame = sql.read.jdbc("jdbc:mysql://localhost:3306/martin_order?useUnicode=true&characterEncoding=utf-8","order_base",properties)
////  val unit1: Unit = frame.registerTempTable("demo")
////  val df2: DataFrame = sql.sql("select * from demo limit 1")
////  df2.show()
////  println(df2.show())
////  println("hello")
////  context.stop()
//}
//
//}
