package edu.escuelaing.arem.lab1.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest{
    
    @Test
    public void basicOperationsTest(){
        linkedList lista = new linkedList();
        lista.anadir(4);
        assertEquals(4.0, lista.getCabeza().getData(),0.001);
        lista.eliminar(4);
        assertNull(lista.getCabeza());
    }

    @Test
    public void media(){
        linkedList lista = new linkedList();
        lista.anadir(15);
        lista.anadir(18);
        lista.anadir(14);
        lista.anadir(13);
        assertEquals(15.0, menu.media(lista),0.001);
    }

    @Test
    public void media2(){
        linkedList lista = new linkedList();
        lista.anadir(400);
        lista.anadir(500);
        lista.anadir(510);
        lista.anadir(520);
        assertNotEquals(507.0, menu.media(lista),0.001);
    }

    @Test
    public void desviacion(){
        linkedList lista = new linkedList();
        lista.anadir(400);
        lista.anadir(500);
        lista.anadir(510);
        lista.anadir(515);
        lista.anadir(520);
        assertNotEquals((float)Math.sqrt(145), menu.desviacion(lista),0.001);
    }
}
