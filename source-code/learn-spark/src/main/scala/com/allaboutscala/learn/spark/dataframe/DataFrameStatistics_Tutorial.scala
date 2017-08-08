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
object DataFrameStatistics_Tutorial extends App with Context {

  // Create a dataframe from tags file question_tags_10K.csv
  val dfTags = sparkSession
    .read
    .option("header", "true")
    .option("inferSchema", "true")
    .csv("src/main/resources/question_tags_10K.csv")
    .toDF("id", "tag")


  // Create a dataframe from questions file questions_10K.csv
  val dfQuestionsCSV = sparkSession
    .read
    .option("header", "true")
    .option("inferSchema", "true")
    .option("dateFormat","yyyy-MM-dd HH:mm:ss")
    .csv("src/main/resources/questions_10K.csv")
    .toDF("id", "creation_date", "closed_date", "deletion_date", "score", "owner_userid", "answer_count")


  // cast columns to data types
  val dfQuestions = dfQuestionsCSV.select(
    dfQuestionsCSV.col("id").cast("integer"),
    dfQuestionsCSV.col("creation_date").cast("timestamp"),
    dfQuestionsCSV.col("closed_date").cast("timestamp"),
    dfQuestionsCSV.col("deletion_date").cast("date"),
    dfQuestionsCSV.col("score").cast("integer"),
    dfQuestionsCSV.col("owner_userid").cast("integer"),
    dfQuestionsCSV.col("answer_count").cast("integer")
  )


  // Average
  import org.apache.spark.sql.functions._
  dfQuestions
    .select(avg("score"))
    .show()


  // Maximum
  dfQuestions
    .select(max("score"))
    .show()


  // Minimum
  dfQuestions
    .select(min("score"))
    .show()


  // Mean
  dfQuestions
    .select(mean("score"))
    .show()


  // Sum
  dfQuestions
    .select(sum("score"))
    .show()


  // Group by with statistics
  dfQuestions
    .filter("id > 400 and id < 450")
    .filter("owner_userid is not null")
    .join(dfTags, dfQuestions.col("id").equalTo(dfTags("id")))
    .groupBy(dfQuestions.col("owner_userid"))
    .agg(avg("score"), max("answer_count"))
    .show()


  // DataFrame Statistics using describe() method
  val dfQuestionsStatistics = dfQuestions.describe()
  dfQuestionsStatistics.show()


  // Correlation
  val correlation = dfQuestions.stat.corr("score", "answer_count")
  println(s"correlation between column score and answer_count = $correlation")


  // Covariance
  val covariance = dfQuestions.stat.cov("score", "answer_count")
  println(s"covariance between column score and answer_count = $covariance")


  // Frequent Items
  val dfFrequentScore = dfQuestions.stat.freqItems(Seq("answer_count"))
  dfFrequentScore.show()


  // Crosstab
  val dfScoreByUserid = dfQuestions
    .filter("owner_userid > 0 and owner_userid < 20")
    .stat
    .crosstab("score", "owner_userid")
  dfScoreByUserid.show(10)


  // Stratified sampling using sampleBy
  // find all rows where answer_count in (5, 10, 20)
  val dfQuestionsByAnswerCount = dfQuestions
    .filter("owner_userid > 0")
    .filter("answer_count in (5, 10, 20)")

  // count how many rows match answer_count in (5, 10, 20)
  dfQuestionsByAnswerCount
    .groupBy("answer_count")
    .count()
    .show()

  // Create a fraction map where we are only interested:
  // - 50% of the rows that have answer_count = 5
  // - 10% of the rows that have answer_count = 10
  // - 100% of the rows that have answer_count = 20
  // Note also that fractions should be in the range [0, 1]
  val fractionKeyMap = Map(5 -> 0.5, 10 -> 0.1, 20 -> 1.0)

  // Stratified sample using the fractionKeyMap.
  dfQuestionsByAnswerCount
    .stat
    .sampleBy("answer_count", fractionKeyMap, 7L)
    .groupBy("answer_count")
    .count()
    .show()

  // Note that changing the random seed will modify your sampling outcome. As an example, let's change the random seed to 37.
  dfQuestionsByAnswerCount
    .stat
    .sampleBy("answer_count", fractionKeyMap, 37L)
    .groupBy("answer_count")
    .count()
    .show()


  // Approximate Quantile
  val quantiles = dfQuestions
    .stat
    .approxQuantile("score", Array(0, 0.5, 1), 0.25)
  println(s"Qauntiles segments = ${quantiles.toSeq}")


  // You can verify the quantiles statistics above using Spark SQL as follows:
  dfQuestions.createOrReplaceTempView("so_questions")
  sparkSession
    .sql("select min(score), percentile_approx(score, 0.25), max(score) from so_questions")
    .show()


  // Bloom Filter
  val tagsBloomFilter = dfTags.stat.bloomFilter("tag", 1000L, 0.1)
  println(s"bloom filter contains java tag = ${tagsBloomFilter.mightContain("java")}")
  println(s"bloom filter contains some unknown tag = ${tagsBloomFilter.mightContain("unknown tag")}")


  // Count Min Sketch
  val cmsTag = dfTags.stat.countMinSketch("tag", 0.1, 0.9, 37)
  val estimatedFrequency = cmsTag.estimateCount("java")
  println(s"Estimated frequency for tag java = $estimatedFrequency")


  // Sampling With Replacement
  val dfTagsSample = dfTags.sample(true, 0.2, 37L)
  println(s"Number of rows in sample dfTagsSample = ${dfTagsSample.count()}")
  println(s"Number of rows in dfTags = ${dfTags.count()}")





  sparkSession.close()
}
