/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author Gustavo
 */
public class CrearArchivoOperadoresLex {

    protected String contenido;
    protected String[] conte;

    public CrearArchivoOperadoresLex(String nombre, String[] texto) {
        try {
            /*
        Pair<String,String> operadores = new Pair<String,String>("#", "numeral");
        Pair<String,String> operadores2 = new Pair<String,String>("%", "porcentage");
        
        ArrayList<Pair> arreglo= new ArrayList<Pair>();
        arreglo.add(operadores);
        arreglo.add(operadores2);
             */
            String ruta = escribirRuta(nombre);
            contenido = "";
            if (texto == null) {
                System.out.println("No existe texto");
                return;
            }
            conte = texto;

            escribirSentencia();

            File file = new File(ruta);

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected String escribirRuta(String nombre) {
        String r = "../GeneradorLectorTXT/src/Salidas/" + nombre + "_FrmAnalizadorOPLex.txt";
        return r;
    }

    protected void escribirSentencia() {

        String[] aux;
        for (int i = 0; i < conte.length; i++) {
            aux = conte[i].split(",");

            contenido += "/* Operador " + aux[1].replace("_", " ") + " */\n"
                    + "( \"" + aux[0] + "\" ) {lexemas=yytext(); return " + aux[1] + ";}\n\n";
            
        }
        
    }

}
