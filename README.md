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
![One](https://www.google.fr/url?sa=i&url=https%3A%2F%2Fendormitoire.wordpress.com%2F2017%2F11%2F06%2Freadme%2F&psig=AOvVaw0-ZlIiPwsgcu9XMepq5_Rb&ust=1587391752443000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKjFiKLV9OgCFQAAAAAdAAAAABAE)
