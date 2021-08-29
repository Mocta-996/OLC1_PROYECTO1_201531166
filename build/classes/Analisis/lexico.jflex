package Analisis;

import java_cup.runtime.Symbol;

// LEXICO PARA ANALIZAR LA ENTRADA DE LOS REPORTES

%%

%{
    //Código de usuario
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
COMENTARIO_LINEA =("##".*\r\n+)|("##".*\n+)|("#".*\r+)
VALOR_EJEX  = ("["([^\n]|(\\))*"]")+


SPACE   = [\ \r\t\f\t]
ENTER   = [\ \n]

%%



<YYINITIAL> {COMPARE}    { return new Symbol(sym.COMPARE, yyline, yycolumn,yytext());}
<YYINITIAL> {STRING}     { return new Symbol(sym.STRING, yyline, yycolumn,yytext());}
<YYINITIAL> {DOUBLE}     { return new Symbol(sym.DOUBLE, yyline, yycolumn,yytext());}
<YYINITIAL> {GENERAR_REPORTE}     { return new Symbol(sym.GENERAR_REPORTE, yyline, yycolumn,yytext());}
<YYINITIAL> {DEFINIR_GLOBALES}     { return new Symbol(sym.DEFINIR_GLOBALES, yyline, yycolumn,yytext());}
<YYINITIAL> {TITULO}     { return new Symbol(sym.TITULO, yyline, yycolumn,yytext());}
<YYINITIAL> {GRAFICA_BARRAS}     { return new Symbol(sym.GRAFICA_BARRAS, yyline, yycolumn,yytext());}
<YYINITIAL> {EJEX}     { return new Symbol(sym.EJEX, yyline, yycolumn,yytext());}
<YYINITIAL> {VALORES}     { return new Symbol(sym.VALORES, yyline, yycolumn,yytext());}
<YYINITIAL> {TITULOX}     { return new Symbol(sym.TITULOX, yyline, yycolumn,yytext());}
<YYINITIAL> {TITULOY}     { return new Symbol(sym.TITULOY, yyline, yycolumn,yytext());}
<YYINITIAL> {GRAFICA_PIE}     { return new Symbol(sym.GRAFICA_PIE, yyline, yycolumn,yytext());}
<YYINITIAL> {GRAFICA_LINE}     { return new Symbol(sym.GRAFICA_LINE, yyline, yycolumn,yytext());}
<YYINITIAL> {ARCHIVO}     { return new Symbol(sym.ARCHIVO, yyline, yycolumn,yytext());}


<YYINITIAL> {PAR_IZQ}     {return new Symbol(sym.PAR_IZQ, yyline, yycolumn,yytext());}
<YYINITIAL> {PAR_DER}     {return new Symbol(sym.PAR_DER, yyline, yycolumn,yytext());}
<YYINITIAL> {LLAV_IZQ}    {return new Symbol(sym.LLAV_IZQ, yyline, yycolumn,yytext());}
<YYINITIAL> {LLAV_DER}    {return new Symbol(sym.LLAV_DER, yyline, yycolumn,yytext());}
<YYINITIAL> {COMA}        {return new Symbol(sym.COMA, yyline, yycolumn,yytext());}
<YYINITIAL> {PTCOMA}      {return new Symbol(sym.PTCOMA, yyline, yycolumn,yytext());}
<YYINITIAL> {IGUAL}       {return new Symbol(sym.IGUAL, yyline, yycolumn,yytext());}
<YYINITIAL> {DOSPT}       {return new Symbol(sym.DOSPT, yyline, yycolumn,yytext());}
<YYINITIAL> {DOLLAR}       {return new Symbol(sym.DOLLAR, yyline, yycolumn,yytext());}


<YYINITIAL> {ENTERO}    { return new Symbol(sym.ENTERO, yyline, yycolumn,yytext());}
<YYINITIAL> {DECIMAL}   { return new Symbol(sym.DECIMAL, yyline, yycolumn,yytext());}
<YYINITIAL> {ID}        {return new Symbol(sym.ID, yyline, yycolumn,yytext());}
<YYINITIAL> {CADENA}    {return new Symbol(sym.CADENA, yyline, yycolumn,yytext());}
<YYINITIAL> {CADENA_SIMP}    {return new Symbol(sym.CADENA_SIMP, yyline, yycolumn,yytext());}

<YYINITIAL> {COMENTARIO_LINEA}    {System.out.println("Este es un comentario:"+yytext());} 
<YYINITIAL> {COMENTARIO_MULINEA}    {System.out.println("Este es un comentario:"+yytext());} 
<YYINITIAL> {VALOR_EJEX}   {return new Symbol(sym.VALOR_EJEX, yyline, yycolumn,yytext());}


//<YYINITIAL> [\"]        { yybegin(CADENA); cadena+="\""; }
<YYINITIAL> {SPACE}     { /*Espacios en blanco, ignorados*/ }
<YYINITIAL> {ENTER}     { /*Saltos de linea, ignorados*/}


<YYINITIAL> . {
        String errLex = "Error léxico : '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+(yycolumn+1);
        System.out.println(errLex);
}

//<CADENA> {
//        [\"] { String tmp=cadena+"\""; cadena=""; yybegin(YYINITIAL);  return new Symbol(sym.CADENA, yychar,yyline,tmp); }
//        [\n] {String tmp=cadena; cadena="";  
//                System.out.println("Se esperaba cierre de cadena (\")."); 
//                yybegin(YYINITIAL);
//            }
//        [^\"] { cadena+=yytext();}
//}
