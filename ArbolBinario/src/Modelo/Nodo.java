/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
Template en c++ vs Generate en java
https://www.geeksforgeeks.org/templates-in-c-vs-generics-in-java/ 
public class Nodo<T> {
    
    public T info;
    public Nodo izq;
    public Nodo der;

    public Nodo(T info) {
        this.info = info;
        izq=der=null;
    }
*/
package Modelo;

/**
 *
 * @author Jess
 */
public class Nodo {
    
    public int info;
    public Nodo izq;
    public Nodo der;

    public Nodo(int info) {
        this.info = info;
        izq=der=null;
    }
    
    
    
    
}
