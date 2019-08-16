package edu.escuelaing.arem.lab1.app;

import java.util.Scanner;
import java.util.InputMismatchException;

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
            System.out.println("6. eliminar un dato ingresado"); 
            System.out.println("7. salir");
          try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("ingrese la cantidad de datos");
                        int a =sn.nextInt();
                        for(int i=0;i<a;i++){
                            li.anadir(sn.nextFloat());
                        }
                        break;
                    case 2:
                        System.out.println("digite el nuevo dato");                                
                        li.anadir(sn.nextFloat());
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
                        System.out.println("la desviacion estandar es igual a -> "+Float.toString(desviacion(li)));
                        break;
                    case 6:
                        System.out.println("ingrese el dato que desea eliminar");
                        break;
                    case 7:
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

    /**
     * este metodo se encarga de sacar la media de una lista de datos previamente ingresada por el usuario
     * @param ll ,este parametro corresponde a una lista enlazada
     * @return un flotante 
     */
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
    /**
     * este metodo se encarga de calcular la desviacion estandar de los datos previamente ingresados por el usuario
     * @param ll likendList
     * @return flotante
     */
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
