
import java.io.BufferedReader;
import java.io.FileReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author danny
 */
public class Lector {

    protected String[] palabrasSepardas;


    public String leerString() {
        String cadena = "";
        String texto = "";

        FileReader fr = null;
        BufferedReader br = null;

        try {

            fr = new FileReader("../TransformadorFlexA Cup/src/datosFlex");
            br = new BufferedReader(fr);
            while ((cadena = br.readLine()) != null) {
                String aux = cadena.replaceAll("lexemas=yytext\\(\\); return ", "return new Symbol\\(sym.")+"\n";
                aux=aux.replaceAll(";", ", yychar, yyline, yytext\\(\\)\\);");
                texto += aux;
                

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
}
