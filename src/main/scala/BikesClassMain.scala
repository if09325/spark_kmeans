import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.ml.evaluation.ClusteringEvaluator
import org.apache.spark.ml.feature.VectorAssembler

object BikesClassMain extends App {
  // SparkSession init
   lazy val spark : SparkSession = SparkSession.builder().appName("BikesClusteringApp").master("local").getOrCreate()

  //Loading Data
  lazy val bike = spark.read.json("C:\\Users\\oussa_k1flqh4\\IdeaProjects\\TestBikes\\media_in\\citybike.json")
  //Create a VectorAssembler
  lazy val featuresAssembler = new VectorAssembler().
      setInputCols(Array("latitude", "longitude")).
      setOutputCol("features")
  //Select only useful data for analysis and put'em inside a DataFrame
  val positionDF = bike.select(
      col("latitude"), col("longitude")
  )
  //transform positionDF into Vector
  val position = featuresAssembler.transform(positionDF)
  //K-means model training
  val kmeans = new KMeans().setK(2)
  val model = kmeans.fit(position)
  // Predict clusters
  val predictions = model.transform(position)
  //Save the prediction in a JSON format in order to visualize'em with Tableau
  //val dataJson = predictions.toDF(colNames = "Latitude","Longitude","GeoPoint","Cluster Attribué").write.json("C:\\Users\\oussa_k1flqh4\\IdeaProjects\\TestBikes\\media_out_k6")
  //val dataJson = predictions.toDF(colNames = "Latitude","Longitude","GeoPoint","Cluster Attribué").write.json("C:\\Users\\oussa_k1flqh4\\IdeaProjects\\TestBikes\\media_out_k4")
  //val dataJson = predictions.toDF(colNames = "Latitude","Longitude","GeoPoint","Cluster Attribué").write.json("C:\\Users\\oussa_k1flqh4\\IdeaProjects\\TestBikes\\media_out_k3")
  //val dataJson = predictions.toDF(colNames = "Latitude","Longitude","GeoPoint","Cluster Attribué").write.json("C:\\Users\\oussa_k1flqh4\\IdeaProjects\\TestBikes\\media_out_k2")

  // squared euclidean distance
  val evaluator = new ClusteringEvaluator()
  val de_2 = evaluator.evaluate(predictions)
  println(s"[Euclidean Distance]² :==:> $de_2")
  //Display results
  println("Centroids: ")
  model.clusterCenters.foreach(println)
}
