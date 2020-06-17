
import Modelo.CrearArchivo;
import Modelo.CrearArchivoLex;
import Modelo.LeerArchivo;

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
        new Launcher("Compilador");
    }
    
    public Launcher(String nombre) {
        LeerArchivo tokens = new LeerArchivo("../GeneradorLectorTXT/src/Salidas/Palabras.txt");
        CrearArchivo crear = new CrearArchivo(nombre,tokens.getPalabrasSepardas());
        CrearArchivoLex crearLex = new CrearArchivoLex(nombre,tokens.getPalabrasSepardas());
        
    }
    
    
}
