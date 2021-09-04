/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1_p1_201531166;
import Analisis.parser;
import Analisis.scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import Data.*;
import java.io.IOException;
/**
 *
 * @author Pilo Tuy
 */
public class Iniciar_Analisis {
    static  Data  r  = new Data();
    public static void Iniciar(String path){
        
        
        String text="";
        try{
        FileReader l = new FileReader(path);
        int cont = l.read();
        
        while (cont != -1) {
            text += (char) cont;
            cont = l.read();
        }
        }catch(Exception e){
             System.out.println("Error carga de archiovs fca   "+e);
        
        }
        try {
            //String texto= "";
            scanner scan = new scanner(new BufferedReader( new StringReader(text)));
            parser parser = new parser(scan);
            parser.parse();
            System.out.println("Finaliza el analisis...");
            r.Recorrer_gbarras();
            r.Recorrer_varglobales();
            r.Recorrer_glinea();
            r.Recorrer_gpie();
            r.Recorrer_path();
            r.Cargar_archivos();
        } catch (Exception ex) {
            System.out.println("Error"+ex);
            ex.printStackTrace();
        }
    }
    
    
    
    public static void Generar_Reportes() throws IOException{
                r.Generar_reporte();
    
    }
    
    
}
