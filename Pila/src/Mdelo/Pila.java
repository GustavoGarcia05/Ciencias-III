/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mdelo;

/**
 *
 * @author Gustavo
 */
public class Pila {

    public Nodo cab;

    public Pila() {
        this.cab = null;
    }

    public void Insertar(int dato) {
        Nodo aux = new Nodo(dato);
        if (cab == null) {
            cab = aux;
        } else {
            aux.sig = cab;
            cab = aux;
        }
    }

    public void eliminar() {
        if (cab != null) {
            cab = cab.sig;
        } 
    }

    public boolean estaVacia() {
        boolean vacia = true;
        if (cab != null) {
            vacia = false;
        } else {
            vacia = false;
        }
        return vacia;
    }

    public void listar() {
        Nodo aux = cab;
        if (cab != null) {
            while (aux != null) {
                System.out.println("numero: " + aux.info);
                aux = aux.sig;
            }
        }else{
            System.out.println("La pila esta vacia");
        }
    }

}
