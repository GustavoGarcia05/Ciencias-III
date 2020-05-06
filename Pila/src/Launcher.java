
import Mdelo.Pila;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gustavo
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pila prueba = new Pila();
        
        System.out.println("esta es la pila "+ prueba.cab);
        prueba.Insertar(16);
        System.out.println("dato "+ prueba.cab.info);
        prueba.Insertar(22);
        System.out.println("dato "+ prueba.cab.info);
        prueba.Insertar(30);
        prueba.Insertar(31);
        prueba.Insertar(32);
        prueba.listar();
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+");
        prueba.eliminar();
        prueba.listar();
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+");
        prueba.eliminar();
        prueba.eliminar();
        prueba.eliminar();
        prueba.eliminar();
        prueba.eliminar();
        prueba.eliminar();
        prueba.listar();
    }
    
}
