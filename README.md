<h1> README</h1>
The program is launched in a single Spark Cluster locally 
The program may be launched using spark-submit on HDFS/OtherSources Stored Data. 
To do so, I can generate a jar using (package/assembly command in sbt-shell). 
The complete command is : 
--class BikesClassMain \
  --master YARN/MESOS \
  --deploy-mode cluster \
  --executor-memory 16G \
  /target/scala-2.12/bikes.jar

This program predict a number the a clusters using K-means model and Scala API with SparkSession and SparkML.
In order to validate the model I used Tableau Desktop to visualize the clusters.
In my opinion the model 4 is the right one. 

<h2>Lire le fichier DataViz.docx</h2>

