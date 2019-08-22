package edu.escuelaing.arem.lab1.app;

 
import spark.Request;
import spark.Response;
import static spark.Spark.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class Api {
	/**
	public static void main(String[] args) {
		port(8080);
		ArrayList
		get("/helloworld", (req, res) -> "Hello " + req.queryParams("name"));
	}**/

	/**
     * This main method uses SparkWeb static methods and lambda functions to
     * create a simple Hello World web app. It maps the lambda function to the
     * /hello relative URL.
     */
    public static void main(String[] args) {
        port(getPort());
        get("/inputdata", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
    }

    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>MEDIA & DESVIACION ESTANDAR</h2>"
                + "<form action=\"/results\">"
                + "  Datos:<br>"
                + "  <input type=\"text\" name=\"datos\" value=\" \">"
                + "  <br>"
                + "  <input type=\"submit\" value=\"Obtener estadisticos\">"
                + "</form>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    private static String resultsPage(Request req, Response res) {
		String a=req.queryParams("datos");
		List<String> myList = new ArrayList<String>(Arrays.asList(a.split(",")));
		linkedList ll=new linkedList();
		for (int i = 0; i < myList.size(); i++) {
					ll.anadir(Float.parseFloat(myList.get(i)));	
		}
		menu m = new menu();		
		System.out.println(m.desviacion(ll));
		String d="la media resultante es: "+Float.toString(m.media(ll))+ "  Y la desviacion estandar es:  "+Float.toString(m.desviacion(ll));
		return d;
    }

    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     *
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

}