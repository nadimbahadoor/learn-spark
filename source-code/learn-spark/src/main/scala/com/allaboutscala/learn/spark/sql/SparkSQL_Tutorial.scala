package com.allaboutscala.learn.spark.sql

import com.allaboutscala.learn.spark.utils.Context

/**
  * Created by Nadim Bahadoor on 28/06/2016.
  *
  *  Tutorial: Learn How To Use Apache Spark
  *
  * [[http://allaboutscala.com/big-data/spark/]]
  *
  * Copyright 2016 Nadim Bahadoor (http://allaboutscala.com)
  *
  * Licensed under the Apache License, Version 2.0 (the "License"); you may not
  * use this file except in compliance with the License. You may obtain a copy of
  * the License at
  *
  *  [http://www.apache.org/licenses/LICENSE-2.0]
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  * License for the specific language governing permissions and limitations under
  * the License.
  */
object SparkSQL_Tutorial extends App with Context {

  // Register temp table
  val dfTags = sparkSession
    .read
    .option("header", "true")
    .option("inferSchema", "true")
    .csv("src/main/resources/question_tags_10K.csv")
    .toDF("id", "tag")

  dfTags.createOrReplaceTempView("so_tags")


  // List all tables in Spark's catalog
  sparkSession.catalog.listTables().show()


  // List all tables in Spark's catalog using Spark SQL
  sparkSession.sql("show tables").show()


  // Select columns
  sparkSession
    .sql("select id, tag from so_tags limit 10")
    .show()
   //  dfTags.select("id", "tag").show(10)


  // Filter by column value
  sparkSession
    .sql("select * from so_tags where tag = 'php'")
    .show(10)
  // dfTags.filter("tag == 'php'").show(10)


  // Count number of rows
  sparkSession
    .sql(
      """select
        |count(*) as php_count
        |from so_tags where tag='php'""".stripMargin)
    .show(10)
//  println(s"Number of php tags = ${ dfTags.filter("tag == 'php'").count() }")


  // SQL like
  sparkSession
    .sql(
      """select *
        |from so_tags
        |where tag like 's%'""".stripMargin)
    .show(10)
  //  dfTags.filter("tag like 's%'").show(10)


  // SQL where with and clause
  sparkSession
    .sql(
      """select *
        |from so_tags
        |where tag like 's%'
        |and (id = 25 or id = 108)""".stripMargin)
    .show(10)
//  dfTags
//    .filter("tag like 's%'")
//    .filter("id == 25 or id == 108")
//    .show(10)


  // SQL IN clause
  sparkSession
    .sql(
      """select *
        |from so_tags
        |where id in (25, 108)""".stripMargin)
    .show(10)
//  dfTags.filter("id in (25, 108)").show(10)


  sparkSession.stop()
}
