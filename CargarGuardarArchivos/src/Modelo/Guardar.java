/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Control;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Gustavo
 */
public class Guardar {

    private Control c;

    public Guardar(Control c) {
        this.c = c;
    }

    public void guardarArchivo() {
        try {
            String texto = c.getV().getVisor().getText();
            System.out.println("verdade: "+c.getA().getAbrir());
            File archivo = new File(c.getA().getAbrir().getAbsolutePath());
            System.out.println("archivo: "+archivo);
            if(archivo.exists()){
                
                FileWriter archivoAEscribir = new FileWriter(archivo);
                BufferedWriter escribiendo = new BufferedWriter(archivoAEscribir);
                escribiendo.write(texto);
                escribiendo.close();
            }else{
                new GuardarComo(c);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
