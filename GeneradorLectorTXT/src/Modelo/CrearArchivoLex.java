/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Gustavo
 */
public class CrearArchivoLex extends CrearArchivoFrm {

    public CrearArchivoLex(String nombre, String[] texto) {
        super(nombre, texto);
    }

    @Override
    protected String escribirRuta(String nombre) {
        String r = "../GeneradorLectorTXT/src/Salidas/" + nombre + "_lexico_flex.txt";
        return r;
    }

    @Override
    protected void escribirSentencia() {
        for (int i = 0; i < conte.length; i++) {
            contenido += "/* Palaba resevada " + conte[i] + " */\n"
                    + "( " + conte[i].toLowerCase() + " ) {lexemas=yytext(); return " + conte[i] + ";}\n\n";
        }
    }

}
