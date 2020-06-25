/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Abrir;
import Modelo.Guardar;
import Modelo.GuardarComo;
import Vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class Control implements ActionListener {

    private Ventana v;
    private Abrir a;
    private Guardar g;
    private GuardarComo gc;
    private String rutaInicial = "../CargarGuardarArchivos/src/Archivos";

    public Control(Ventana v) {
        this.v = v;
        a = new Abrir(this);
        g = new Guardar(this);
        gc = new GuardarComo(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == v.getAbrir()) {
            a.setTexto("");
            v.getVisor().setText(a.abrirArchivo());

        }
        if (e.getSource() == v.getGuardar()) {
            if (a.getAbrir()!= null) {
                g.guardarArchivo();
            }else{
               gc.guardarArchivo();
            }
        }
        if (e.getSource() == v.getGuardarComo()) {

            if (v.getVisor().getText().isEmpty()) {
                JOptionPane.showMessageDialog(v, "El documento no contiene textos");
            } else {
                gc.guardarArchivo();
            }

        }

    }

    public Ventana getV() {
        return v;
    }

    public String getRutaInicial() {
        return rutaInicial;
    }

    public Abrir getA() {
        return a;
    }

}
