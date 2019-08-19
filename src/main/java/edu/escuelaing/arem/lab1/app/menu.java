package edu.escuelaing.arem.lab1.app;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;
/**
 * esta clase se encarga de ofrecer un menu con ciertas opciones de resultados estadisticos para un usuario
 * a travez de un menu basico y facil de entender al usuario final
 * @author 2135142
 */

public class menu 
{
    /**
     * metodo principal de la clase el cual se encarga de ofrecer las distintas funciones estadisticas mostradas
     * @param args
     */
    public static void main(String[] args) {
        File currentDirFile = new File("");
        String helper = currentDirFile.getAbsolutePath();
        System.out.println(helper);
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        linkedList li=new linkedList();

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File (helper+"\\entrada.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null)
            li.anadir(Float.parseFloat(linea));
        System.out.println("la media es --> "+media(li));
        System.out.println("la desviacion es --> "+desviacion(li));
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
    }

    /**
     * este metodo se encarga de sacar la media de una lista de datos previamente ingresada por el usuario
     * @param ll ,este parametro corresponde a una lista enlazada
     * @return un flotante 
     */
    public static float media(linkedList ll){
        float media =ll.getCabeza().getData();
        int n=1;
        Nodo current=ll.getCabeza();
        while(current.getSiguiente()!= null) {
            current = current.siguiente;
            media+=current.getData();
            n++;
        }
        return (media/n);
    }
    /**
     * este metodo se encarga de calcular la desviacion estandar de los datos previamente ingresados por el usuario
     * @param ll likendList
     * @return flotante
     */
    public static float desviacion(linkedList ll){
        float media =media(ll);
        int n=0;
        float desviacion=(ll.getCabeza().getData()-media)*(ll.getCabeza().getData()-media);
        Nodo current=ll.getCabeza();
        while(current.getSiguiente()!= null) {
            current = current.siguiente;
            desviacion+=(current.getData()-media)*(current.getData()-media);
            n++;
        }
        return (float)Math.sqrt(desviacion/n);
    }
    
}
