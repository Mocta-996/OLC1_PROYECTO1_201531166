/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1_p1_201531166;
import java.io.BufferedReader;
import java.io.StringReader;
import Analisis.parser;
import Analisis.scanner;

import Data.Data;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import AnalisisReporte.parser;
//import AnalisisReporte.scanner;
/**
 *
 * @author Pilo
 */
public class OLC1_P1_201531166 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Interfaz iniciar = new Interfaz();
        iniciar.setVisible(true);
        /*
           try {
           
            
            String texto= "";
            scanner scan = new scanner(new BufferedReader( new StringReader(texto)));
            parser parser = new parser(scan);
            parser.parse();
            System.out.println("Finaliza el analisis...");
        } catch (Exception ex) {
            System.out.println("Error"+ex);
            ex.printStackTrace();
        }
        Data r  = new Data();
        /*try {
            r.Generar_reporte();
        } catch (IOException ex) {
            Logger.getLogger(OLC1_P1_201531166.class.getName()).log(Level.SEVERE, null, ex);
        }
        r.Recorrer_gbarras();
        r.Recorrer_varglobales();
        r.Recorrer_glinea();
        r.Recorrer_gpie();
        r.Recorrer_path();
        r.Analizar_archivos("");
        r.Generar_reporte();*/
        
        
    }
    
}
