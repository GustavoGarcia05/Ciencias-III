/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;

/**
 *
 * @author mdelgado
 */
public class FrmAnalizador extends javax.swing.JFrame {

    /**
     * Creates new form FrmAnalizador
     */
    public FrmAnalizador() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonAnalisis = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Resultado = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAnalizarLex = new javax.swing.JTextArea();
        btnArchivo = new javax.swing.JButton();
        Borrar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotonAnalisis.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BotonAnalisis.setText("Análisis Léxico");
        BotonAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAnalisisActionPerformed(evt);
            }
        });

        Resultado.setColumns(20);
        Resultado.setRows(5);
        jScrollPane1.setViewportView(Resultado);

        txtAnalizarLex.setColumns(20);
        txtAnalizarLex.setRows(5);
        jScrollPane2.setViewportView(txtAnalizarLex);

        btnArchivo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnArchivo.setText("Abrir Fuente");
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        Borrar1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Borrar1.setText("Borrar");
        Borrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Borrar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotonAnalisis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(Borrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BotonAnalisis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Borrar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void analizarLexico() throws IOException {
        int cont = 1;

        String expr = (String) Resultado.getText();
        Lexico lexicos = new Lexico(new StringReader(expr));
        String resultado = "LINEA " + cont + "\t\tSIMBOLO\n";
        while (true) {
            Tokens token = lexicos.yylex();
            if (token == null) {
                txtAnalizarLex.setText(resultado);
                return;
            }
            switch (token) {
                case Linea:
                    cont++;
                    resultado += "LINEA " + cont + "\n";
                    break;
                case Comillas:
                    resultado += "  <Comillas>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Cadena:
                    resultado += "  <Tipo de dato>\t" + lexicos.lexemas + "\n";
                    break;
                case T_dato:
                    resultado += "  <Tipo de dato>\t" + lexicos.lexemas + "\n";
                    break;
                case If:
                    resultado += "  <Reservada if>\t" + lexicos.lexemas + "\n";
                    break;
                case Int:
                    resultado += "  <Reservada int>\t" + lexicos.lexemas + "\n";
                    break;
                case Else:
                    resultado += "  <Reservada else>\t" + lexicos.lexemas + "\n";
                    break;
                case Abstract:
                    resultado += "  <Reservada abstract>\t" + lexicos.lexemas + "\n";
                    break;
                case As:
                    resultado += "  <Reservada as>\t" + lexicos.lexemas + "\n";
                    break;
                case Base:
                    resultado += "  <Reservada base>\t" + lexicos.lexemas + "\n";
                    break;
                case Catch:
                    resultado += "  <Reservada catch>\t" + lexicos.lexemas + "\n";
                    break;
                case Checked:
                    resultado += "  <Reservada checked>\t" + lexicos.lexemas + "\n";
                    break;
                case Class:
                    resultado += "  <Reservada class>\t" + lexicos.lexemas + "\n";
                    break;
                case Const:
                    resultado += "  <Reservada const>\t" + lexicos.lexemas + "\n";
                    break;
                case Decimal:
                    resultado += "  <Reservada decimal>\t" + lexicos.lexemas + "\n";
                    break;
                case Default:
                    resultado += "  <Reservada default>\t" + lexicos.lexemas + "\n";
                    break;
                case Delegate:
                    resultado += "  <Reservada delegate>\t" + lexicos.lexemas + "\n";
                    break;
                case Enum:
                    resultado += "  <Reservada enum>\t" + lexicos.lexemas + "\n";
                    break;
                case Event:
                    resultado += "  <Reservada event>\t" + lexicos.lexemas + "\n";
                    break;
                case Explicit:
                    resultado += "  <Reservada explicit>\t" + lexicos.lexemas + "\n";
                    break;
                case Extern:
                    resultado += "  <Reservada extern>\t" + lexicos.lexemas + "\n";
                    break;
                case Finally:
                    resultado += "  <Reservada finally>\t" + lexicos.lexemas + "\n";
                    break;
                case Bool:
                    resultado += "  <Reservada bool>\t" + lexicos.lexemas + "\n";
                    break;
                case False:
                    resultado += "  <Reservada false>\t" + lexicos.lexemas + "\n";
                    break;
                case True:
                    resultado += "  <Reservada true>\t" + lexicos.lexemas + "\n";
                    break;
                case Fixed:
                    resultado += "  <Reservada fixed>\t" + lexicos.lexemas + "\n";
                    break;
                case Foreach:
                    resultado += "  <Reservada foreach>\t" + lexicos.lexemas + "\n";
                    break;
                case Goto:
                    resultado += "  <Reservada goto>\t" + lexicos.lexemas + "\n";
                    break;
                case Implicit:
                    resultado += "  <Reservada implicit>\t" + lexicos.lexemas + "\n";
                    break;
                case In:
                    resultado += "  <Reservada in>\t" + lexicos.lexemas + "\n";
                    break;
                case Interface:
                    resultado += "  <Reservada interface>\t" + lexicos.lexemas + "\n";
                    break;
                case Internal:
                    resultado += "  <Reservada internal>\t" + lexicos.lexemas + "\n";
                    break;
                case Is:
                    resultado += "  <Reservada is>\t" + lexicos.lexemas + "\n";
                    break;
                case Lock:
                    resultado += "  <Reservada lock>\t" + lexicos.lexemas + "\n";
                    break;
                case Namespace:
                    resultado += "  <Reservada namespace>\t" + lexicos.lexemas + "\n";
                    break;
                case New:
                    resultado += "  <Reservada new>\t" + lexicos.lexemas + "\n";
                    break;
                case Null:
                    resultado += "  <Reservada null>\t" + lexicos.lexemas + "\n";
                    break;
                case Object:
                    resultado += "  <Reservada object>\t" + lexicos.lexemas + "\n";
                    break;
                case Operator:
                    resultado += "  <Reservada operator>\t" + lexicos.lexemas + "\n";
                    break;
                case Out:
                    resultado += " <Reservada out>\t" + lexicos.lexemas + "\n";
                    break;
                case Override:
                    resultado += " <Reservada override>\t" + lexicos.lexemas + "\n";
                    break;
                case Params:
                    resultado += " <Reservada params>\t" + lexicos.lexemas + "\n";
                    break;
                case Private:
                    resultado += " <Reservada private>\t" + lexicos.lexemas + "\n";
                    break;
                case Protected:
                    resultado += " <Reservada protected>\t" + lexicos.lexemas + "\n";
                    break;
                case Public:
                    resultado += " <Reservada public>\t" + lexicos.lexemas + "\n";
                    break;
                case Readonly:
                    resultado += " <Reservada readonly>\t" + lexicos.lexemas + "\n";
                    break;
                case Ref:
                    resultado += " <Reservada ref>\t" + lexicos.lexemas + "\n";
                    break;
                case Return:
                    resultado += " <Reservada return>\t" + lexicos.lexemas + "\n";
                    break;
                case Sbyte:
                    resultado += " <Reservada sbyte>\t" + lexicos.lexemas + "\n";
                    break;
                case Sealed:
                    resultado += " <Reservada sealed>\t" + lexicos.lexemas + "\n";
                    break;
                case Sizeof:
                    resultado += " <Reservada sizeof>\t" + lexicos.lexemas + "\n";
                    break;
                case Stackalloc:
                    resultado += " <Reservada stackalloc>\t" + lexicos.lexemas + "\n";
                    break;
                case Statict:
                    resultado += " <Reservada statict>\t" + lexicos.lexemas + "\n";
                    break;
                case Struct:
                    resultado += " <Reservada struct>\t" + lexicos.lexemas + "\n";
                    break;
                case This:
                    resultado += " <Reservada this>\t" + lexicos.lexemas + "\n";
                    break;
                case Throw:
                    resultado += " <Reservada throw>\t" + lexicos.lexemas + "\n";
                    break;
                case Try:
                    resultado += " <Reservada try>\t" + lexicos.lexemas + "\n";
                    break;
                case Typeof:
                    resultado += " <Reservada typeof>\t" + lexicos.lexemas + "\n";
                    break;
                case Uint:
                    resultado += " <Reservada uint>\t" + lexicos.lexemas + "\n";
                    break;
                case Ulong:
                    resultado += " <Reservada ulong>\t" + lexicos.lexemas + "\n";
                    break;
                case Unchecked:
                    resultado += " <Reservada unchecked>\t" + lexicos.lexemas + "\n";
                    break;
                case Unsafe:
                    resultado += " <Reservada unsafe>\t" + lexicos.lexemas + "\n";
                    break;
                case Ushort:
                    resultado += " <Reservada ushort>\t" + lexicos.lexemas + "\n";
                    break;
                case Using:
                    resultado += " <Reservada using>\t" + lexicos.lexemas + "\n";
                    break;
                case Virtual:
                    resultado += " <Reservada virtual>\t" + lexicos.lexemas + "\n";
                    break;
                case Volatile:
                    resultado += " <Reservada volatile>\t" + lexicos.lexemas + "\n";
                    break;
                case Void:
                    resultado += " <Reservada void>\t" + lexicos.lexemas + "\n";
                    break;
                case Switch:
                    resultado += "  <Reservada switch>\t" + lexicos.lexemas + "\n";
                    break;
                case Case:
                    resultado += "  <Reservada case>\t" + lexicos.lexemas + "\n";
                    break;
                case Break:
                    resultado += "  <Reservada break>\t" + lexicos.lexemas + "\n";
                    break;
                case Continue:
                    resultado += "  <Reservada continue>\t" + lexicos.lexemas + "\n";
                    break;
                case Do:
                    resultado += "  <Reservada do>\t" + lexicos.lexemas + "\n";
                    break;
                case While:
                    resultado += "  <Reservada while>\t" + lexicos.lexemas + "\n";
                    break;
                case For:
                    resultado += "  <Reservada while>\t" + lexicos.lexemas + "\n";
                    break;
                case Igual:
                    resultado += "  <Operador igual>\t" + lexicos.lexemas + "\n";
                    break;
                case Suma:
                    resultado += "  <Operador suma>\t" + lexicos.lexemas + "\n";
                    break;
                case Resta:
                    resultado += "  <Operador resta>\t" + lexicos.lexemas + "\n";
                    break;
                case Multiplicacion:
                    resultado += "  <Operador multiplicacion>\t" + lexicos.lexemas + "\n";
                    break;
                case Division:
                    resultado += "  <Operador division>\t" + lexicos.lexemas + "\n";
                    break;
                case Op_logico:
                    resultado += "  <Operador logico>\t" + lexicos.lexemas + "\n";
                    break;
                case Op_incremento:
                    resultado += "  <Operador incremento>\t" + lexicos.lexemas + "\n";
                    break;
                case Op_relacional:
                    resultado += "  <Operador relacional>\t" + lexicos.lexemas + "\n";
                    break;
                case Op_atribucion:
                    resultado += "  <Operador atribucion>\t" + lexicos.lexemas + "\n";
                    break;
                case Op_booleano:
                    resultado += "  <Operador booleano>\t" + lexicos.lexemas + "\n";
                    break;
                case Parentesis_a:
                    resultado += "  <Parentesis de apertura>\t" + lexicos.lexemas + "\n";
                    break;
                case Parentesis_c:
                    resultado += "  <Parentesis de cierre>\t" + lexicos.lexemas + "\n";
                    break;
                case Llave_a:
                    resultado += "  <Llave de apertura>\t" + lexicos.lexemas + "\n";
                    break;
                case Llave_c:
                    resultado += "  <Llave de cierre>\t" + lexicos.lexemas + "\n";
                    break;
                case Corchete_a:
                    resultado += "  <Corchete de apertura>\t" + lexicos.lexemas + "\n";
                    break;
                case Corchete_c:
                    resultado += "  <Corchete de cierre>\t" + lexicos.lexemas + "\n";
                    break;
                case Main:
                    resultado += "  <Reservada main>\t" + lexicos.lexemas + "\n";
                    break;
                case P_coma:
                    resultado += "  <Punto y coma>\t" + lexicos.lexemas + "\n";
                    break;
                case Punto:
                    resultado += "  <Punto>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Identificador:
                    resultado += "  <Identificador>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Numero:
                    resultado += "  <Numero>\t\t" + lexicos.lexemas + "\n";
                    break;
                case ERROR:
                    resultado += "  <Simbolo no definido>\n";
                    break;
                default:
                    resultado += "  < " + lexicos.lexemas + " >\n";
                    break;
            }
        }

    }

    private void BotonAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAnalisisActionPerformed
        try {
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(FrmAnalizador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonAnalisisActionPerformed

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
        int cont = 1;
        JFileChooser escoger = new JFileChooser();
        escoger.showOpenDialog(null);
        File arc = new File(escoger.getSelectedFile().getAbsolutePath());

        try {
            String ST = new String(Files.readAllBytes(arc.toPath()));
            Resultado.setText(ST);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmAnalizador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmAnalizador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnArchivoActionPerformed

    private void Borrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Borrar1ActionPerformed
        txtAnalizarLex.setText(null);
    }//GEN-LAST:event_Borrar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAnalizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAnalizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAnalizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAnalizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAnalizador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Borrar1;
    private javax.swing.JButton BotonAnalisis;
    private javax.swing.JTextArea Resultado;
    private javax.swing.JButton btnArchivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtAnalizarLex;
    // End of variables declaration//GEN-END:variables
}
