package edu.escuelaing.arem.lab1.app;

/**
 *
 * @author 2135142
 */
public class Nodo {
    
    Nodo siguiente;
    private float data;
    
    public Nodo(float data) {
        this.data = data;
    }
    
    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setNext(Nodo next) {
        this.siguiente = next;
    }

    public float getData() {
        return data;
    }

    public void setData(float data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" + "next=" + siguiente + ", data=" + data + '}';
    }
    
}