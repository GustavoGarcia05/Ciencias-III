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
public class LeerArchivoOperadores extends LeerArchivo{

    public LeerArchivoOperadores(String rutaArchivo) {
        super(rutaArchivo);
    }

    
    
    @Override
    protected String[] separarPorComa(String texto) {
        if (texto == null) {
            System.out.println("no existen textos ");
            return null;
        }
           // System.out.println("texto: "+texto);
        palabrasSepardas = texto.split(" ");
        for (int i = 0; i < palabrasSepardas.length; i++) {
            palabrasSepardas[i]=palabrasSepardas[i].replaceAll(" ", "");// remplaza el espacio por uno sin espacio
            //System.out.println(palabrasSepardas[i]);
        }
        return palabrasSepardas;
    }


    

}
