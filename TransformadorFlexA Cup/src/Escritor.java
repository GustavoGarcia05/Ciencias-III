
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danny
 */
public class Escritor {
    

    protected String contenido;
    protected String[] conte;

    public Escritor(String texto) {
        try {

            String ruta = "../TransformadorFlexA Cup/src/datosCup";
            contenido = "";
            if (texto == null) {
                System.out.println("No existe texto");
                return;
            }

            contenido=texto;

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

    protected void escribirSentencia() {
        for (int i = 0; i < conte.length; i++) {
            contenido += conte[i] + "\n";
        }
        contenido+=" Puto el que lo lea";
    }
    
}
