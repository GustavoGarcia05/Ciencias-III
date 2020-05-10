/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Jess
 */
public class ArbolBinario {

    public Nodo cabeza;

    public ArbolBinario() {
        this.cabeza = null;
    }

    // Metodos
    public void insertar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        Nodo actual = null;

        if (cabeza != null) {
            actual = ubicarLugar(dato);
            if (buscar(dato) != null && buscar(dato).info == dato) {
                return;
            } else {
                if (actual.info > dato) {
                    actual.izq = nuevoNodo;
                } else {
                    actual.der = nuevoNodo;
                }
            }
        } else {
            cabeza = nuevoNodo;
        }

    }

    public Nodo ubicarLugar(int dato) {
        Nodo actual = cabeza;
        Nodo anterior = null;

        if (cabeza == null) {
            System.out.println("El arbol esta vacio");
            return null;
        } else {

            while (actual != null && actual.info != dato) {
                anterior = actual;
                if (actual.info > dato) {
                    actual = actual.izq;
                } else {
                    actual = actual.der;
                }
            }
        }
        return anterior;
    }

    public Nodo buscar(int dato) {
        Nodo anterior = ubicarLugar(dato);

        if (cabeza == null) {
            return null;
        } else if (anterior.izq != null && anterior.izq.info == dato) {
            return anterior.izq;
        } else if (anterior.der != null && anterior.der.info == dato) {
            return anterior.der;
        } else {
            return null;
        }
    }

    public void eliminar(int dato) {
        Nodo actual = buscar(dato);
        Nodo anterior;
        if (actual != null) {
            if (actual.izq == null && actual.der == null) {
                eliminarHoja(dato);
            }
            if (actual.izq != null ^ actual.der != null) {
                eliminarUnaHoja(dato);

            }
            if (actual.izq != null && actual.der != null) {
                eliminarDosHojas(dato);

            }
        } else {
            System.out.println("El dato no existe en el arbol");
        }

    }

    public void eliminarHoja(int dato, Nodo actual) {
        Nodo anterior = ubicarLugar(dato);
    }

    public void eliminarUnaHoja(int dato) {
        System.out.println("segundo eliminar");
    }

    public void eliminarDosHojas(int dato) {
        System.out.println("tercer eliminar");
    }

}
