/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1_p1_201531166;
import java.io.BufferedReader;
import java.io.StringReader;
//import Analisis.parser;
//import Analisis.scanner;

import AnalisisReporte.parser;
import AnalisisReporte.scanner;
/**
 *
 * @author Pilo
 */
public class OLC1_P1_201531166 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Interfaz iniciar = new Interfaz();
        //iniciar.setVisible(true);
           try {
            String texto="  do{}while(!(j <= 0));\n switch(numero){ \ncase 'hola': break; case 1: break; default}  \n //Este es un comentario unilinea\n /* Este es un comentario multilínea */ \n llamada1(); \nllamada2(1,2,3,\"hola\",var1);";
            System.out.println("Inicia el analisis...\n");
            scanner scan = new scanner(new BufferedReader( new StringReader(texto)));
            parser parser = new parser(scan);
            parser.parse();
            System.out.println("Finaliza el analisis...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
