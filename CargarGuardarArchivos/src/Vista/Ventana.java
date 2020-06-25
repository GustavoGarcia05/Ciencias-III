/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Control;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Gustavo
 */
public class Ventana extends JFrame {

    private Control c;

    public Ventana() {

        c = new Control(this);

        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        inicializarBotones();
        inicializarCampoTexto();
        setResizable(false);
        setVisible(true);

    }

    private JButton abrir;
    private JButton guardar;
    private JButton guardarComo;

    private void inicializarBotones() {

        abrir = new JButton("Abrir");
        guardar = new JButton("Guardar");
        guardarComo = new JButton("Guardar Como");

        abrir.addActionListener(c);
        guardar.addActionListener(c);
        guardarComo.addActionListener(c);

        abrir.setBounds(400, 500, 100, 20);
        add(abrir);
        
        guardar.setBounds(abrir.getX()+abrir.getWidth()+10, 500, 100, 20);
        add(guardar);
        
        guardarComo.setBounds(guardar.getX()+guardar.getWidth()+10, 500, 150, 20);
        add(guardarComo);
    }

    private TextArea visor;

    private void inicializarCampoTexto() {
        visor = new TextArea();
        visor.setBounds(10, 10, 770, 400);
        add(visor);
    }

    public JButton getAbrir() {
        return abrir;
    }

    public JButton getGuardar() {
        return guardar;
    }

    public JButton getGuardarComo() {
        return guardarComo;
    }

    public TextArea getVisor() {
        return visor;
    }

}
