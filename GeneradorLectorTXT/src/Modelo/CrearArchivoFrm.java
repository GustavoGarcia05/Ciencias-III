/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Gustavo
 */
public class CrearArchivoFrm {

    protected String contenido;
    protected String[] conte;

    public CrearArchivoFrm(String nombre, String[] texto) {
        try {

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
        String r = "../GeneradorLectorTXT/src/Salidas/" + nombre + "_FrmAnalizador.txt";
        return r;
    }

    protected void escribirSentencia() {
        for (int i = 0; i < conte.length; i++) {
            contenido += "case " + conte[i] + ":\n"
                    + "resultado += \" <Reservada " + conte[i].toLowerCase() + ">\\t\" + lexicos.lexemas + \"\\n\";\n"
                    + "break;\n";
        }
    }

}
