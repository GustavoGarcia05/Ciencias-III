/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador;

import java.io.File;
import java.io.IOException;


/**
 *
 * @author mdelgado
 */
public class AnalizadorLexico {
    public static void main(String[] args) throws Exception {
        String camino= "../LexicoClase/src/Analizador/Lexico.flex";
        generarLex(camino);
    }
    public static void generarLex(String camino) throws IOException, Exception {
        File arc; 
        arc = new File(camino);
        JFlex.Main.generate(arc);        
    }
}
