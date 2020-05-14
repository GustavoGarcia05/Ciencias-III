/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.BorderLayout;

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
        if (anterior == null) {
            return cabeza;
        }
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
        Nodo anterior = ubicarLugar(dato);

        if (actual != cabeza) {
            if (actual != null) {
                if (actual.izq == null && actual.der == null) {
                    eliminarHoja(dato, actual, anterior);
                }
                if (actual.izq != null ^ actual.der != null) {
                    eliminarUnaHoja(dato, actual, anterior);

                }
                if (actual.izq != null && actual.der != null) {
                    eliminarDosHojas(dato, actual, anterior);
                }
            } else {
                System.out.println("El dato no existe en el arbol");
            }
        } else {
            eliminarRaiz();
            System.out.println("se esta borrando la raiz");
        }

    }

    private void eliminarRaiz() {
        if (cabeza.izq == null && cabeza.der == null) {
            cabeza = null;
        } else if (cabeza.izq != null ^ cabeza.der != null) {
            if (cabeza.izq != null) {
                cabeza = cabeza.izq;
            } else {
                cabeza = cabeza.der;

            }
        } else {
            Nodo antTtemp = cabeza;
            Nodo temp = cabeza.izq;

            while (temp.der != null) {
                antTtemp = temp;
                temp = temp.der;
            }

            antTtemp.izq = temp.izq;
            antTtemp.der = temp.der;

            temp.izq = cabeza.izq;
            temp.der = cabeza.der;

            cabeza = temp;
        }
    }

    private void eliminarHoja(int dato, Nodo actual, Nodo anterior) {

        if (anterior.izq == actual) {
            anterior.izq = null;
        } else {
            anterior.der = null;
        }
        System.out.println("Primer eliminar");

    }

    private void eliminarUnaHoja(int dato, Nodo actual, Nodo anterior) {
        if (anterior.izq == actual) {
            if (actual.izq != null) {
                anterior.izq = actual.izq;
            } else {
                anterior.izq = actual.der;
            }
        } else {
            if (actual.izq != null) {
                anterior.der = actual.izq;
            } else {
                anterior.der = actual.der;
            }
        }
        System.out.println("segundo eliminar");
    }

    private void eliminarDosHojas(int dato, Nodo actual, Nodo anterior) {
        Nodo AnteriorTemporal = actual;
        Nodo temporal = actual.izq;

        while (temporal.der != null) {
            AnteriorTemporal = temporal;
            temporal = temporal.der;
        }

        AnteriorTemporal.izq = temporal.izq;
        AnteriorTemporal.der = temporal.der;

        temporal.izq = actual.izq;
        temporal.der = actual.der;

        if (anterior.izq == actual) {
            anterior.izq = temporal;
        } else {
            anterior.der = temporal;
        }
        System.out.println("tercer eliminar: " + actual.info);
    }

}
