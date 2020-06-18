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
        String r = "../GeneradorLectorTXT/src/Salidas/" + nombre + "_FrmAnalizadorOP.txt";
        return r;
    }

    protected void escribirSentencia() {
        Pair<String,String> pareja;
        ArrayList<Pair> parejas = new ArrayList<Pair>();
        String[] aux;
        for (int i = 0; i < conte.length; i++) {
            aux = conte[i].split(",");
            pareja = new Pair<String,String>(aux[0],aux[1]);
            parejas.add(pareja);
            
        }
        
        for (int j = 0; j < parejas.size(); j++) {
            contenido += "/* Operador logico " + parejas.get(j).getValue() + " */\n"
                    + "( \"" + parejas.get(j).getKey() + "\" ) {lexemas=yytext(); return " + parejas.get(j).getValue() + ";}\n\n";
        }
    }

}
