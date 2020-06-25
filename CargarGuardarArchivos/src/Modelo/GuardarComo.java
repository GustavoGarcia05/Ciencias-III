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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Gustavo
 */
public class GuardarComo {

    private Control c;

    public GuardarComo(Control c) {
        this.c = c;
    }

    public void guardarArchivo() {
        try {

            JFileChooser archivo = new JFileChooser(c.getRutaInicial());
            FileNameExtensionFilter txtFilter = new FileNameExtensionFilter(".txt", "txt");
            FileNameExtensionFilter cFilter = new FileNameExtensionFilter(".c", "c");

            archivo.addChoosableFileFilter(txtFilter);
            archivo.addChoosableFileFilter(cFilter);

            int opcionElegida = archivo.showOpenDialog(c.getV());

            if (opcionElegida == JFileChooser.APPROVE_OPTION) {
                File guardar = null;
                guardar = archivo.getSelectedFile();
                String aux = archivo.getFileFilter().getDescription();
                System.out.println(aux);
                FileWriter archivoAGuardar = null;

                if (guardar.exists()) {
                    int valoElegido = JOptionPane.showConfirmDialog(null, "El archivo ya existe, ¿desea rempazarlo?", "Reemplazar archivo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (valoElegido == 0) {
                        archivoAGuardar = new FileWriter(guardar);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se guardo ningun archivo");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Se ha creado el archivo");
                    if (aux.equals("Todos los Archivos")) {
                        archivoAGuardar = new FileWriter(guardar + ".c");
                    } else {
                        archivoAGuardar = new FileWriter(guardar + aux);

                    }

                }

                archivoAGuardar.write(c.getV().getVisor().getText());
                archivoAGuardar.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
