# Source Code For Scala Tutorials From www.allaboutscala.com/big-data/spark/
## Introduction
The Scala programming language is rapidly growing in popularity! Sadly, most of the online tutorials do not provide a step-by-step guide :(
 
At www.allaboutscala.com, we provide a complete beginner's tutorial to help you learn Scala in **small**, **simple** and **easy steps**.

- Tutorials are organized such that they allow you to **learn gradually**.
- Tutorials are written by taking into account the **complete beginner**.
- Tutorials will make you proficient with the same professional **tools used by the Scala experts**.

# Learn Spark
- Code snippets for [Learn Spark](http://allaboutscala.com/big-data/spark/)
- For additional details, please visit www.allaboutscala.com

The examples below are the source code for Spark Tutorials from [allaboutscala.com](http://allaboutscala.com/big-data/spark/)

# Project Setup
- [StackOverflow dataset](http://allaboutscala.com/big-data/spark/#stackoverflow-dataset)
- [Add Apache Spark 2.0 SBT dependencies](http://allaboutscala.com/big-data/spark/#spark-sbt-dependencies)
- [Bootstrap a SparkSession](http://allaboutscala.com/big-data/spark/#bootstrap-sparksession)

# DataFrame SQL Query
- [DataFrame Introduction](http://allaboutscala.com/big-data/spark/#dataframe-introduction)
- [Create a DataFrame from reading a CSV file](http://allaboutscala.com/big-data/spark/#create-dataframe-read-csv)
- [DataFrame schema](http://allaboutscala.com/big-data/spark/#print-dataframe-schema)
- [Select columns from a dataframe](http://allaboutscala.com/big-data/spark/#dataframe-select-columns)
- [Filter by column value of a dataframe](http://allaboutscala.com/big-data/spark/#filter-column-dataframe)
- [Count rows of a dataframe](http://allaboutscala.com/big-data/spark/#dataframe-count-rows)
- [SQL like query](http://allaboutscala.com/big-data/spark/#dataframe-sql-like-query)
- [Multiple filter chaining](http://allaboutscala.com/big-data/spark/#dataframe-multiple-filter-chains)
- [SQL IN clause](http://allaboutscala.com/big-data/spark/#dataframe-sql-in-clause)
- [SQL Group By](http://allaboutscala.com/big-data/spark/#dataframe-sql-group-by)
- [SQL Group By with filter](http://allaboutscala.com/big-data/spark/#dataframe-sql-group-by-count-filter)
- [SQL order by](http://allaboutscala.com/big-data/spark/#dataframe-order-by)
- [Cast columns to specific data type](http://allaboutscala.com/big-data/spark/#dataframe-cast-columns-data-type)
- [Operate on a filtered dataframe](http://allaboutscala.com/big-data/spark/#dataframe-operations)
- [DataFrame Join](http://allaboutscala.com/big-data/spark/#dataframe-join)
- [Join and select columns](http://allaboutscala.com/big-data/spark/#dataframe-join-select-columns)
- [Join on explicit columns](http://allaboutscala.com/big-data/spark/#dataframe-join-explicit-columns)
- [Inner Join](http://allaboutscala.com/big-data/spark/#dataframe-inner-join)
- [Left Outer Join](http://allaboutscala.com/big-data/spark/#dataframe-left-outer-join)
- [Right Outer Join](http://allaboutscala.com/big-data/spark/#dataframe-right-outer-join)
- [Distinct](http://allaboutscala.com/big-data/spark/#dataframe-distinct)

# Spark SQL
- [Spark SQL Introduction](http://allaboutscala.com/big-data/spark/#spark-sql-introduction)
- [Register temp table from dataframe](http://allaboutscala.com/big-data/spark/#register-temp-table-from-dataframe)
- [List all tables in Spark's catalog](http://allaboutscala.com/big-data/spark/#list-tables-spark-catalog)
- [List catalog tables using Spark SQL](http://allaboutscala.com/big-data/spark/#list-catalog-tables-spark-sql)
- [Select columns](http://allaboutscala.com/big-data/spark/#spark-sql-select-columns)
- [Filter by column value](http://allaboutscala.com/big-data/spark/#spark-sql-filter-column-value)
- [Count number of rows](http://allaboutscala.com/big-data/spark/#spark-sql-count-rows)
- [SQL like](http://allaboutscala.com/big-data/spark/#spark-sql-like)
- [SQL where with and clause](http://allaboutscala.com/big-data/spark/#spark-sql-where-with-and-clause)
- [SQL IN clause](http://allaboutscala.com/big-data/spark/#spark-sql-in-clause)
- [SQL Group By](http://allaboutscala.com/big-data/spark/#spark-sql-group-by)
- [SQL Group By with having clause](http://allaboutscala.com/big-data/spark/#spark-sql-group-by-having-clause)
- [SQL Order by](http://allaboutscala.com/big-data/spark/#spark-sql-order-by)
- [Typed columns, filter and create temp table](http://allaboutscala.com/big-data/spark/#spark-sql-typed-column-filter-temp-table)
- [SQL Inner Join](http://allaboutscala.com/big-data/spark/#spark-sql-inner-join)
- [SQL Left Outer Join](http://allaboutscala.com/big-data/spark/#spark-sql-left-outer-join)
- [SQL Right Outer Join](http://allaboutscala.com/big-data/spark/#spark-sql-right-outer-join)
- [SQL Distinct](http://allaboutscala.com/big-data/spark/#spark-sql-distinct)
- [Register User Defined Function (UDF)](http://allaboutscala.com/big-data/spark/#spark-sql-udf)

# DataFrame Statistics
- [DataFrame Statistics Introduction](http://allaboutscala.com/big-data/spark/#dataframe-statistics-introduction)
- [Create DataFrame from CSV](http://allaboutscala.com/big-data/spark/#create-dataframe-csv)
- [Average](http://allaboutscala.com/big-data/spark/#dataframe-statistics-average)
- [Maximum](http://allaboutscala.com/big-data/spark/#dataframe-statistics-max)
- [Minimum](http://allaboutscala.com/big-data/spark/#dataframe-statistics-minimum)
- [Mean](http://allaboutscala.com/big-data/spark/#dataframe-statistics-mean)
- [Sum](http://allaboutscala.com/big-data/spark/#dataframe-statistics-sum)
- [Group by query with statistics](http://allaboutscala.com/big-data/spark/#dataframe-statistics-group-by-query)
- [DataFrame Statistics using describe() method](http://allaboutscala.com/big-data/spark/#dataframe-statistics-describe-method)
- [Correlation](http://allaboutscala.com/big-data/spark/#dataframe-statistics-correlation)
- [Covariance](http://allaboutscala.com/big-data/spark/#dataframe-statistics-covariance)
- [Frequent Items](http://allaboutscala.com/big-data/spark/#dataframe-statistics-frequent-items)
- [Crosstab](http://allaboutscala.com/big-data/spark/#dataframe-statistics-crosstab)
- [Stratified sampling using sampleBy](http://allaboutscala.com/big-data/spark/#dataframe-statistics-sampleby)
- [Approximate Quantile](http://allaboutscala.com/big-data/spark/#dataframe-statistics-approxquantile)
- [Bloom Filter](http://allaboutscala.com/big-data/spark/#spark-dataframe-bloom-filter)
- [Count Min Sketch](http://allaboutscala.com/big-data/spark/#dataframe-statistics-count-min-sketch)
- [Sampling With Replacement](http://allaboutscala.com/big-data/spark/#dataframe-sampling-with-replacement)

# DataFrame Operations
- [DataFrame Operations Introduction](http://allaboutscala.com/big-data/spark/#dataframe-operations-introduction)
- [Setup DataFrames](http://allaboutscala.com/big-data/spark/#dataframe-operations-setup)
- [Convert DataFrame row to Scala case class](http://allaboutscala.com/big-data/spark/#dataframe-convert-row-scala-case-class)
- [DataFrame row to Scala case class using map()](http://allaboutscala.com/big-data/spark/#dataframe-row-scala-case-class-map-method)
- [Create DataFrame from collection](http://allaboutscala.com/big-data/spark/#create-dataframe-from-collection)
- [DataFrame Union](http://allaboutscala.com/big-data/spark/#dataframe-union)
- [DataFrame Intersection](http://allaboutscala.com/big-data/spark/#dataframe-intersection)
- [Append column to DataFrame using withColumn()](http://allaboutscala.com/big-data/spark/#dataframe-append-column-withcolumn-method)

# Spark Functions
- [Create DataFrame from Tuples](http://allaboutscala.com/big-data/spark/#create-dataframe-from-tuples)
- [Get DataFrame column names](http://allaboutscala.com/big-data/spark/#get-dataframe-column-names)
- [DataFrame column names and types](http://allaboutscala.com/big-data/spark/#dataframe-column-names-and-types)
- [Nested Json into DataFrame using explode method](http://allaboutscala.com/big-data/spark/#json-into-dataframe-using-explode-method)
- [Concatenate DataFrames using join() method](http://allaboutscala.com/big-data/spark/#concatenate-dataframes-using-join)
- [Search DataFrame column using array_contains() method](http://allaboutscala.com/big-data/spark/#search-dataframe-column-using-array-contains-method)
- [Check DataFrame column exists](http://allaboutscala.com/big-data/spark/#check-dataframe-column-exists)
- [Split DataFrame Array column](http://allaboutscala.com/big-data/spark/#split-dataframe-array-column)
- [Rename DataFrame column](http://allaboutscala.com/big-data/spark/#rename-dataframe-column)
- [Create DataFrame constant column](http://allaboutscala.com/big-data/spark/#create-dataframe-constant-column)
- [DataFrame new column with User Defined Function (UDF)](http://allaboutscala.com/big-data/spark/#dataframe-new-column-with-udf)
- [DataFrame first row](http://allaboutscala.com/big-data/spark/#dataframe-first-row)
- [Format DataFrame column](http://allaboutscala.com/big-data/spark/#format-dataframe-column)
- [DataFrame column hashing](http://allaboutscala.com/big-data/spark/#dataframe-column-hashing)
- [DataFrame String functions](http://allaboutscala.com/big-data/spark/#dataframe-string-functions)
- [DataFrame drop null](http://allaboutscala.com/big-data/spark/#dataframe-drop-null)

Stay in touch via [Facebook](http://www.facebook.com/allaboutscala) and [Twitter](https://twitter.com/NadimBahadoor) for upcoming tutorials!

## Contact
Nadim Bahadoor at http://allaboutscala.com/contact/

## License
Apache 2.0 License - see the LICENSE.TXT file 
