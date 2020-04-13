package pocFis


import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.functions._
import org.joda.time.{DateTime, DateTimeZone}

object GetAwsFileToAnalyzeExample2 {



  def main(args: Array[String]): Unit = {




    val conf = new SparkConf().setAppName("local")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val spark: SparkSession = SparkSession.builder.master("local").getOrCreate

    sc.hadoopConfiguration.set("fs.s3n.awsAccessKeyId", "ACCESSKEY")
    sc.hadoopConfiguration.set("fs.s3n.awsSecretAccessKey", "SECRETACCESSKEY")
    sc.hadoopConfiguration.set("fs.s3n.impl", "org.apache.hadoop.fs.s3native.NativeS3FileSystem")

    val testSchema = StructType(Array(
      StructField("Year", IntegerType, true),
      StructField("FirstName", StringType, true),
      StructField("County", StringType, true),
      StructField("Sex", StringType, true),
      StructField("Count", IntegerType, true)))




    println("Inicio: "+DateTime.now())
    val df = spark.read.option("header","true").format("csv").schema(testSchema).load("s3n://bucket/archivo.csv")



    df.sort("FirstName").show(false)
    df.printSchema()
    println(df.count())
    println(df.first())



    //df.groupBy("FirstName").max("count").show(false) //Maxima cantidad por nombre

    df.groupBy("FirstName").agg(sum("count").alias("Total")).orderBy(desc("Total"))
      .show(false) //Suma por nombre







    println("Final: "+DateTime.now())





  }

}
