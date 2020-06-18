/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author Gustavo
 */
public class LeerArchivo {

    protected String[] palabrasSepardas;

    public LeerArchivo(String rutaArchivo) {
        separarPorComa(leerString(rutaArchivo));
    }

    private String leerString(String rutaArchivo) {
        String cadena = "";
        String texto = "";

        FileReader fr = null;
        BufferedReader br = null;

        try {

            fr = new FileReader(rutaArchivo);
            br = new BufferedReader(fr);
            while ((cadena = br.readLine()) != null) {
                texto += cadena;

            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return texto;
    }

    protected String[] separarPorComa(String texto) {
        if (texto == null) {
            System.out.println("no existen textos ");
            return null;
        }
        palabrasSepardas = texto.split(",");

        for (int i = 0; i < palabrasSepardas.length; i++) {
            palabrasSepardas[i]=palabrasSepardas[i].replaceAll(" ", "");// remplaza el espacio por uno sin espacio
            System.out.println(palabrasSepardas[i]);
        }
        return palabrasSepardas;
    }

    public String[] getPalabrasSepardas() {
        return palabrasSepardas;
    }
    

}
