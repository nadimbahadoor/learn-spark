package com.allaboutscala.learn.spark.functions

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
object Tutorial_10_DataFrameColumnWithUDF extends App with Context {

  val donuts = Seq(("plain donut", 1.50), ("vanilla donut", 2.0), ("glazed donut", 2.50))
  val df = sparkSession.createDataFrame(donuts).toDF("Donut Name", "Price")


  import org.apache.spark.sql.functions._
  import sparkSession.sqlContext.implicits._


  val stockMinMax: (String => Seq[Int]) = (donutName: String) => donutName match {
    case "plain donut"    => Seq(100, 500)
    case "vanilla donut"  => Seq(200, 400)
    case "glazed donut"   => Seq(300, 600)
    case _                => Seq(150, 150)
  }

  val udfStockMinMax = udf(stockMinMax)
  val df2 = df.withColumn("Stock Min Max", udfStockMinMax($"Donut Name"))
  df2.show()
}
