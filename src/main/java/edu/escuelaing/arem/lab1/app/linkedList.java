/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.lab1.app;

/**
 *esta clase es una implementacion de una linkend list
 * @author 2135142
 */

public class linkedList {
    
    private Nodo cabeza;
    
    /**
     * este metodo añade un elemento al final de la lista enlazada
     * @param data
     */
    public void añadir(float data) {
        if(cabeza == null) {
            cabeza = new Nodo(data);
            return;
        }
    
        Nodo act = cabeza;
        while(act.getSiguiente()!= null) {
            act = act.getSiguiente();
        }
        act.siguiente = new Nodo(data);
    }

    /**
     * este metodo se encarga de añadir un elemento al final de una lista enlazada
     * @param data
     */
    public void AñadirAlFinal(float data) {
    
        Nodo newCabeza = new Nodo(data);
        newCabeza.siguiente = cabeza;
        cabeza = newCabeza;
        
    }

    /**
     * este metodo elimina el primer elemento que sea igual al del parametro
     * @param data
     */
    public void eliminar(float data) {
     
        if(cabeza == null) return;
        if(cabeza.getData() == data) {
            cabeza = cabeza.getSiguiente();
            return;
        }
        
        Nodo current = cabeza;
        while(current.getSiguiente()!= null) {
            if (current.getSiguiente().getData() == data) {
                current.siguiente = current.siguiente.siguiente;
                return;
            }
            current = current.siguiente;
        }        
    }

    /**
     * obtiene la cabeza o el primer elemento de la lista enlazada
     * @return
     */
    public Nodo getCabeza() {
        return cabeza;
    }

    /**
     * cambia el nodo principal por el nodo ingresado
     * @param head
     */
    public void setcabeza(Nodo head) {
        this.cabeza = head;
    }

    @Override
    public String toString() {
        return "linkedList{" + "head=" + cabeza.toString() + '}';
    }   
}

