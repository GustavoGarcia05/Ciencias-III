
import Modelo.ArbolBinario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jess
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArbolBinario ab = new ArbolBinario();
        ab.buscar(0);
        //ab.eliminar(16);
        ab.insertar(0);
        ab.insertar(10);
        ab.insertar(15);
        ab.insertar(5);
        ab.insertar(3);
        ab.insertar(6);
        ab.insertar(12);
        ab.insertar(18);
        ab.insertar(15);
        
        System.out.println("dato buscado: "+ab.buscar(3));
        
        System.out.println("esta es la cabeza: "+ab.cabeza.info);
        ab.eliminar(0);
        System.out.println("esta es la cabeza: "+ab.cabeza.info);
        System.out.println("esta es la izquierda: "+ab.cabeza.izq);
   
        
        
        
        
         
        
        
        
        
    }

}
