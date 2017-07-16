package com.allaboutscala.learn.spark.dataframe

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
object DataFrame_Tutorial extends App with Context {

  // Create a DataFrame from reading a CSV file
  val dfTags = sparkSession
    .read
    .option("header", "true")
    .option("inferSchema", "true")
    .csv("src/main/resources/question_tags_10K.csv")
    .toDF("id", "tag")

  dfTags.show(10)


  // Print DataFrame schema
  dfTags.printSchema()


  // Query dataframe: select columns from a dataframe
  dfTags.select("id", "tag").show(10)


  // DataFrame Query: filter by column value of a dataframe
  dfTags.filter("tag == 'php'").show(10)


  // DataFrame Query: count rows of a dataframe
  println(s"Number of php tags = ${ dfTags.filter("tag == 'php'").count() }")


  // DataFrame Query: SQL like query
  dfTags.filter("tag like 's%'").show(10)


  // DataFrame Query: Multiple filter chaining
  dfTags
    .filter("tag like 's%'")
    .filter("id == 25 or id == 108")
    .show(10)


  // DataFrame Query: SQL IN clause
  dfTags.filter("id in (25, 108)").show(10)


  // DataFrame Query: SQL Group By
  println("Group by tag value")
  dfTags.groupBy("tag").count().show(10)


  // DataFrame Query: SQL Group By with filter
  dfTags.groupBy("tag").count().filter("count > 5").show(10)


  // DataFrame Query: SQL order by
  dfTags.groupBy("tag").count().filter("count > 5").orderBy("tag").show(10)


  // DataFrame Query: Cast columns to specific data type
  val dfQuestionsCSV = sparkSession
    .read
    .option("header", "true")
    .option("inferSchema", "true")
    .option("dateFormat","yyyy-MM-dd HH:mm:ss")
    .csv("src/main/resources/questions_10K.csv")
    .toDF("id", "creation_date", "closed_date", "deletion_date", "score", "owner_userid", "answer_count")

  dfQuestionsCSV.printSchema()

  val dfQuestions = dfQuestionsCSV.select(
    dfQuestionsCSV.col("id").cast("integer"),
    dfQuestionsCSV.col("creation_date").cast("timestamp"),
    dfQuestionsCSV.col("closed_date").cast("timestamp"),
    dfQuestionsCSV.col("deletion_date").cast("date"),
    dfQuestionsCSV.col("score").cast("integer"),
    dfQuestionsCSV.col("owner_userid").cast("integer"),
    dfQuestionsCSV.col("answer_count").cast("integer")
  )

  dfQuestions.printSchema()
  dfQuestions.show(10)


  // DataFrame Query: Operate on a sliced dataframe
  val dfQuestionsSubset = dfQuestions.filter("score > 400 and score < 410").toDF()
  dfQuestionsSubset.show()


  sparkSession.stop()

}
