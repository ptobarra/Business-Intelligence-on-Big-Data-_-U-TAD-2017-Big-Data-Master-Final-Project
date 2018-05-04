# Business-Intelligence-on-Big-Data-_-U-TAD-2017-Big-Data-Master-Final-Project

Business Intelligence on Big Data _ U-TAD 2017 Big Data Master Final Project.

This is the final project I had to do to finish my Big Data Expert Program in U-TAD in September 2017. 
It uses the following technologies: Apache Spark v2.2.0, Python v2.7.3, Jupyter Notebook (PySpark), HDFS, Hive, Cloudera Impala, 
Cloudera HUE and Tableau.

Big Data Projects can be classified into two main groups: operative and research projects. Operative projects are the ones currently 
being done using the traditional tools but using Big Data technologies to carry them out on more data, faster, and spending less money. 
These are the projects carried out by companies that are entering the Big Data world. Business Intelligence, the capability to turn data 
into information, and information into knowledge, so that the decision-making process in businesses can be optimized, may be one example 
of these operations improvement projects.

I have used meteorological data from the National Oceanic and Atmospheric Administration NOAA of the United States; and have transformed these text csv files using Spark (programming in Python using Jupyter IDE) into a Dataframe table readable by Hadoop Hive to be used as a Datawarehouse table. Using Cloudera HUE, a Datamart Hive table will be created with the Maximum Daily Temperatures of all countries along 2016. Finally, using a ‘select’ clause in Impala commanded from BI SW Visualization Tableau, the temperatures Datamart table will be downloaded, so that Line Graphs showing the Maximum 2016 Daily World Temperatures filtered by country can be painted.
