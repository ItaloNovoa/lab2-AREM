package edu.escuelaing.arem.lab1.app;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author 2135142
 */

public class menu 
{
    public static void main(String[] args) {
                
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        linkedList li=new linkedList();
        
        
 
        while (!salir) {
            System.out.println("Calculadora estadistica para la media y desviacion estandar");
            System.out.println("1. ingresar nueva coleccion de datos");
            System.out.println("2.ingresar nuevo dato");
            System.out.println("3.ver los datos ingresados");
            System.out.println("4.ver la media de los datos ingresados");
            System.out.println("5.ver la desviacion estandar de los datos ingresados"); 
            System.out.println("8. salir");
          try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("ingrese la cantidad de datos");
                        int a =sn.nextInt();
                        for(int i=0;i<a;i++){
                            li.añadir(sn.nextFloat());
                        }
                        System.out.println(li);
                        break;
                    case 2:
                        System.out.println("digite el nuevo dato");                                
                        li.añadir(sn.nextFloat());
                        System.out.println(li);
                        break;
                    case 3:
                        try{
                            Nodo current = li.getCabeza();
                            System.out.println(current.getData());
                            while(current.getSiguiente()!= null) {
                                System.out.println(current.getSiguiente().getData());
                                current = current.siguiente;
                            }
                        }catch(Exception e){
                            System.out.println("Digite primero los datos");
                        }
                    case 4:
                        System.out.println("la media es igual a -> "+Float.toString(media(li)));
                        break;
                    case 5:
                        System.out.println("la media es igual a -> "+Float.toString(desviacion(li)));
                        break;
                    case 6:
                        System.out.println("Fin"); 
                        salir=true;
                        break;
                        
                    default:
                        System.out.println("Solo nmeros entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero");
                sn.next();
            }
        }
        sn.close();  
    }
    private static float media(linkedList ll){
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
    
    private static float desviacion(linkedList ll){
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
