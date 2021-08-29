/*
 * SECCION DONDE SE ALMACENARAN TODOS LOS DATOS QUE SE OBTENGAN DEL ANALISIS 
 */
package Data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import AnalisisReporte.parser;
import AnalisisReporte.scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Pilo Tuy
 */
public class Data {
    //VARIABLE QUE SE USA PARA GUARDAR ÑAS RUTAS DE LOS ARCHIVOS A ANALIZAR
    public static  HashMap<String,String> path_archivos  = new HashMap<>();  
    //VARIABLE QUE SE USA PARA GUARDAR LOS DATOS DE VARIABLES GLOBALES 
    public static  HashMap<String,String> variables_globales  = new HashMap<>();
    //VARIABLE QUE SE USA PARA GUARDAR LOS DATOS DE LA GRAFICA DE BARRRAS 
    public static  HashMap<String,String> grafica_barras  = new HashMap<>();
    //VARIABLE QUE SE USA PARA GUARDAR LOS DATOS DE LA GRAFICA DE PIE
    public static  HashMap<String,String> grafica_pie  = new HashMap<>();
    //VARIABLE QUE SE USA PARA GUARDAR LOS DATOS DE LA GRAFICA DE LINEA
    public static  HashMap<String,String> grafica_linea  = new HashMap<>();
    // GUARDAR NOMBRE DE  LOS ARCHIVOS DE CADA PROYECTO:  nombre del archivo, path
    public static  HashMap<String,String> proyecto_A  = new HashMap<>();
    public static  HashMap<String,String> proyecto_B  = new HashMap<>();
    
    // IGRESO DE DATOS DE LOS ARCHIVOS QUE SE ANALIZAN
    // para guardar los nombres de las clases en los archivos: nombre del archivo , nombre de la clase
    public static  HashMap<String,String> nombre_clases  = new HashMap<>(); 
    // para guardar los metodos de las clases: 
    public static  HashMap<String,String> metodos_arch1  = new HashMap<>(); 
    public static  HashMap<String,String> metodos_arch2  = new HashMap<>();
    
     // ================================================================================================================
    // ============================  METODOS PARA OBTENER PUNTAJES Y ANALIZAR ARCHIVOS .JS ============================
    // ================================================================================================================
    public void Cargar_archivos(){
            String path =path_archivos.get("Archivo1");
            String valor = path.replaceAll("^\"+|\"+$", "");
            File folder = new File(valor);
            //Archivos_carpeta(folder);
            // se guaardan en el la lista de Proyecto A
            for (File file : folder.listFiles()) {
			if (!file.isDirectory()) {
                                String archivo = file.getName();
				//System.out.println(file.getName());
                                proyecto_A.put(archivo,valor+"\\"+archivo);
			}
		}
            path = path_archivos.get("Archivo2");
            valor = path.replaceAll("^\"+|\"+$", "");
            folder = new File(valor);
            //Archivos_carpeta(folder);
            // se guaardan en el la lista de Proyecto B
            for (File file : folder.listFiles()) {
			if (!file.isDirectory()) {
                                String archivo = file.getName();
				//System.out.println(file.getName());
                                proyecto_B.put(archivo,path+"\\"+archivo);
			}
		}
       System.out.println("ARCHIVOS DEL PROYECTO A");
       for (String clave : proyecto_A.keySet()) {
            String va = proyecto_A.get(clave);
            System.out.println("Nombre: " + clave + ", Path: " + va);
        };
        System.out.println("ARCHIVOS DEL PROYECTO B");
        for (String clave : proyecto_B.keySet()) {
            String va =proyecto_B.get(clave);
            System.out.println("Nombre: " + clave + ", Path: " + va);
        };
        Comparar_archivos();
    }
    /// examinar si coinciden los archivos de cada proyecto
    public void Comparar_archivos(){
        String prueba = "";
     for (String clave : proyecto_A.keySet()) {
         
         for (String clave2 : proyecto_B.keySet()) {
             if (clave.equals(clave2)){
             System.out.println("ARCHIVOS IGUALES: PROYECTO A: "+ clave +"PROYECTO B: "+clave2);
              prueba =proyecto_A.get(clave);
              break;
             }
            }
            break;
        }
     Analizar_archivos(prueba,prueba);
    
    }
    
    // analiza cada archivo js encontrado
    public void Analizar_archivos(String path1,String path2){
        String ruta = path1.replaceAll("^\"+|\"+$", "");;
       
        try{
        FileReader leer = new FileReader(ruta);
        BufferedReader br = new BufferedReader(leer);
        String cadena;
        String acumulador ="";
        while((cadena = br.readLine())!=null){
            acumulador += cadena+"\n";
        }
     
        System.out.println("Inicia el analisis...\n");
        Analisis.scanner scan = new Analisis.scanner(new BufferedReader( new StringReader(acumulador)));
        Analisis.parser parser = new Analisis.parser(scan);
        parser.parse();
        System.out.println("Finaliza el analisis...");
        }catch(Exception e){
             System.out.println("Error carga de archiovs js   "+e);
        }
       
        
        
        
        
        
        
        
        
        
        
    
    }
    
    //=================================== METODO PARA GUARDAR PATH DE ARCHIVOS  ===============================
    public void Almacenar_Path(String variable,String valor){

       path_archivos.put(variable, valor);        
    };
    
    public void Recorrer_path(){
    System.out.println("\n PATH INGRESADOS: ");
    for (String clave : path_archivos.keySet()) {
            String valor = path_archivos.get(clave);
            System.out.println("Clave: " + clave + ", valor: " + valor);
        }
    }
    
    //=================================== METODO PARA GUARDAR VALORES DE GRAFICA DE BARRAS  ====================
    public void Almacenar_gbarras(String variable,String valor){

       grafica_barras.put(variable, valor);        
    };
    
    public void Recorrer_gbarras(){
    System.out.println("\n INSTRUCCIONES GRAFICA DE BARRAS: ");
    for (String clave : grafica_barras.keySet()) {
            String valor = grafica_barras.get(clave);
            System.out.println("Clave: " + clave + ", valor: " + valor);
        }
    }
        
    //==================================== METODO PARA GUARDAR VARIABLES GLOBALES  =============================
    public void Almacenar_varglobales(String variable,String valor){

        variables_globales.put(variable, valor);        
    };
    
    public void Recorrer_varglobales(){
    System.out.println("\nRECORRIENDO LAS VARIABLES GLOBALES: ");
    for (String clave : variables_globales.keySet()) {
            String valor = variables_globales  .get(clave);
            System.out.println("Clave: " + clave + ", valor: " + valor);
        }
    }
    
    //===================================== METODO PARA GUARDAR VALORES DE GRAFICA DE PIE ==========================
    public void Almacenar_gpie(String variable,String valor){

       grafica_pie.put(variable, valor);        
    };
    
    public void Recorrer_gpie(){
    System.out.println("\n INSTRUCCIONES GRAFICA DE PIE: ");
    for (String clave : grafica_pie.keySet()) {
            String valor = grafica_pie.get(clave);
            System.out.println("Clave: " + clave + ", valor: " + valor);
        }
    }
    
     //==================================== METODO PARA GUARDAR VALORES DE GRAFICA DE LINEA ======================
    public void Almacenar_glinea(String variable,String valor){

       grafica_linea.put(variable, valor);        
    };
    
    public void Recorrer_glinea(){
    System.out.println("\n INSTRUCCIONES GRAFICA DE LINEAS: ");
    for (String clave : grafica_linea.keySet()) {
            String valor = grafica_linea.get(clave);
            System.out.println("Clave: " + clave + ", valor: " + valor);
        }
    }
    
    
    // ================================================================================================================
    // ========================================== METODO PARA GENERAR LOS REPORTES ====================================
    // ================================================================================================================
    public void Generar_reporte() throws IOException{
    Generar_gbarras();
    Generar_gpie();
    Generar_glinea();
    Reporte_general();
    }
    public void Generar_gbarras() {
        String nombre_grafico ="";
        String nombre_columna ="";
        String nombre_numeracion ="";
        String aux="";
        String val_x="";
       
        // asignando valor a las variables
        
        // asignando titulo 
        aux= grafica_barras.get("titulo");
                
        if(variables_globales.containsKey(aux)){
            nombre_grafico  = variables_globales.get(aux).replaceAll("^\"+|\"+$", "");
        }
        else{
            nombre_grafico = aux;
        }
        
        // asignando titulo x o columna
        aux= grafica_barras.get("titulox");
        if(variables_globales.containsKey(aux)){
            nombre_columna = variables_globales.get(aux);
        }
        else{
            nombre_columna = aux;
        }
        // asignando titulo y o enumeracion
        aux= grafica_barras.get("tituloy");
                
        if(variables_globales.containsKey(aux)){
            nombre_numeracion = variables_globales.get(aux);
        }
        else{
            nombre_numeracion = aux;
        }
        // obteniendo los valores del string del eje x
        val_x = grafica_barras.get("ejex").replace("[", "");
        val_x = val_x.replace("]", "");
        String[] val2_x = val_x.split(",");
        String a ="";
        for(int i=0;i<val2_x.length; i++){
            a= val2_x[i];
            if(variables_globales.containsKey(a)){
                val2_x[i] = variables_globales.get(a);
            }       
        }
               
        DefaultCategoryDataset gbarras = new DefaultCategoryDataset();
        // ingresando los datos en la tabla 
        // double , string, string
        // crear metodo para obtener los valores
         for(int i=0;i<val2_x.length; i++){
            gbarras.setValue(0.5*i,"Resultados",val2_x[i] );
        }
        
        
        // crear grafico
        // nombre del grafico, nombre de la barra o columnas, nombre de la numeracion
        // datos del grafico, orientacion,  legenda de barras individuales por color
        // herramientas , url del grafico
        JFreeChart graf_barras = ChartFactory.createBarChart3D(nombre_grafico,nombre_columna,nombre_numeracion,
                gbarras,PlotOrientation.VERTICAL,true,true,false
                );
        
        // generando la imagen 
        try{
            final ChartRenderingInfo inf = new ChartRenderingInfo (new StandardEntityCollection());
            final File archivo = new File("./reporte/images/gb"+nombre_grafico+".png");
            ChartUtilities.saveChartAsPNG(archivo,graf_barras,600,600,inf);
        }catch(Exception e){
        System.out.println("Error :(");
        System.out.println(e);
        }
    }
    
    public void Generar_gpie(){
        String nombre_grafico ="";
        String aux="";
        String val_x="";
       
        // asignando valor a las variables
        
        // asignando titulo 
        aux= grafica_pie.get("titulo");
                
        if(variables_globales.containsKey(aux)){
            nombre_grafico  = variables_globales.get(aux).replaceAll("^\"+|\"+$", "");
        }
        else{
            nombre_grafico = aux;
        }
        
        // obteniendo los valores del string del eje x
        val_x = grafica_pie.get("ejex").replace("[", "");
        val_x = val_x.replace("]", "");
        String[] val2_x = val_x.split(",");
        String a ="";
        for(int i=0;i<val2_x.length; i++){
            a= val2_x[i];
            if(variables_globales.containsKey(a)){
                val2_x[i] = variables_globales.get(a);
            }       
        }  
        DefaultPieDataset gcircular = new DefaultPieDataset();
        // ingresando los datos en la tabla 
        // categoria "string" , double
        // crear metodo para obtener los valores
       
         for(int i=0;i<val2_x.length; i++){
             gcircular.setValue(val2_x[i], 1.25*i);
        }
        // crear grafico
        // nombre del grafico, datos, nombre de las categorias, herramientas,generacion url
        JFreeChart graf_circular = ChartFactory.createPieChart(nombre_grafico, gcircular, true, true, false);
        
        // generando la imagen 
        try{
            final ChartRenderingInfo inf = new ChartRenderingInfo (new StandardEntityCollection());
            final File archivo = new File("./reporte/images/gc"+nombre_grafico+".png");
            ChartUtilities.saveChartAsPNG(archivo,graf_circular,600,600,inf);
        }catch(Exception e){
        System.out.println("Error :(");
        System.out.println(e);
        }
    
    }
    
    
    public void Generar_glinea(){
    String nombre_grafico ="";
    String aux="";
    final DefaultCategoryDataset data = new DefaultCategoryDataset();
     
    // se agregan los valores al proyecto A
    data.addValue(2, "P_A","metodos");
    data.addValue(5, "P_A","funciones");
    data.addValue(10, "P_A","clases");
    data.addValue(9, "P_A","cometnarios");
    data.addValue(3, "P_A","otros");
    
     // se agregan los valores al proyecto B
    data.addValue(7, "P_B","metodos");
    data.addValue(5, "P_B","funciones");
    data.addValue(8, "P_B","clases");
    data.addValue(0, "P_B","cometnarios");
    data.addValue(1, "P_B","otros");
    // asignando titulo 
    aux= grafica_linea.get("titulo");
                
    if(variables_globales.containsKey(aux)){
        nombre_grafico  = variables_globales.get(aux).replaceAll("^\"+|\"+$", "");
        }
    else{
        nombre_grafico = aux;
        }
        
    final JFreeChart chart=ChartFactory.createLineChart(nombre_grafico,
                "","",data,PlotOrientation.VERTICAL,
                true,true,false); 
    
        // generando la imagen 
        try{
            final ChartRenderingInfo inf = new ChartRenderingInfo (new StandardEntityCollection());
            final File archivo = new File("./reporte/images/gl"+nombre_grafico+".png");
            ChartUtilities.saveChartAsPNG(archivo,chart,600,600,inf);
        }catch(Exception e){
        System.out.println("Error :(");
        System.out.println(e);
        }
     
     }
    
    
    public void Reporte_general() throws IOException{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String fecha = dtf.format(LocalDateTime.now());
        //System.out.println("yyyy/MM/dd HH:mm:ss-> "+dtf.format(LocalDateTime.now()));
        
        FileWriter reporte = new FileWriter("./reporte/Reporte.html");
        reporte.write(  "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<head>\n" +
                        "	<title>OLC1_P1</title>\n" +
                        "	<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\">\n" +
                        "	<link href='https://fonts.googleapis.com/css?family=Lato:400,700,900,300' rel='stylesheet' type='text/css'>\n" +
                        "	<link rel=\"stylesheet\" type=\"text/css\" href=\"css/font-awesome.min.css\">\n" +
                        "	<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n" +
                        "	<link rel=\"stylesheet\" href=\"css/animate.css\">\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<header>\n" +
                        "	<div id=\"homeFullScreen\">\n" +
                        "		<div class=\"header-text\">\n" +
                        "			<h1>Organización de Lenguajes y Compiladores 1</h1>\n" +
                        "				<div class=\"vertical-line\"></div>\n" +
                        "			<p>\n" +
                        "				REPORTE ESTADISTICO	 \n" +
                        "				\n" +
                        "			</p>\n" +
                        "		</div>\n" +
                        "	</div>\n" +
                        "</header>"
                //============== seccion de resumen ================
                        +"<section class=\"feature\">\n" +
                        "	<div class=\"container\">\n" +
                        "		<div class=\"row\">\n" +
                        "			<div class=\"col-md-4 col-sm-4\">\n" +
                        "				<div class=\"feature-box\">\n" +
                        "					<h1>RESUMEN </h1>\n" +
                        "				</div>\n" +
                        "			</div>\n" +
                        "			<div class=\"col-md-8 col-sm-8 nopadding\">\n" +
                        "				<img src=\"i/1.png\">\n" +
                        "			</div>\n" +
                        "		</div>\n" +
                        "	</div>\n" +
                        "</section>"
                //============== seccion de grafica de barras ================
                        +"<section class=\"feature\">\n" +
                        "	<div class=\"container\">\n" +
                        "		<div class=\"row\">\n" +
                        "			<div class=\"col-md-4 col-sm-4\">\n" +
                        "				<div class=\"feature-box\">\n" +
                        "					<h1>GRAFICA DE BARRAS </h1>					\n" +
                        "				</div>\n" +
                        "			</div>\n" +
                        "			<div class=\"col-md-6 col-sm-6 nopadding\">\n" +
                        "				<img src=\"images/gcreporte 1.png\">\n" +
                        "			</div>\n" +
                        "		</div>\n" +
                        "	</div>\n" +
                        "</section>"+
                 //============== seccion de grafica de pie ================
                        "<section class=\"feature\">\n" +
                        "	<div class=\"container\">\n" +
                        "		<div class=\"row\">\n" +
                        "			<div class=\"col-md-4 col-sm-4\">\n" +
                        "				<div class=\"feature-box\">\n" +
                        "					<h1>GRAFICA DE PIE </h1>\n" +
                        "				</div>\n" +
                        "			</div>\n" +
                        "			<div class=\"col-md-8 col-sm-8 nopadding\">\n" +
                        "				<img src=\"images/1.png\">\n" +
                        "			</div>\n" +
                        "		</div>\n" +
                        "	</div>\n" +
                        "</section>"+
                 //============== demas secciones ================
                        "<section class=\"call-top-action text-center\">\n" +
                        "	<div class=\"container\">\n" +
                        "		<div class=\"row\">\n" +
                        "			<div class=\"col-md-12\">\n" +
                        "				<span>Maynor Octavio Piló Tuy</span>\n" +
                        "			</br>\n" +
                        "				<span>201531166</span>\n" +
                        "			</br>\n" +
                        "				<span>fecha:"+fecha+" </span>\n" +
                        "			</div>\n" +
                        "		</div>\n" +
                        "	</div>\n" +
                        "</section>\n" +
                        "<script type=\"text/javascript\" src=\"js/jquery-main.js\"></script>\n" +
                        "<script type=\"text/javascript\" src=\"js/bootstrap.min.js\"></script>\n" +
                        "<script type=\"text/javascript\" src=\"js/wow.min.js\"></script>\n" +
                        "<script type=\"text/javascript\" src=\"js/custom.js\"></script>\n" +
                        "</body>\n" +
                        "</html>"
        
        );
        reporte.close();
    
    }
    
    
    
    
    
    
    
    
    //PARA COMPROBAR SI UNA CADENA QUE SE INGRESA ES DOUBLE O STRING
    public static boolean isDouble(String cadena) {

        boolean resultado;

        try {
            Double.parseDouble(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

}
