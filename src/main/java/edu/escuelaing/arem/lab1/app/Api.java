package edu.escuelaing.arem.lab1.app;

import spark.Request;
import spark.Response;
import static spark.Spark.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Api {

    /**
     * This main method uses SparkWeb static methods and lambda functions to create
     * a simple class to print mean and standar deviation due web app. It maps the
     * lambda function to the /hello relative URL.
     */
    public static void main(String[] args) {
        port(getPort());
        get("/inputdata", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
    }

    private static String inputDataPage(Request req, Response res) {
        String pageContent = "<!DOCTYPE html>"
            + "<html>" 
            + "<body>" 
            + "<h2>MEDIA & DESVIACION ESTANDAR</h2>"
            + "<form action=\"/results\">" 
            + "  Datos:<br>" 
            + "  <input type=\"text\" name=\"datos\" value=\" \">"
            + "  <br>" 
            + "<H3>Digitar los numeros separados por comas </H3>" 
            + "<H3>Ejemplo de entrada</H3>"
            + "<H3>13.0,16.0,17.0,18.0</H3>" 
            + "  <input type=\"submit\" value=\"Obtener estadisticos\">"
            + "</form>" 
            + "</body>" 
            + "</html>";
        return pageContent;
    }

    private static String resultsPage(Request req, Response res) {
        try {
            String a = req.queryParams("datos");
            List<String> myList = new ArrayList<String>(Arrays.asList(a.split(",")));
            linkedList ll = new linkedList();
            for (int i = 0; i < myList.size(); i++) {
                ll.anadir(Float.parseFloat(myList.get(i)));
            }
            menu m = new menu();
            String d = "la media resultante es: " + Float.toString(m.media(ll)) + "  Y la desviacion estandar es:  "+ Float.toString(m.desviacion(ll));
            return d;
        } catch (Exception e) {
            return "ingrese alguna entrada valida";
        }
    }

    /**
     * This method reads the default port as specified by the PORT variable in the
     * environment.
     *
     * Heroku provides the port automatically so you need this to run the project on
     * Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; // returns default port if heroku-port isn't set (i.e. on localhost)
    }

}