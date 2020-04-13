package pocFis

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{DoubleType, StringType, StructField, StructType}

object GetAwsFileToAnalyze {


  def main(args: Array[String]): Unit = {


    val conf = new SparkConf().setAppName("local")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val spark: SparkSession = SparkSession.builder.master("local").getOrCreate

    sc.hadoopConfiguration.set("fs.s3n.awsAccessKeyId", "ACCESSKEY")
    sc.hadoopConfiguration.set("fs.s3n.awsSecretAccessKey", "SECRETACCESSKEY")
    sc.hadoopConfiguration.set("fs.s3n.impl", "org.apache.hadoop.fs.s3native.NativeS3FileSystem")


    val myRDD = sc.textFile("s3n://bucket/archivo.csv")




    println("Final")
    println("Lineas en el archivo:"+ myRDD.count())





  }

}
