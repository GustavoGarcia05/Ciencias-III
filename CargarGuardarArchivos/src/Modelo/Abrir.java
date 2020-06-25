/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Control;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;

/**
 *
 * @author Gustavo
 */
public class Abrir {

    private Control c;
    private String texto, linea;

    public Abrir(Control c) {
        this.c = c;
        texto = "";
        linea = "";
    }

    private File abrir = null;

    public String abrirArchivo() {

        try {
            JFileChooser archivo = new JFileChooser(c.getRutaInicial());
            int opcionElegida = archivo.showOpenDialog(c.getV());

            if (opcionElegida == JFileChooser.APPROVE_OPTION) {
                //File abrir = archivo.getSelectedFile();
                 abrir = archivo.getSelectedFile();

                FileReader archivoALeer = new FileReader(abrir);
                BufferedReader leyendo = new BufferedReader(archivoALeer);

                while ((linea = leyendo.readLine()) != null) {
                    texto += linea + "\n";
                }
                leyendo.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public File getAbrir() {
        return abrir;
    }

}
