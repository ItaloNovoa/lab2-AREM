package edu.escuelaing.arem.lab1.app;


/**
 * esta clase se encarga de ofrecer un menu con ciertas opciones de resultados estadisticos para un usuario
 * a travez de un menu basico y facil de entender al usuario final
 * @author 2135142
 */

public class menu 
{
    public menu(){

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
