package com.allaboutscala.learn.spark.dataframe

import com.allaboutscala.learn.spark.utils.Context
import org.apache.spark
import org.apache.spark.sql.Dataset

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
object DataFrameOperations extends App with Context {

  // Setup
  val dfTags = sparkSession
    .read
    .option("header", "true")
    .option("inferSchema", "true")
    .csv("src/main/resources/question_tags_10K.csv")
    .toDF("id", "tag")

  dfTags.show(10)

  val dfQuestionsCSV = sparkSession
    .read
    .option("header", false)
    .option("inferSchema", true)
    .option("dateFormat","yyyy-MM-dd HH:mm:ss")
    .csv("src/main/resources/questions_10K.csv")
    .toDF("id", "creation_date", "closed_date", "deletion_date", "score", "owner_userid", "answer_count")

  val dfQuestions = dfQuestionsCSV
    .filter("score > 400 and score < 410")
    .join(dfTags, "id")
    .select("owner_userid", "tag", "creation_date", "score")
    .toDF()

  dfQuestions.show(10)


  // Convert DataFrame row to Scala case class
  case class Tag(id: Int, tag: String)

  import sparkSession.implicits._
  val dfTagsOfTag: Dataset[Tag] = dfTags.as[Tag]
  dfTagsOfTag
    .take(10)
    .map(t => println(s"id = ${t.id}, tag = ${t.tag}"))



  sparkSession.close()



}
