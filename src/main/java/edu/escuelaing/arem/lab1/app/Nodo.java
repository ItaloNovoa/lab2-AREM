package edu.escuelaing.arem.lab1.app;

/**
 * esta clase es la implementacion de un nodo para el uso de una lista enlazada
 * @author 2135142
 */
public class Nodo {
    
    Nodo siguiente;
    private float data;
    
    /**
     * clase principal encargada de crear el nodo
     * @param data
     */
    public Nodo(float data) {
        this.data = data;
    }
    
    /**
     * obtiene el nodo siguiente al cual este nodo esta vinculado
     * @return Nodo
     */
    public Nodo getSiguiente() {
        return siguiente;
    }
    /**
     * cambia el nodo siguiente al cual este se encuentra enlazado
     * @param next
     */
    public void setNext(Nodo next) {
        this.siguiente = next;
    }

    /**
     * obtiene el numero flotante con el cual fue asignado este nodo
     * @return float
     */
    public float getData() {
        return data;
    }

    /**
     * se encarga de cambiar el dato por uno nuevo y vincularlo con este nodo
     * @param data
     */
    public void setData(float data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" + "next=" + siguiente + ", data=" + data + '}';
    }
    
}