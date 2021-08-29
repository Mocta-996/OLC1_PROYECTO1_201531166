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
import java.io.IOException;
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
    public static void main(String[] args) {
        
        //Interfaz iniciar = new Interfaz();
        //iniciar.setVisible(true);
           try {
            //String texto="   llamada1(); \nllamada2(1,2,3,\"hola\",var1);\n const archivo1 = require(\"../Carpeta1/archivo1 \")\n var archivo2 = require(\"../controller/Carpeta2/archivo2\") ";
            
            String texto= "##Este es un ejemplo de un archivo de reportería FCA\n" +
"GenerarReporteEstadistico{\n" +
"\n" +
"    definirglobales{\n" +
"        string reporteResumen = \"Reporte de Archivo file_1.js de los proyectos\";\n" +
"    }\n" +
"\n" +
"    #*\n" +
"    Este comentario debería ser ignorado 189214'!\"\"$%$&\"#$\"#\"#4\n" +
"    *#\n" +
"\n"+ "##Cargamos los proyectos correspondientes" +
                 
"\n    COMPARE(\"C:\\Users\\Pilo Tuy\\Downloads\\ArchivosPruebamaster\\ArchivosPruebamaster\\Proyecto 1\\Pruebas\\Prueba1\\ProyectoA\", \"C:\\Users\\Pilo Tuy\\Downloads\\ArchivosPruebamaster\\ArchivosPruebamaster\\Proyecto 1\\Pruebas\\Prueba1\\ProyectoB\");\n" +
"\n" +
"    GraficaLineas{\n" +
"        TiTulO: reporteResumen; \n" +
"        ArChIvO: \"file_1.js\";\n" +
"    }\n" +
"\n" +
"\n" +
"\n" +
"}";
            System.out.println("Inicia el analisis...\n");
            scanner scan = new scanner(new BufferedReader( new StringReader(texto)));
            parser parser = new parser(scan);
            parser.parse();
            System.out.println("Finaliza el analisis...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Data r  = new Data();
        /*try {
            r.Generar_reporte();
        } catch (IOException ex) {
            Logger.getLogger(OLC1_P1_201531166.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        // r.Recorrer_gbarras();
        // r.Recorrer_varglobales();
        // r.Recorrer_glinea();
        // r.Recorrer_gpie();
        // r.Recorrer_path();
        r.Cargar_archivos();
        
    }
    
}
