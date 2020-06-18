
import Modelo.CrearArchivoFrm;
import Modelo.CrearArchivoLex;
import Modelo.CrearArchivoOperadoresFrm;
import Modelo.CrearArchivoOperadoresLex;
import Modelo.LeerArchivo;
import Modelo.LeerArchivoOperadores;
import java.util.ArrayList;
import javafx.util.Pair;

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
        /*
        LeerArchivo tokens = new LeerArchivo("../GeneradorLectorTXT/src/Salidas/Palabras.txt");
        CrearArchivoFrm crear = new CrearArchivoFrm(nombre,tokens.getPalabrasSepardas());
        CrearArchivoLex crearLex = new CrearArchivoLex(nombre,tokens.getPalabrasSepardas());
        */
        LeerArchivoOperadores leerOp = new LeerArchivoOperadores("../GeneradorLectorTXT/src/Salidas/Operadores.txt");
        CrearArchivoOperadoresLex crearOPLex = new CrearArchivoOperadoresLex(nombre, leerOp.getPalabrasSepardas());
        CrearArchivoOperadoresFrm crearOPFrm = new CrearArchivoOperadoresFrm(nombre,leerOp.getPalabrasSepardas());
        
    }
    
    
}
