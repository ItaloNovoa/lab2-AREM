/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.lab1.app;

/**
 *
 * @author 2138850
 */

public class linkedList {
    
    private Nodo cabeza;
    
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
    
    public void AñadirAlFinal(float data) {
    
        Nodo newCabeza = new Nodo(data);
        newCabeza.siguiente = cabeza;
        cabeza = newCabeza;
        
    }
    
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

    public Nodo getCabeza() {
        return cabeza;
    }

    
    public void setcabeza(Nodo head) {
        this.cabeza = head;
    }

    @Override
    public String toString() {
        return "linkedList{" + "head=" + cabeza.toString() + '}';
    }   
}

