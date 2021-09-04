package Analisis;
import Data.Data;
import java_cup.runtime.Symbol;

// LEXICO PARA ANALIZAR LA ENTRADA DE LOS REPORTES

%%

%{
    //Código de usuario
    Data datos = new Data();
    String cadena= "";
%}

%cup
%class scanner
%public
%line
%char
%column
%full
%state CADENA
%ignorecase

//simbolos

PAR_IZQ   = "("
PAR_DER   = ")"
LLAV_IZQ  = "{"
LLAV_DER  = "}" 
COMA    = ","
PTCOMA  = ";"
DOSPT  = ":"
IGUAL  = "="
DOLLAR ="$"

//palabras reservadas

GENERAR_REPORTE = "generarreporteestadistico"
DEFINIR_GLOBALES = "definirglobales"
COMPARE  = "compare"
STRING   = "string"
DOUBLE   = "double"
TITULO   = "titulo"

GRAFICA_BARRAS = "graficabarras"
EJEX    = "ejex"
VALORES = "valores"
TITULOX = "titulox"
TITULOY = "tituloy"
GRAFICA_PIE ="graficapie"
GRAFICA_LINE ="graficalineas"
ARCHIVO ="archivo"



//expresiones



ENTERO  = [0-9]+   
DECIMAL = [0-9]+("."[  |0-9]+)?
ID      = [A-Za-zñÑ][_0-9A-Za-zñÑ]*
CADENA  = (\"([^\"\n]|(\\\"))*\")+
CADENA_SIMP  = (\'([^\'\n]|(\\\'))*\')+
COMENTARIO_MULINEA ="#*""/"*([^*/]|[^*]"/"|"*"[^/])*"*"*"*#"
COMENTARIO_LINEA =("##".*\r\n+)|("##".*\n+)|("##".*\r+)
VALOR_EJEX  = ("["([^\n]|(\\))*"]")+


SPACE   = [\ \r\t\f\t]
ENTER   = [\ \n]

%%



<YYINITIAL> {COMPARE}    { datos.tokens("PR_compare",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.COMPARE, yyline, yycolumn,yytext());}
                          
<YYINITIAL> {STRING}     {  datos.tokens("PR_string",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.STRING, yyline, yycolumn,yytext());}

<YYINITIAL> {DOUBLE}     {  datos.tokens("PR_double",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.DOUBLE, yyline, yycolumn,yytext());}

<YYINITIAL> {GENERAR_REPORTE}     { 
                            datos.tokens("PR_generarreporte",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.GENERAR_REPORTE, yyline, yycolumn,yytext());}

<YYINITIAL> {DEFINIR_GLOBALES}     { 
                            datos.tokens("PR_definirglobales",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.DEFINIR_GLOBALES, yyline, yycolumn,yytext());}

<YYINITIAL> {TITULO}     {  datos.tokens("PR_titulo",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.TITULO, yyline, yycolumn,yytext());}

<YYINITIAL> {GRAFICA_BARRAS}     { 
                            datos.tokens("PR_graficabarras",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.GRAFICA_BARRAS, yyline, yycolumn,yytext());}

<YYINITIAL> {EJEX}     {    datos.tokens("PR_ejex",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.EJEX, yyline, yycolumn,yytext());}

<YYINITIAL> {VALORES}     { datos.tokens("PR_valores",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.VALORES, yyline, yycolumn,yytext());}

<YYINITIAL> {TITULOX}     { datos.tokens("PR_titulox",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.TITULOX, yyline, yycolumn,yytext());}

<YYINITIAL> {TITULOY}     { datos.tokens("PR_tituloy",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.TITULOY, yyline, yycolumn,yytext());}

<YYINITIAL> {GRAFICA_PIE}     { 
                            datos.tokens("PR_graficapie",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.GRAFICA_PIE, yyline, yycolumn,yytext());}

<YYINITIAL> {GRAFICA_LINE}     {    
                            datos.tokens("PR_graficaline",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.GRAFICA_LINE, yyline, yycolumn,yytext());}

<YYINITIAL> {ARCHIVO}     { 
                            datos.tokens("PR_archivo",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.ARCHIVO, yyline, yycolumn,yytext());}


<YYINITIAL> {PAR_IZQ}     { datos.tokens("parentesisizquierdo",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.PAR_IZQ, yyline, yycolumn,yytext());}

<YYINITIAL> {PAR_DER}     { datos.tokens("parentesisderecho",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.PAR_DER, yyline, yycolumn,yytext());}

<YYINITIAL> {LLAV_IZQ}    { datos.tokens("llave izquierdo",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.LLAV_IZQ, yyline, yycolumn,yytext());}

<YYINITIAL> {LLAV_DER}    { datos.tokens("llavederecho",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.LLAV_DER, yyline, yycolumn,yytext());}

<YYINITIAL> {COMA}        { datos.tokens("coma",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.COMA, yyline, yycolumn,yytext());}

<YYINITIAL> {PTCOMA}      { datos.tokens("puntoycoma",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.PTCOMA, yyline, yycolumn,yytext());}

<YYINITIAL> {IGUAL}       { datos.tokens("signo_igual",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.IGUAL, yyline, yycolumn,yytext());}

<YYINITIAL> {DOSPT}       { datos.tokens("dospuntos",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.DOSPT, yyline, yycolumn,yytext());}

<YYINITIAL> {DOLLAR}       {datos.tokens("signo dolar",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.DOLLAR, yyline, yycolumn,yytext());}


<YYINITIAL> {ENTERO}    {   datos.tokens("num_entero",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.ENTERO, yyline, yycolumn,yytext());}

<YYINITIAL> {DECIMAL}   {   datos.tokens("num_decimal",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.DECIMAL, yyline, yycolumn,yytext());}

<YYINITIAL> {ID}        {   datos.tokens("id",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.ID, yyline, yycolumn,yytext());}

<YYINITIAL> {CADENA}    {   datos.tokens("cadena",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.CADENA, yyline, yycolumn,yytext());}

<YYINITIAL> {CADENA_SIMP} { datos.tokens("cadena",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.CADENA_SIMP, yyline, yycolumn,yytext());}

<YYINITIAL> {COMENTARIO_LINEA}    {datos.tokens("comentario_linea",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
System.out.println("Este es un comentario:"+yytext());} 

<YYINITIAL> {COMENTARIO_MULINEA}    {datos.tokens("comentario_miltilinea",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                    System.out.println("Este es un comentario:"+yytext());} 

<YYINITIAL> {VALOR_EJEX}   {datos.tokens("valor_ejex",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "Archivo.fca");
                            return new Symbol(sym.VALOR_EJEX, yyline, yycolumn,yytext());}


//<YYINITIAL> [\"]        { yybegin(CADENA); cadena+="\""; }
<YYINITIAL> {SPACE}     { /*Espacios en blanco, ignorados*/ }
<YYINITIAL> {ENTER}     { /*Saltos de linea, ignorados*/}


<YYINITIAL> . {
        String errLex = "Error léxico : '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+(yycolumn+1);
        System.out.println(errLex);
        String a= yytext().toString();
        String b= yytext().toString();
        int cc = (yyline+1);
        int dd= (yycolumn+1);
        String c= String.valueOf(cc);
        String d= String.valueOf(dd);
        datos.errores(a,"Error Lexico: "+b,c,d,"Archivo .fca");
}

//<CADENA> {
//        [\"] { String tmp=cadena+"\""; cadena=""; yybegin(YYINITIAL);  return new Symbol(sym.CADENA, yychar,yyline,tmp); }
//        [\n] {String tmp=cadena; cadena="";  
//                System.out.println("Se esperaba cierre de cadena (\")."); 
//                yybegin(YYINITIAL);
//            }
//        [^\"] { cadena+=yytext();}
//}
