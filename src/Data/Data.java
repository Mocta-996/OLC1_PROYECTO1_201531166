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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.json.simple.JSONObject;
import olc1_p1_201531166.*;
/*
NOTAS: 
ACTIVAR EN: CARGAR ARCHIVOS -> COMPARAR ARCHIVOS
ACTIVAR EN: COMPARAR ARCHIVOS -> ANALIZAR ARCHIVOS


*/
/**
 *
 * @author Pilo Tuy
 */
public class Data {
    public static boolean Bandera1 = false; // se usa el primer hasmap para el archivo 1
    public static boolean Bandera2 = false; // se usa el segundo   hashmap para el segundo archivo 2
    public static String nom_archivo ="file_1.js";   // nombre del archivo que se esta ejecutando
    public static String nom_proyecto ="PROYECTO A";   // nombre del archivo que se esta ejecutando
    public static List<Grafica> lista_graficas = new ArrayList<Grafica>();
    
    //VARIABLE QUE SE USA PARA GUARDAR ÑAS RUTAS DE LOS ARCHIVOS A ANALIZAR
    public static  HashMap<String,String> path_archivos  = new HashMap<>();  
    //VARIABLE QUE SE USA PARA GUARDAR LOS DATOS DE VARIABLES GLOBALES 
    public static  HashMap<String,String> variables_globales  = new HashMap<>();
    //VARIABLE QUE SE USA PARA GUARDAR LOS DATOS DE LA GRAFICA DE BARRRAS 
    //public static  HashMap<String,String> grafica_barras  = new HashMap<>();
    public static  List<Barras> grafica_barras  = new ArrayList<Barras>();
    //VARIABLE QUE SE USA PARA GUARDAR LOS DATOS DE LA GRAFICA DE PIE
    //public static  HashMap<String,String> grafica_pie  = new HashMap<>();
    public static  List<Pie> grafica_pie  = new ArrayList<Pie>();
    //VARIABLE QUE SE USA PARA GUARDAR LOS DATOS DE LA GRAFICA DE LINEA
    //public static  HashMap<String,String> grafica_linea  = new HashMap<>();
    public static  List<Lineas> grafica_linea  = new ArrayList<Lineas>();
    //GUARDAR NOMBRE DE  LOS ARCHIVOS DE CADA PROYECTO:  nombre del archivo, path
    public static  HashMap<String,String> proyecto_A  = new HashMap<>();
    public static  HashMap<String,String> proyecto_B  = new HashMap<>();
    
    // IGRESO DE DATOS DE LOS ARCHIVOS QUE SE ANALIZAN
    //--- CLASE REPETIDA
    public static List<Nombre_clases>  nom_clases = new ArrayList<Nombre_clases>(); // lista con objetos que guardara el nombre de las clases
    public static List<Nombre_clases>  nom_clases2 = new ArrayList<Nombre_clases>(); // lista con objetos que guardara el nombre de las clases archivo2
    //public static  HashMap<String,String> nombre_clases  = new HashMap<>(); // guarda el nombre de la clase
    //public static  List<String> metodos_clase1 = new ArrayList<String>();   // guarda los metodos con  de  la primera clase
    //public static  List<String> metodos_clase2 = new ArrayList<String>();   // guarda los metodos con  de  la segunda clase
    //public static  HashMap<String,Integer> Lineas  = new HashMap<>(); //guarda los metodos con  de  la primera clase
    //--- variables repetidas 
    public static  List<Variables> variables = new ArrayList<Variables>();    // lista de objetos que contiene las variables ingresadas  
    public static  List<Variables> variables2 = new ArrayList<Variables>();    // lista de objetos que contiene las variables ingresadas  archivo2
    //public static  List<String> variables_clase1 = new ArrayList<String>();   // guarda los metodos con  de  la primera clase
    //public static  List<String> variables_clase2 = new ArrayList<String>();   // guarda los metodos con  de  la segunda clase
    // ---- metodos de cada clase
    //public static List<Metodos> metodos_clases = new ArrayList<Metodos>();      // lista con objetos que guarda todas las clases
    //public static List<Metodos> metodos_clases2 = new ArrayList<Metodos>();      // lista con objetos que guarda todas las clases archivo 2
    public static  List<Metodos> metodos_class1 = new ArrayList<Metodos>();   // guarda los metodos con  de  la segunda clase
    public static  List<Metodos> metodos_class2 = new ArrayList<Metodos>();   // guarda los metodos con  de  la segunda clase
    // --- metodos comentarios repetidos
    public static  List<Comentario> comentarios = new ArrayList<Comentario>(); // lista de objeto que guarda los comentarios de cada clase
    public static  List<Comentario> comentarios2 = new ArrayList<Comentario>(); // lista de objeto que guarda los comentarios de cada clase
    //public static  List<String> comentario1 = new ArrayList<String>();   // guarda los comentario repetidos de la clase 1
    //public static  List<String> comentario2 = new ArrayList<String>();   // guarda los comentario repetidos de la clase 2
    
    //-- PUNTAJES DE REPITENCIA 
    //-- lista que guardara los puntajes de repitencia de las clases. 
    public static  List<Pe_Clase> pespecifico_clase = new ArrayList<Pe_Clase>();   // guarda los metodos con  de  la segunda clase
    public static  List<Pe_variable> pespecifico_variable = new ArrayList<Pe_variable>();   // guarda los metodos con  de  la segunda clase
    public static  List<Pe_metodo> pespecifico_metodo = new ArrayList<Pe_metodo>();   // guarda los metodos con  de  la segunda clase
    public static  List<Pe_comentario> pespecifico_comentario = new ArrayList<Pe_comentario>();   // guarda los metodos con  de  la segunda clase
    
    // -- LISTA DE PUNTAJE GENERAL 
    public static  List<puntaje_general> puntaje_g = new ArrayList<puntaje_general>();
    public static  List<Resumen> resumen = new ArrayList<Resumen>();
    
    // -- LISTA DE ERRORES 
    public static List <Error> errores = new ArrayList <Error>();
    // -- LISTA DE TOKENS 
    public static List <Tokens> token= new ArrayList <Tokens>();
// ================================================================================================================
    // ============================  METODOS PARA OBTENER PUNTAJES Y ANALIZAR ARCHIVOS .JS ============================
    // ================================================================================================================
    public static void Cargar_archivos(){
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
                                proyecto_B.put(archivo,valor+"\\"+archivo);
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
    public static void Comparar_archivos(){
        if(!proyecto_A.isEmpty()){
        String prueba = "";
        for (String clave : proyecto_A.keySet()) {

            for (String clave2 : proyecto_B.keySet()) {
                if (clave.equals(clave2)){
                System.out.println("ARCHIVOS IGUALES: PROYECTO A: "+ clave +"PROYECTO B: "+clave2);
                   nom_archivo= clave;                     //se guarda el nombre del archivo en la variable global 
                   prueba =proyecto_A.get(clave);          // se obtiene el path del primer archivo
                   Bandera2=false;                         // se desactiva los datos del segundo archivo
                   Bandera1= true;                         // se activan los datos del primer archivo
                   Analizar_archivos(prueba);              // se analizar el primer archivo del proyecto A
                   prueba =proyecto_B.get(clave2);          // se obtiene el path del primer archivo
                   Bandera2=true;                         // se activa los datos del segundo archivo
                   Bandera1= false;                         // se desactivan los datos del primer archivo
                   Analizar_archivos(prueba);              // se analizar el segundo archivo del proyecto B
                   
                    pe_clase();
                    pe_metodo();
                    pe_comentario();
                    pe_variable();
                    pe_imprimir();
                    puntaje_general();
                    nom_clases.clear();
                    nom_clases2.clear();
                    metodos_class1.clear();
                    metodos_class2.clear();
                    //Lineas.clear();
                    variables.clear();
                    variables2.clear();
                   comentarios.clear();
                   comentarios2.clear();
                }
               }
           }
       // PROCESAR DATOS OBTENIDOS DE LOS DOS ARCHIVOS
        
        }
    }
    
    // analiza cada archivo js encontrado
    public static void Analizar_archivos(String path1){
        
        if(Bandera1){
           nom_proyecto="Proyecto A";
        }else{
           nom_proyecto="Proyecto B";
        }
        
        String path= path1;
        String ruta = path.replaceAll("^\"+|\"+$", "");
        String text="";
        try{
        FileReader l = new FileReader(ruta);
        int cont = l.read();
        while (cont != -1) {
            text += (char) cont;
            cont = l.read();
        }
        
        }catch(Exception e){
             System.out.println("Error carga de archiovs js   "+e);
        
        }
        
        try{
        
        String archivo1 =text;
     
        System.out.println("Inicia el analisis...\n");
        AnalisisReporte.scanner scan = new AnalisisReporte.scanner(new BufferedReader( new StringReader(archivo1)));
        
        AnalisisReporte.parser parser = new AnalisisReporte.parser(scan);
        
        parser.parse();
        System.out.println("Finaliza el analisis...");
        
        }catch(Exception e){
             System.out.println("Error carga de archiovs js   "+e);
        }
    }
    
    // metodo para ingresar el nombre de las clases de los archivos
       
    public void Nombre_clases(String nombre,int inicio,int fin){
         int total = fin-inicio;
        Nombre_clases n = new Nombre_clases();
        n.setArchivo(nom_archivo);
        n.setNombre(nombre);
        n.setCant_lineas(total);
        
        if(Bandera1){
            //nombre_clases.put("clase1", nombre);
            nom_clases.add(n);
        }   
        else{
          //nombre_clases.put("clase2", nombre);
          nom_clases2.add(n);
        }
    }
    // metodo para ingresar la cantidad de linea de cada clase
    public void cantidad_lineas(int inicio,int fin){
        int total = fin-inicio;
      if(Bandera1){
        //Lineas.put("clase1", total);
      }
      else{
        //Lineas.put("clase2", total);
      }
    }
    
    public void metodos_clase(String id){
      if(Bandera1){
        //metodos_clase1.add (id);
      }
      else{
        //metodos_clase2.add(id);
      }
    }
     
    // metodo para ingresar las variables de cada archivo que se lee
    public void variables_clase(String clas, String id){
        Variables v = new Variables();
        v.setArchivo(nom_archivo);
        v.setClase(clas);
        v.setId(id);
        
           
        
    if(Bandera1){
        boolean ingresado = false;
        for(int i=0;i<variables.size();i++){
            
            if(variables.get(i).getClase().equals(clas)){
                if(variables.get(i).getId().equals(id)){
                    ingresado = true;
                    break;
                }
            }
        }
        if(ingresado == false){ variables.add(v); } 
      }
      else{
        boolean ingresado = false;
        for(int i=0;i<variables2.size();i++){
            if(variables2.get(i).getClase().equals(clas)){
                if(variables2.get(i).getId().equals(id)){
                    ingresado = true;
                    break;
                }
            }
        }
        if(ingresado == false){
            variables2.add(v);
        } 
        
      }
      }
    
    
    // metodo para ingresar los metodos de cada archivo 
    public void metodos_clase2(String clase, String id,String  parametros,int init,int end){
        // se utiliza "f" para indicar que es sin parametro
        String[] aux = parametros.split(",");
        int cantidad_parametros = aux.length;
        int lineas = end - init;
        if(parametros.equals("f")){
            cantidad_parametros=0;
        }
        Metodos m = new Metodos();
        m.setClase(clase);
        m.setId(id);
        m.setParametros(cantidad_parametros);
        m.setLineas(lineas);
        m.setArchivo(nom_archivo);
       
        if(Bandera1){
            //metodos_clases.add(m);
            metodos_class1.add(m);
        }
        else{
            //metodos_clases2.add(m);
            metodos_class2.add(m);
        }
    }
    
    public void comentarios(String clas,String comentario){
            String c = comentario.replaceAll("\\s","");
            Comentario com = new Comentario();
            com.setArchivo(nom_archivo);
            com.setClase(clas);
            com.setComentario(c);
            
            if(Bandera1){
                comentarios.add(com);
                //comentario1.add(c);
            }
            else{
                comentarios2.add(com);
                //comentario2.add(c);
            }
    }
    
    // ================================================================================================================
    // ============================  METODOS PARA CALCULAR PUNTAJES ESPECIFICOS =======================================
    // ================================================================================================================
    
    // ============================ METODO PARA CALCULAR EL PUNTAJE DE LAS CLASES REPTEIDAS =====================
    public static void pe_clase(){
       
        double punteo =0;
        boolean r=false;
        String cla1 ="";
        String cla2="";
        String arch ="";
        
        
        for(int i =0;i<nom_clases.size();i++){
            punteo =0;
            // obteniendo el nombre de la clase y el archivo 
            cla1 = nom_clases.get(i).getNombre();
            arch = nom_clases.get(i).getArchivo();
            for(int j =0;j<nom_clases2.size();j++){
            // obteniendo el nombre de la clase2 y el archivo 
                cla2 = nom_clases2.get(j).getNombre();
                //verificando si es el mimso id de clase
                if(cla1.equals( cla2)){
                    punteo +=0.2; 
                    r= true;
                }
                // verifiando cantidad de lineas
                if(nom_clases.get(i).getCant_lineas() == nom_clases2.get(j).getCant_lineas()){
                    punteo +=0.4; 
                    r= true;
                }
                // verificando metodos entre las dos clases
                if(id_metodos_clases(cla1,cla2)){
                    punteo +=0.4; 
                    r= true;
                }
                Pe_Clase c= new Pe_Clase();
                c.setArchivo(arch);
                c.setClase1(cla1);
                c.setClase2(cla2);
                c.setPunteo(punteo);
                c.setR(r);
                pespecifico_clase.add(c);
             }        
        }
           
    }
    
    public static boolean id_metodos_clases(String clase1,String clase2){
        boolean salir= false;
        List<String> met1 =new ArrayList<String>();
        List<String> met2 =new ArrayList<String>();
        
        for (int i =0; i<metodos_class1.size();i++){
            if(metodos_class1.get(i).getClase().equals(clase1)){
                met1.add(metodos_class1.get(i).getId());
            }
        }
        
        for (int j =0; j<metodos_class2.size();j++){
            if(metodos_class2.get(j).getClase().equals(clase1)){
                met2.add(metodos_class2.get(j).getId());
            }
        }
        // verificando los metodos 
        for(int i=0;i<met1.size();i++){
           salir =false;
           for(int j=0;j<met2.size();j++){
            if(met1.get(i).equals(met2.get(j))){
                //punteo +=0.4;
                //r=true;
                salir =true;
                break;
            }
           }
           if(salir == false){
           break;
           }
        }
       if(salir){
           return true;
       }
        return false;
    }

    // =========================== METODO PARA CALCULAR EL PUNTAJE DE LAS VARIABLES REPETIDAS ===================
    public static void pe_variable(){
        
        for(int i=0; i<variables.size();i++){
            for(int j=0; j<variables2.size();j++){
                String var1=variables.get(i).getId();
                String var2=variables2.get(j).getId();
                if(var1.equals(var2)){
                    Pe_variable var = new Pe_variable();
                    var.setArchivo(variables.get(i).getArchivo());
                    var.setClase1(variables.get(i).getClase());
                    var.setClase2(variables2.get(j).getClase());
                    var.setPunteo(1);
                    var.setR(true);
                    var.setVariable(var1);
                    pespecifico_variable.add(var);
                }
            }
        }
    }
    // =========================== METODO PARA CALCULAR EL PUNTAJE DE LOS METODOS ==========================
    public static void pe_metodo(){
       List<String> aux= new ArrayList<String>();
        
        double punteoid=0;
        double punteop=0;
        double punteol=0;
        // repitencia de identificadores
        for(int i=0;i<metodos_class1.size();i++){
            // se verifican los ids
           for(int j=0;j<metodos_class2.size();j++){
               punteoid=0;
               punteop=0;
               punteol=0;
               String id1= metodos_class1.get(i).getId();
               String id2= metodos_class2.get(j).getId();
              // metodos_class1.get(i).getId()==metodos_class2.get(j).getId()
            if(id1.equals(id2)){
                punteoid =0.4;
                if(metodos_class1.get(i).getParametros()==metodos_class2.get(j).getParametros()){
                    punteop =0.3;
                }
                if(metodos_class1.get(i).getLineas()==metodos_class2.get(j).getLineas()){
                    punteol =0.3;
                }
                Pe_metodo m = new Pe_metodo();
                m.setArchivo(nom_archivo);
                m.setClase1(metodos_class1.get(i).getClase());//
                m.setClase2(metodos_class2.get(j).getClase());
                m.setPunteo(punteoid+punteop+punteol);
                m.setR(true);
                m.setVariable(metodos_class1.get(i).getId());
                aux.add(metodos_class1.get(i).getId());
                pespecifico_metodo.add(m);
                break;
            }  
            } 
            // se verifican por cantidad de lineas
            for(int j=0;j<metodos_class2.size();j++){
                punteop=0;
                punteol=0;
                int ii= metodos_class1.get(i).getLineas();
                int iii= metodos_class2.get(j).getLineas();
                if(!aux.contains(metodos_class1.get(i).getId())){
                    if(metodos_class1.get(i).getLineas()==metodos_class2.get(j).getLineas()){
                        punteol =0.3;
                        int jj= metodos_class1.get(i).getParametros();
                        int jjj= metodos_class2.get(j).getParametros();
                        
                        if(metodos_class1.get(i).getParametros()==metodos_class2.get(j).getParametros()){
                        punteop =0.3;
                        
                        }
                        Pe_metodo m = new Pe_metodo();
                        m.setArchivo(nom_archivo);
                        m.setClase1(metodos_class1.get(i).getClase());
                        m.setClase2(metodos_class2.get(j).getClase());
                        m.setPunteo(punteop+punteol);
                        m.setR(true);
                        m.setVariable(metodos_class1.get(i).getId());
                        aux.add(metodos_class1.get(i).getId());
                        pespecifico_metodo.add(m);
                    }
                } 
            }
        }
        
        // verficando la lista 2
        for(int i=0;i<metodos_class2.size();i++){ 
            // se verifican por cantidad de lineas
            for(int j=0;j<metodos_class1.size();j++){
                punteop=0;
                punteol=0;
                int ii= metodos_class1.get(j).getLineas();
                int iii= metodos_class2.get(i).getLineas();
                if(!aux.contains(metodos_class2.get(i).getId())){
                    if(metodos_class1.get(j).getLineas()==metodos_class2.get(i).getLineas()){
                        punteol =0.3;
                        int jj= metodos_class1.get(j).getParametros();
                        int jjj= metodos_class2.get(i).getParametros();
                        if(metodos_class1.get(j).getParametros()==metodos_class2.get(i).getParametros()){
                        punteop =0.3;
                        
                        }
                        Pe_metodo m = new Pe_metodo();
                        m.setArchivo(nom_archivo);
                        m.setClase1(metodos_class2.get(i).getClase());
                        m.setClase2(metodos_class2.get(j).getClase());
                        m.setPunteo(punteop+punteol);
                        m.setR(true);
                        m.setVariable(metodos_class2.get(i).getId());
                        aux.add(metodos_class2.get(i).getId());
                        pespecifico_metodo.add(m);
                    }
                } 
            }
        }    
    }
    
    public static void pe_comentario(){
        for(int i=0;i<comentarios.size();i++){
            for(int j=0;j<comentarios2.size();j++){
                String com1 = comentarios.get(i).getComentario();
                String com2 = comentarios2.get(j).getComentario();
                if(com1.equals(com2))
                {
                        Pe_comentario m = new Pe_comentario();
                        m.setArchivo(nom_archivo);
                        m.setClase1(comentarios.get(i).getClase());
                        m.setClase2(comentarios2.get(j).getClase());
                        m.setPunteo(1);
                        m.setR(true);
                        m.setVariable(com1);
                        pespecifico_comentario.add(m);
                }
            
            }
            

        }
    
    
    }
  
    
    public static void pe_imprimir(){
        System.out.println("PUNTAJE ESPECIFICO DE CLASES: \n");
        for(int i=0; i<pespecifico_clase.size();i++){
            
            System.out.println("ARCHIVO: "+ pespecifico_clase.get(i).getArchivo() );
            System.out.println("CLASES: "+ pespecifico_clase.get(i).getClase1()+" "+ pespecifico_clase.get(i).getClase2()
            );
            System.out.println("PUNTEO: "+ pespecifico_clase.get(i).getPunteo());
            System.out.println("REPITE: \n");
        }
        
        System.out.println("PUNTAJE ESPECIFICO DE VARIABLES:\n ");
        for(int i=0; i<pespecifico_variable.size();i++){
           
            System.out.println("ARCHIVO: "+ pespecifico_variable.get(i).getArchivo() );
            System.out.println("CLASES: "+ pespecifico_variable.get(i).getClase1() +"- "+pespecifico_variable.get(i).getClase2());
            System.out.println("PUNTEO: "+ pespecifico_variable.get(i).getPunteo());
            System.out.println("VARIABLE: "+pespecifico_variable.get(i).getVariable()+"\n");
        }
        System.out.println("PUNTAJE ESPECIFICO DE METODOS:\n ");
        for(int i=0; i<pespecifico_metodo.size();i++){
           
            System.out.println("ARCHIVO: "+ pespecifico_metodo.get(i).getArchivo() );
            System.out.println("CLASES: "+ pespecifico_metodo.get(i).getClase1() +"- "+pespecifico_metodo.get(i).getClase2());
            System.out.println("PUNTEO: "+ pespecifico_metodo.get(i).getPunteo());
            System.out.println("VARIABLE: "+pespecifico_metodo.get(i).getVariable()+"\n");
        }
        System.out.println("PUNTAJE ESPECIFICO DE COMENTARIOS:\n ");
        for(int i=0; i<pespecifico_comentario.size();i++){
            
            System.out.println("ARCHIVO: "+ pespecifico_comentario.get(i).getArchivo() );
            System.out.println("CLASES: "+ pespecifico_comentario.get(i).getClase1() +"- "+pespecifico_metodo.get(i).getClase2());
            System.out.println("PUNTEO: "+ pespecifico_comentario.get(i).getPunteo());
            System.out.println("VARIABLE: "+pespecifico_comentario.get(i).getVariable()+"\n");
        }
    }
    
    public static void puntaje_general(){
        
        Resumen r= new Resumen();
        r.setProyecto("proyectoA");
        r.setArchivo(nom_archivo);
        r.setT_clases(nom_clases.size());
        r.setT_comentarios(comentarios.size());
        r.setT_metodos(metodos_class1.size());
        r.setT_variables(variables.size());
        resumen.add(r);
        
        Resumen rr= new Resumen();
        rr.setProyecto("proyectoB");
        rr.setArchivo(nom_archivo);
        rr.setT_clases(nom_clases2.size());
        rr.setT_comentarios(comentarios2.size());
        rr.setT_metodos(metodos_class2.size());
        rr.setT_variables(variables2.size());
        resumen.add(rr);
    }
    // retorna el puntaje general. 
    public static double  total_pgeneral(){
        int cla_repetidos =0;
        int com_repetidos =0;
        int met_repetidos =0;
        int var_repetidos =0;
        /*
        int sum_comentarios =comentarios.size()+comentarios2.size();
        int sum_variables =variables.size()+variables2.size();
        int sum_metodos =metodos_class1.size()+metodos_class2.size();
        int sum_clase =nom_clases.size()+nom_clases2.size();*/
        
        // se analizaran  primero los datos repetidos
        for(int i=0; i<pespecifico_clase.size();i++){
            if(pespecifico_clase.get(i).getPunteo()>=0.6){
                    cla_repetidos +=1;   
            }
        }
        for(int i=0; i<pespecifico_variable.size();i++){
            if(pespecifico_variable.get(i).getPunteo()>=0.6){
                    var_repetidos +=1;   
            }
        }
        for(int i=0; i<pespecifico_metodo.size();i++){
            if(pespecifico_metodo.get(i).getPunteo()>=0.6){
                    met_repetidos +=1;   
            }
        }
        for(int i=0; i<pespecifico_comentario.size();i++){
            if(pespecifico_comentario.get(i).getPunteo()>=0.6){
                    com_repetidos +=1;   
            }
        }
                
        double total=0;
       
        
        int sum_comentarios =0;
        int sum_variables =0;
        int sum_metodos =0;
        int sum_clase =0;
        for (int i =0; i<resumen.size();i++){
                       
            sum_comentarios+= resumen.get(i).getT_comentarios();
            sum_variables+= resumen.get(i).getT_variables();
            sum_metodos+= resumen.get(i).getT_metodos();
            sum_clase+= resumen.get(i).getT_clases();
        }
        double c = (((double)com_repetidos/sum_comentarios)*0.2);
        double v = (((double)var_repetidos/sum_variables)*0.2);
        double m = (((double)met_repetidos/sum_metodos)*0.3);
        double cla = (((double)cla_repetidos/sum_clase)*0.3);
        
        
        
      total =c +v+m+cla;
      total = Math.round(total*100.0)/100.0;
    
    return total;
            
    }
    
    public static String tabla_resumen(){
        String r ="";
        int cA=0;
        int vA=0;
        int coA=0;
        int mA=0;
        int cB=0;
        int vB=0;
        int coB=0;
        int mB=0;
        for (int i=0;i<resumen.size();i++){
            if(resumen.get(i).getProyecto().equals("proyectoA"))
            {
            cA +=resumen.get(i).getT_clases();
            vA +=resumen.get(i).getT_variables();
            coA +=resumen.get(i).getT_comentarios();
            mA +=resumen.get(i).getT_metodos();
            
            }else
            {
                cB +=resumen.get(i).getT_clases();
                vB +=resumen.get(i).getT_variables();
                coB +=resumen.get(i).getT_comentarios();
                mB +=resumen.get(i).getT_metodos();
            }
        
        }
        // generar la grafica del resumen. 
         
        final DefaultCategoryDataset data = new DefaultCategoryDataset();
                    data.addValue(vA, "POYECTO A","Variables");
                    data.addValue(mA, "POYECTO A","Metodos");
                    data.addValue(cA, "POYECTO A","Clases");
                    data.addValue(coA, "POYECTO A","Comentarios");
                    data.addValue(vB, "POYECTO B","Variables");
                    data.addValue(mB, "POYECTO B","Metodos");
                    data.addValue(cB, "POYECTO B","Clases");
                    data.addValue(coB,"POYECTO B","Comentarios");        
       final JFreeChart chart=ChartFactory.createLineChart("Resumen General",
                "","",data,PlotOrientation.VERTICAL,
                true,true,false); 
    
        // generando la imagen 
        try{
            final ChartRenderingInfo inf = new ChartRenderingInfo (new StandardEntityCollection());
            final File archivo = new File("./reporte/images/glresumengeneral.png");
            ChartUtilities.saveChartAsPNG(archivo,chart,600,600,inf);
            Grafica g= new Grafica();
                    g.setTipo("l");
                    g.setNombre("./images/glresumengeneral.png");
                    lista_graficas.add(g);
        }catch(Exception e){
        System.out.println("Error Grafica Linea:(");
        System.out.println(e);
        }
        
        
        r="<tr>\n <td>Total Variables</td>\n <td>"+vA+"</td> \n <td>"+vB+"</td>\n </tr>"
            + "<tr>\n <td>Total Metodos</td>\n <td>"+mA+"</td>\n <td>"+mB+"</td>\n </tr>"
            + "<tr>\n <td>Total Clases</td>\n <td>"+cA+"</td>\n <td>"+cB+"</td>\n </tr>"
            + "<tr>\n <td>Total Comentarios</td>\n <td>"+coA+"</td>\n <td>"+coB+"</td>\n </tr>";
    
        return r;
    }
    
    //=================================== METODO PARA GUARDAR PATH DE ARCHIVOS  ===============================
    public void Almacenar_Path(String variable,String valor){

       path_archivos.put(variable, valor);        
    };
    
    public static void Recorrer_path(){
    System.out.println("\n PATH INGRESADOS: ");
    for (String clave : path_archivos.keySet()) {
            String valor = path_archivos.get(clave);
            System.out.println("Clave: " + clave + ", valor: " + valor);
        }
    }
    
    //=================================== METODO PARA GUARDAR VALORES DE GRAFICA DE BARRAS  ====================
    public void Almacenar_gbarras(String a,String b,String c,String d,String e){
        String aux="";
        //reconociendo el titulo
        String z=a.replace("\"","");
        z=z.replaceAll("\\s","");
        if(variables_globales.containsKey(z)){
            a=variables_globales.get(z);
        }
        // reconociendo los titulos del eje x
        aux = b.replace("[", "");
        aux = aux.replace("]","");
        String[] aux2 = aux.split(",");
        b="";
        aux="";
        for(int i=0;i<aux2.length;i++){
            String  w=aux2[i].replace("\"","");
                    w= w.replaceAll("\\s","");
            if(variables_globales.containsKey(w)){
                b +=variables_globales.get(w)+",";
            }else
            {
                b += aux2[i]+",";
            }
        }
        b = b.substring(0, b.length()-1);
        
        // reconociendo los valores 
        
        aux=c.replace("[", "");
        aux=aux.replace("]", "");
        aux=aux.replace("$", "");
        aux=aux.replaceAll("\\s","");
        boolean concat =false;
        String x="";
        String y="";
        for(int i=0;i<aux.length();i++){
           
            if (aux.charAt(i) =='{') {
                concat=true;
                y="";
            }
            else if(aux.charAt(i) =='}')
            {
                concat=false;
                y=y.replace(",", ";");
                y=y.replace("{","");
                x +=y;
            }
            if(concat){
                y += aux.charAt(i);
            }else{
                x +=aux.charAt(i);
            }
        }
        c=x.replace("}","");;
        // reconociendo titulo x
        z=d.replace("\"","");
        z=z.replaceAll("\\s","");
         if(variables_globales.containsKey(z)){
            d=variables_globales.get(z);
        }
        // reconociendo titulo y
        z=e.replace("\"","");
        z=z.replaceAll("\\s","");
         if(variables_globales.containsKey(z)){
            e=variables_globales.get(z);
        }
        
        Barras barras = new Barras();
        barras.setTitulo(a);
        barras.setEjex(b);
        barras.setValores(c);
        barras.setTitulox(d);
        barras.setTituloy(e);
       grafica_barras.add(barras);
    };
    
    public static void Recorrer_gbarras(){
    System.out.println("\n INSTRUCCIONES GRAFICA DE BARRAS:\n ");
    for (int i=0;i< grafica_barras.size();i++) {
            System.out.println("TITULO: " +grafica_barras.get(i).getTitulo());
            System.out.println("EJEX: " +grafica_barras.get(i).getEjex());
            System.out.println("VALORES: " +grafica_barras.get(i).getValores());
            System.out.println("TITULO X: " +grafica_barras.get(i).getTitulox());
            System.out.println("TITULO Y: " +grafica_barras.get(i).getTituloy()+"\n");
        }
    }
        
    //==================================== METODO PARA GUARDAR VARIABLES GLOBALES  =============================
    public static void Almacenar_varglobales(String variable,String valor){

        variables_globales.put(variable.replace("\"",""), valor);        
    };
    
    public static void Recorrer_varglobales(){
    System.out.println("\nRECORRIENDO LAS VARIABLES GLOBALES: ");
    for (String clave : variables_globales.keySet()) {
            String valor = variables_globales  .get(clave);
            System.out.println("Clave: " + clave + ", valor: " + valor);
        }
    }
    
    //===================================== METODO PARA GUARDAR VALORES DE GRAFICA DE PIE ==========================
    public void Almacenar_gpie(String a,String b,String c){
        String aux="";
        //reconociendo el titulo
        String z=a.replace("\"","");
        z=z.replaceAll("\\s","");
        if(variables_globales.containsKey(z)){
            a=variables_globales.get(z);
        }
        // reconociendo los titulos del eje x
        aux = b.replace("[", "");
        aux = aux.replace("]","");
        String[] aux2 = aux.split(",");
        b="";
        aux="";
        for(int i=0;i<aux2.length;i++){
            String  w=aux2[i].replace("\"","");
                    w= w.replaceAll("\\s","");
            if(variables_globales.containsKey(w)){
                b+=variables_globales.get(w)+",";
            }else
            {
                b += aux2[i]+",";
            }
        }
        b = b.substring(0, b.length()-1);
        
        // reconociendo los valores 
        
        aux=c.replace("[", "");
        aux=aux.replace("]", "");
        aux=aux.replace("$", "");
        aux=aux.replaceAll("\\s","");
        boolean concat =false;
        String x="";
        String y="";
        for(int i=0;i<aux.length();i++){
           
            if (aux.charAt(i) =='{') {
                concat=true;
                y="";
            }
            else if(aux.charAt(i) =='}')
            {
                concat=false;
                y=y.replace(",", ";");
                y=y.replace("{","");
              
                x +=y;
            }
            if(concat){
                y += aux.charAt(i);
            }else{
                x +=aux.charAt(i);
            }
        }
        c=x.replace("}","");;
        Pie p= new Pie();
        p.setTitulo(a);
        p.setEjex(b);
        p.setValores(c);
       grafica_pie.add(p);
    };
    
    public static void Recorrer_gpie(){
    System.out.println("\n INSTRUCCIONES GRAFICA DE PIE: ");
    for (int i=0;i< grafica_pie.size();i++) {
            System.out.println("TITULO: " +grafica_pie.get(i).getTitulo());
            System.out.println("EJEX: " +grafica_pie.get(i).getEjex());
            System.out.println("VALORES: " +grafica_pie.get(i).getValores()+"\n");
        }
    }
    
     //==================================== METODO PARA GUARDAR VALORES DE GRAFICA DE LINEA ======================
    public  void Almacenar_glinea(String a,String b){
       
        //reconociendo el titulo
        String z=a.replace("\"","");
        z=z.replaceAll("\\s","");
        if(variables_globales.containsKey(z)){
            a=variables_globales.get(z);
        }
        Lineas l= new Lineas();
        l.setArchivo(b.replace("\"", ""));
        l.setTitulo(a);
       grafica_linea.add(l);
    };
    
    public static void Recorrer_glinea(){
    System.out.println("\n INSTRUCCIONES GRAFICA DE LINEAS: ");
    for (int i=0;i< grafica_linea.size();i++) {
            System.out.println("TITULO: "+grafica_linea.get(i).getTitulo());
            System.out.println("ARCHIVO: "+grafica_linea.get(i).getArchivo());
        }
    }
    
    
    // ================================================================================================================
    // ========================================== METODO PARA GENERAR LOS REPORTES ====================================
    // ================================================================================================================
    public  static void Generar_reporte() throws IOException{
        //puntaje_general();
        
        
        Generar_gbarras();
        Generar_glinea();
        Generar_gpie();
        Reporte_general();
        generar_reporte_errores();
        generar_reporte_token();
        generar_Json();
       
        
    }
    
    public static void Generar_gbarras() {
        String nombre_grafico ="";
        String nombre_columna ="";
        String nombre_numeracion ="";
        String aux="";
        String val_x="";
       
        // asignando valor a las variables
        
       
        for(int i=0;i<grafica_barras.size();i++){
            try{
             // asignando titulo 
            nombre_grafico = grafica_barras.get(i).getTitulo().replaceAll("^\"+|\"+$", "");
            // asignando titulo eje x
            nombre_columna = grafica_barras.get(i).getTitulox();
            // asignando titulo y o enumeracion
            nombre_numeracion = grafica_barras.get(i).getTituloy();
            // agregando los titulos del eje x
            aux = grafica_barras.get(i).getEjex();
            String[] val2_x = aux.split(",");
            
            // agregando los valores 
            String val = grafica_barras.get(i).getValores();
            String[] val2 = val.split(",");
            double [] val3 = new double[val2.length];
            for (int x=0;x<val2.length;x++){
                // si es un double
                String verificar =val2[x].replaceAll("\\s","");
                if(isDouble(val2[x])){
                    val3[x]=Double.parseDouble(val2[x]);
                }else if(variables_globales.containsKey(verificar))
                {
                    if(isDouble(variables_globales.get(verificar))){
                        val3[x] = Double.parseDouble(variables_globales.get(verificar));
                    }else{
                         val3[x]=valor(variables_globales.get(verificar));
                    }
                }else{
                    val3[x]=valor(variables_globales.get(verificar));
                }
            }
            
            DefaultCategoryDataset gbarras = new DefaultCategoryDataset();
            // ingresando los datos en la tabla 
            // double , string, string
            // crear metodo para obtener los valores
            for(int j=0;j<val2_x.length; j++){
            gbarras.setValue(val3[j],"Resultados",val2_x[j] );
            }
            // crear grafico
            // nombre del grafico, nombre de la barra o columnas, nombre de la numeracion
            // datos del grafico, orientacion,  legenda de barras individuales por color
            // herramientas , url del grafico
            JFreeChart graf_barras = ChartFactory.createBarChart3D(nombre_grafico,nombre_columna,nombre_numeracion,
                    gbarras,PlotOrientation.VERTICAL,true,true,false
                    );

            // generando la imagen 
            
                final ChartRenderingInfo inf = new ChartRenderingInfo (new StandardEntityCollection());
                final File archivo = new File("./reporte/images/gb"+i+".png");
                ChartUtilities.saveChartAsPNG(archivo,graf_barras,1000,400,inf);
                Grafica g= new Grafica();
                g.setTipo("b");
                g.setNombre("./images/gb"+i+".png");
                lista_graficas.add(g);
            }catch(Exception e){
            System.out.println("Error grafica de barras :(");
            System.out.println(e);
            }
            
        }
        
    }
    
    public static void Generar_gpie(){
        String nombre_grafico ="";
        String aux="";
        String val_x="";
        for(int i=0;i<grafica_pie.size();i++){
            try{
                // asignando titulo 
               nombre_grafico = grafica_pie.get(i).getTitulo().replaceAll("\\s","");
               // agregando los titulos del eje x
               val_x = grafica_pie.get(i).getEjex();
               String[] val2_x = val_x.split(",");

               // agregando los valores 
               String val = grafica_pie.get(i).getValores();
               String[] val2 = val.split(",");
               double [] val3 = new double[val2.length];
               for (int x=0;x<val2.length;x++){
                   // si es un double
                   String verificar =val2[x].replaceAll("\\s","");
                   if(isDouble(val2[x])){
                       val3[x]=Double.parseDouble(val2[x]);
                   }else if(variables_globales.containsKey(verificar))
                   {
                       if(isDouble(variables_globales.get(verificar))){
                            val3[x] = Double.parseDouble(variables_globales.get(verificar));
                        }else{
                            val3[x]=valor(variables_globales.get(verificar));
                        }
                   }else{
                       val3[x]=valor(variables_globales.get(verificar));
                   }
               }

               DefaultPieDataset gcircular = new DefaultPieDataset();
               // ingresando los datos en la tabla 
               // categoria "string" , double
               // crear metodo para obtener los valores

                for(int j=0;j<val2_x.length; j++){
                    gcircular.setValue(val2_x[j], val3[j]);
               }
               // crear grafico
               // nombre del grafico, datos, nombre de las categorias, herramientas,generacion url
               JFreeChart graf_circular = ChartFactory.createPieChart(nombre_grafico, gcircular, true, true, false);

               // generando la imagen 

                final ChartRenderingInfo inf = new ChartRenderingInfo (new StandardEntityCollection());
                final File archivo = new File("./reporte/images/gc"+i+".png");
                ChartUtilities.saveChartAsPNG(archivo,graf_circular,600,600,inf);
                    Grafica g= new Grafica();
                    g.setTipo("c");
                    g.setNombre("./images/gc"+i+".png");
                    lista_graficas.add(g);
                }catch(Exception e){
                System.out.println("Error grafica Pie :(");
                System.out.println(e);
                }
        }
           
    }
    
    
    public static void Generar_glinea(){
    String nombre_grafico ="";
    String nombre_archivo="";
   
    
    for (int i=0; i<grafica_linea.size();i++){
        // asignando titulo 
        nombre_grafico = grafica_linea.get(i).getTitulo().replaceAll("\\s","");
        nombre_archivo = grafica_linea.get(i).getArchivo();
        
        final DefaultCategoryDataset data = new DefaultCategoryDataset();
     
        // se agregan los valores al proyecto A y B
        for(int j=0;j<resumen.size();j++){
      
                if(resumen.get(j).getArchivo().equals(nombre_archivo)){
                    if(resumen.get(j).getProyecto().equals("proyectoA")){
                    data.addValue(resumen.get(j).getT_variables(), "POYECTO A","Variables");
                    data.addValue(resumen.get(j).getT_metodos(), "POYECTO A","Metodos");
                    data.addValue(resumen.get(j).getT_clases(), "POYECTO A","Clases");
                    data.addValue(resumen.get(j).getT_comentarios(), "POYECTO A","Cometnarios");
                    }
                    else if(resumen.get(j).getProyecto().equals("proyectoB")){
                    data.addValue(resumen.get(j).getT_variables(), "POYECTO B","Variables");
                    data.addValue(resumen.get(j).getT_metodos(), "POYECTO B","Metodos");
                    data.addValue(resumen.get(j).getT_clases(), "POYECTO B","Clases");
                    data.addValue(resumen.get(j).getT_comentarios(), "POYECTO B","Cometnarios");
                    }              
                }
        }
       final JFreeChart chart=ChartFactory.createLineChart(nombre_grafico,
                "","",data,PlotOrientation.VERTICAL,
                true,true,false); 
    
        // generando la imagen 
        try{
            final ChartRenderingInfo inf = new ChartRenderingInfo (new StandardEntityCollection());
            final File archivo = new File("./reporte/images/gl"+i+".png");
            ChartUtilities.saveChartAsPNG(archivo,chart,600,600,inf);
            Grafica g= new Grafica();
                    g.setTipo("l");
                    g.setNombre("./images/gl"+i+".png");
                    lista_graficas.add(g);
        }catch(Exception e){
        System.out.println("Error Grafica Linea:(");
        System.out.println(e);
        }
        
    
    
    }
    
     }
    
    
    public  static void Reporte_general() throws IOException{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String fecha = dtf.format(LocalDateTime.now());
        String tabla= tabla_resumen();
        //System.out.println("yyyy/MM/dd HH:mm:ss-> "+dtf.format(LocalDateTime.now()));
        String lista_glinea="";
        String lista_gbarra="";
        String lista_gpie="";
        for(int i=0; i<lista_graficas.size();i++){
            if(lista_graficas.get(i).getTipo().equals("b")){
                lista_gbarra+="<div class=\"col-md-6 col-sm-6 nopadding\"> <img src=\""+lista_graficas.get(i).getNombre()+"\"></div>\n";
            }else if(lista_graficas.get(i).getTipo().equals("l")){
                lista_glinea+="<div class=\"col-md-6 col-sm-6 nopadding\"> <img src=\""+lista_graficas.get(i).getNombre()+"\"></div>\n";
            }else{
                lista_gpie+="<div class=\"col-md-6 col-sm-6 nopadding\"> <img src=\""+lista_graficas.get(i).getNombre()+"\"></div>\n";
            }
        }
        
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
                        "                           <table class=\"table\">\n" +
"                                                       <thead class=\"table-dark\">\n" +
    "                                                       <tr>\n" +
        "							<td>Tipo</td>\n" +
        "							<td>ProyectoA</td>\n" +
        "							<td>ProyectoB</td>\n" +
    "                                                       </tr>\n" +
"                                                       </thead>\n" +
"                                                       <tbody>\n" +tabla  +
"                                                       </tbody>\n" +
"                                                   </table>"+"</div>\n" +
"                                               </div>\n" +
"                                           </div>\n" +
"                                       </br>"+
        
        
            "<section class=\"feature\">\n" +
                            "	<div class=\"container\">\n" +
                            "		<div class=\"row\">\n" +
                            "			<div class=\"col-md-8 col-sm-8\">\n" +
                            "				<div class=\"feature-box\">\n" +
                            "					<h1>GRAFICA DE LINEA </h1>					\n" +
                            "				</div>\n" +
                            "			</div>\n" +
                            "		</div>\n" +
                            "	</div>\n" +
                            "</br>\n" +
                            "</section>\n" 
        + "               </section>"+
                            "<section class=\"feature\">\n" +
                            "	<div class=\"container\">\n" +
                            "		<div class=\"row\">\n" +
                            "	           "+lista_glinea+"<!-- aqui van las graficas de linea-->\n" +
                            "		</div>\n" +
                            "	</div>\n" +
                            "\n" +
                            "</br>\n" +
                            "</section>"+
        
                //============== seccion de grafica de barras ================
                            "<section class=\"feature\">\n" +
                            "	<div class=\"container\">\n" +
                            "		<div class=\"row\">\n" +
                            "			<div class=\"col-md-8 col-sm-8\">\n" +
                            "				<div class=\"feature-box\">\n" +
                            "					<h1>GRAFICA DE BARRAS </h1>					\n" +
                            "				</div>\n" +
                            "			</div>\n" +
                            "		</div>\n" +
                            "	</div>\n" +
                            "</br>\n" +
                            "</section>\n" +
                            "\n" +
                            "<section class=\"feature\">\n" +
                            "	<div class=\"container\">\n" +
                            "		<div class=\"row\">\n" +
                            "			"+lista_gbarra+"<!-- aqui van las graficas de barras-->\n" +
                            "		</div>\n" +
                            "	</div>\n" +
                            "</br>\n" +
                            "</section>"  +                  
                                   
                 //============== seccion de grafica de pie ================
                            "<section class=\"feature\">\n" +
                            "	<div class=\"container\">\n" +
                            "		<div class=\"row\">\n" +
                            "			<div class=\"col-md-4 col-sm-4\">\n" +
                            "				<div class=\"feature-box\">\n" +
                            "					<h1>GRAFICA DE PIE </h1>\n" +
                            "				</div>\n" +
                            "			</div>\n" +
                            "		</div>\n" +
                            "	</div>\n" +
                            "</section>\n" +
                            "\n" +
                            "<section class=\"feature\">\n" +
                            "	<div class=\"container\">\n" +
                            "		<div class=\"row\">\n" +
                            "			"+lista_gpie+"<!-- aqui van las graficas de pie-->\n" +
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
    
   public static double valor(String v){
       double valor=0;
        String[] aux = v.split(";");
       
        if(aux.length==1){
            String p= aux[0];
            p=p.replace("\"","");
            p=p.replaceAll("\\s","");
            p=p.toLowerCase();
             if(p.equals("puntajegeneral")){
                 valor = total_pgeneral();
             }
        }
        
        else{
           String puntaje = aux[0];
           String archivo = aux[1];
           String tipo = aux[2];
           String value = aux[3];
           
        // se comprueba de que tipo es
            puntaje=puntaje.replace("\"","");
            puntaje=puntaje.replaceAll("\\s","");
            puntaje=puntaje.toLowerCase();
            archivo=archivo.replace("\"","");
            archivo=archivo.replaceAll("\\s","");
            tipo=tipo.replace("\"","");
            tipo=tipo.replaceAll("\\s","");
            tipo=tipo.toLowerCase();
            value=value.replace("\"","");
            value=value.replaceAll("\\s","");
            
            if(puntaje.equals("puntajeespecifico")){
                // se busca el archivo
                if(tipo.equals("clase") ){
                    for(int i=0;i<pespecifico_clase.size();i++){
                        if(pespecifico_clase.get(i).getArchivo().equals(archivo)){
                            if(pespecifico_clase.get(i).getClase1().equals(value)||pespecifico_clase.get(i).getClase2().equals(value)){
                                valor = pespecifico_clase.get(i).getPunteo();
                                break;
                            }
                            
                        }
                    }
                    
                }else if(tipo.equals("metodo")){
                    for(int i=0;i<pespecifico_metodo.size();i++){
                        if(pespecifico_metodo.get(i).getArchivo().equals(archivo)){
                            if(pespecifico_metodo.get(i).getVariable().equals(value)){
                                valor = pespecifico_metodo.get(i).getPunteo();
                                break;
                            }
                        }
                    }
                }else if(tipo.equals("variable")){
                    for(int i=0;i<pespecifico_variable.size();i++){
                        if(pespecifico_variable.get(i).getArchivo().equals(archivo)){
                            if(pespecifico_variable.get(i).getVariable().equals(value)){
                                valor = pespecifico_variable.get(i).getPunteo();
                                break;
                            }
                        }
                    }
                
                }else if(tipo.equals("comentario")){
                    for(int i=0;i<pespecifico_comentario.size();i++){
                        if(pespecifico_comentario.get(i).getArchivo().equals(archivo)){
                            if(pespecifico_comentario.get(i).getVariable().equals(value)){
                                valor = pespecifico_comentario.get(i).getPunteo();
                                break;
                            }
                        }
                    }
                
                }
               
            }
        }
       
   
       return valor;
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

    //=========================0 METODO PARA RECONOCER ERRORES ====================
    public static void errores(String a,String b,String c,String d,String e){
        Error error = new Error();
        error.setLexema(a);
        error.setTipo(b);
        error.setLinea(c);
        error.setColumna(d);
        if(e.equals("a")){
        error.setArchivo(nom_proyecto+"/"+nom_archivo);
        }else{
        error.setArchivo(e);
        }
        errores.add(error);
    }
    public static String  generar_errores(){
        String acumulador ="";
        for(int i=0;i<errores.size();i++){
                acumulador +="<tr>\n<td>"+errores.get(i).getLexema()+"<td>"+
                        "\n<td>"+errores.get(i).getTipo()+"<td>"+
                        "\n<td>"+errores.get(i).getLinea()+"<td>"+
                        "\n<td>"+errores.get(i).getColumna()+"<td>"+
                        "\n<td>"+errores.get(i).getArchivo()+"<td>"
                        ;
        }
        return acumulador;
    }
    public static void generar_reporte_errores() throws IOException{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String fecha = dtf.format(LocalDateTime.now());
        String tabla= generar_errores();
        FileWriter reporte = new FileWriter("./reporte/ReporteErrores.html");
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
                        "				REPORTE DE ERRORES	 \n" +
                        "				\n" +
                        "			</p>\n" +
                        "		</div>\n" +
                        "	</div>\n" +
                        "</header>"
                //============== seccion de resumen ================
                        +"<section class=\"feature\">\n" +
                        "	<div class=\"container\">\n" +
                        "		<div class=\"row\">\n" +
                        "			<div class=\"col-md-12 col-sm-10\">\n" +
                        "				<div class=\"feature-box\">\n" +
                        "					<h1>RESUMEN DE ERRORES </h1>\n" +
                        "				</div>\n" +
                        "			</div>\n" +
                        			
"                                           </div>\n" +
"                                       </br>"
        + "               </section>"+
                           
                //============== seccion de grafica de barras ================
                            "<section class=\"feature\">\n" +
                            "	<div class=\"container\">\n" +
                            "		<div class=\"row\">\n" +
                            "			<div class=\"col-md-8 col-sm-8 nopadding\">\n" +
                        "                           <table class=\"table\">\n" +
"                                                       <thead class=\"table-dark\">\n" +
    "                                                       <tr>\n" +
        "							<td>Lexema</td>\n" +
        "							<td>Tipo</td>\n" +
        "							<td>Linea</td>\n" +
                                                                "<td>Columna</td>\n" +
                                                                 "<td>Archivo</td>\n" +
    "                                                       </tr>\n" +
"                                                       </thead>\n" +
"                                                       <tbody>\n" +tabla+
"                                                       </tbody>\n" +
"                                                   </table>"+"</div>\n" +
"                                               </div>\n" +
                            "		</div>\n" +
                            "	</div>\n" +
                            "</br>\n" +
                            "</section>\n" +
                            "\n" +
                          
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

    ///=========================== REPORTE DE TOKENS =====================
    public static void tokens(String a,String b,String c,String d,String e){
        Tokens t = new Tokens();
        t.setLexema(b);
        t.setToken(a);
        t.setLinea(c);
        t.setColumna(d);
        
        if(e.equals("a")){
            t.setArchivo(nom_proyecto+"/"+nom_archivo);
        }else{
            t.setArchivo(e);
        }
        token.add(t);
    }
    public static String generar_lista_tokens(){
        String acumulador ="";
        for(int i=0;i<token.size();i++){
                acumulador +="<tr>\n<td>"+token.get(i).getLexema()+"<td>"+
                        "\n<td>"+token.get(i).getToken()+"<td>"+
                        "\n<td>"+token.get(i).getLinea()+"<td>"+
                        "\n<td>"+token.get(i).getColumna()+"<td>"+
                        "\n<td>"+token.get(i).getArchivo()+"<td>"
                        ;
        }
        return acumulador;
    }
    public static void generar_reporte_token() throws IOException{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String fecha = dtf.format(LocalDateTime.now());
        String tabla= generar_lista_tokens();
        FileWriter reporte = new FileWriter("./reporte/ReporteTokens.html");
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
                        "				REPORTE DE TOKENS	 \n" +
                        "				\n" +
                        "			</p>\n" +
                        "		</div>\n" +
                        "	</div>\n" +
                        "</header>"
                //============== seccion de resumen ================
                        +"<section class=\"feature\">\n" +
                        "	<div class=\"container\">\n" +
                        "		<div class=\"row\">\n" +
                        "			<div class=\"col-md-12 col-sm-10\">\n" +
                        "				<div class=\"feature-box\">\n" +
                        "					<h1>RESUMEN DE TOKENS </h1>\n" +
                        "				</div>\n" +
                        "			</div>\n" +
                        			
"                                           </div>\n" +
"                                       </br>"
        + "               </section>"+
                           
                //============== seccion de grafica de barras ================
                            "<section class=\"feature\">\n" +
                            "	<div class=\"container\">\n" +
                            "		<div class=\"row\">\n" +
                            "			<div class=\"col-md-8 col-sm-8 nopadding\">\n" +
                        "                           <table class=\"table\">\n" +
"                                                       <thead class=\"table-dark\">\n" +
    "                                                       <tr>\n" +
        "							<td>Lexema</td>\n" +
        "							<td>Token</td>\n" +
        "							<td>Linea</td>\n" +
                                                                "<td>Columna</td>\n" +
                                                                 "<td>Archivo</td>\n" +
    "                                                       </tr>\n" +
"                                                       </thead>\n" +
"                                                       <tbody>\n" +tabla+
"                                                       </tbody>\n" +
"                                                   </table>"+"</div>\n" +
"                                               </div>\n" +
                            "		</div>\n" +
                            "	</div>\n" +
                            "</br>\n" +
                            "</section>\n" +
                            "\n" +
                          
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

    public static String obtenerJson(){
        double pt=total_pgeneral();
        String json="";
        /*
        JSONObject obj = new JSONObject();
        
        obj.put("puntajegeneral",new Double(pt)); 
        obj.put("puntaespecifico",'[');
        */
        json +="{\n"
                + "\t\"puntajegeneral\":"+pt+",\n"
                + "\t\"puntajeespecifico\":[\n";
      
        for(int i=0;i<pespecifico_clase.size();i++){
            json += "\t\t{\n \t\t\t\"archivo\":\""+pespecifico_clase.get(i).getArchivo()+"\",\n";
            json += "\t\t\t\"tipo\":\"clase\",\n";
            json += "\t\t\t\"nombre1\":\""+pespecifico_clase.get(i).getClase1()+"\",\n";
            json += "\t\t\t\"puntaje\":"+pespecifico_clase.get(i).getPunteo()+"\n";
            json +="\t\t},";
            json += "\t\t{\n \t\t\t\"archivo\":\""+pespecifico_clase.get(i).getArchivo()+"\",\n";
            json += "\t\t\t\"tipo\":\"clase\",\n";
            json += "\t\t\t\"nombre\":\""+pespecifico_clase.get(i).getClase2()+"\",\n";
            json += "\t\t\t\"puntaje\":"+pespecifico_clase.get(i).getPunteo()+"\n";
            json +="\t\t},\n";
        }
        for(int i=0;i<pespecifico_metodo.size();i++){
            json += "\t\t{\n \t\t\t\"archivo\":\""+pespecifico_metodo.get(i).getArchivo()+"\",\n";
            json += "\t\t\t\"tipo\":\"metodo\",\n";
            json += "\t\t\t\"nombre\":\""+pespecifico_metodo.get(i).getVariable()+"\",\n";
            json += "\t\t\t\"puntaje\":"+pespecifico_metodo.get(i).getPunteo()+"\n";
            json +="\t\t},\n";
        }
        for(int i=0;i<pespecifico_variable.size();i++){
            json += "\t\t{\n\t \t\t\"archivo\":\""+pespecifico_variable.get(i).getArchivo()+"\",\n";
            json += "\t\t\t\"tipo\":\"variable\",\n";
            json += "\t\t\t\"nombre\":\""+pespecifico_variable.get(i).getVariable()+"\",\n";
            json += "\t\t\t\"puntaje\":"+pespecifico_variable.get(i).getPunteo()+"\n";
            json +="\t\t},\n";
        }
        for(int i=0;i<pespecifico_comentario.size();i++){
            json += "\t\t{\n \t\t\t\"archivo\":\""+pespecifico_comentario.get(i).getArchivo()+"\",\n";
            json += "\t\t\t\"tipo\":\"comentario\",\n";
            json += "\t\t\t\"nombre\":\""+pespecifico_comentario.get(i).getVariable()+"\",\n";
            json += "\t\t\t\"puntaje\":"+pespecifico_comentario.get(i).getPunteo()+"\n";
            json +="\t\t}\n";
        }
        
        json +="\t]\n"
                + "}";
        return json;
    
    }
    
    public static void generar_Json() throws IOException{
        String json = obtenerJson();
        FileWriter reporte = new FileWriter("./reporte/ReporteJSON.json");
        reporte.write(json);
        reporte.close();
        
    }
}
