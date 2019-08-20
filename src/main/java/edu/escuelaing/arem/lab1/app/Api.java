package edu.escuelaing.arem.lab1.app;

 
import static spark.Spark.get;
import static spark.Spark.port;
 
public class Api {
	public static void main(String[] args) {
		port(8080);
		get("/helloworld", (req, res) -> "Hello " + req.queryParams("name"));
	}	
}