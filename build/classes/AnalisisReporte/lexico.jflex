package AnalisisReporte;
import Data.Data;
import java_cup.runtime.Symbol;



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
%caseless
//%ignorecase

//simbolos

PAR_IZQ   = "("
PAR_DER   = ")"
LLAV_IZQ  = "{"
LLAV_DER  = "}" 
COMA    = ","
PTCOMA  = ";"
DOSPT  = ":"
IGUAL  = "="

// OPERADORES RELACIONALES
IGUALACION  = "=="
DIFERENCIA  = "!="
MENOR_Q     = "<"
MAYOR_Q     = ">"
MENOR_IGUAL = "<="
MAYOR_IGUAL = ">="

//ORDENADORES LOGICOS

AND     = "&&"
OR      = "||"
NOT     = "!"

// OPERADORES ARITMETICOS
MAS     = "+"
MENOS   = "-"
POR     = "*"
DIVISION = "/"
POTENCIA = "**"
MODULO  = "%"
//UNARIO  = "-"

//palabras reservadas 

CLASE   ="class"
VAR     ="var"
LET     ="let"
CONST   ="const"
IF      ="if"
ELSE    ="else"
FOR     ="for"
DO      ="do"
WHILE   ="while"
SWITCH  ="switch"
BREAK   ="break"
CASE    ="case"
DEFAULT ="default"
REQUIRE = "require"
CONSOLA = "console.log"

//expresiones
ENTERO  = [0-9]+   
DECIMAL = [0-9]+("."[  |0-9]+)?
ID      = [A-Za-zñÑ][_0-9A-Za-zñÑ]*
CADENA  = (\"([^\"\n]|(\\\"))*\")+
CADENA_SIMP  = (\'([^\'\n]|(\\\'))*\')+
COMENTARIO_LINEA =("//".*\r\n)|("//".*\n)|("//".*\r)
COMENTARIO_MULINEA ="/*""/"*([^*/]|[^*]"/"|"*"[^/])*"*"*"*/"

SPACE   = [\ \r\t\f\t]
ENTER   = [\ \n]

%%

<YYINITIAL> {CLASE}      {  datos.tokens("PR_clase",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.CLASE, yyline, yycolumn,yytext());}

<YYINITIAL> {VAR}      {    datos.tokens("PR_var",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.VAR, yyline, yycolumn,yytext());}

<YYINITIAL> {LET}      {    datos.tokens("PR_let",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.LET, yyline, yycolumn,yytext());}

<YYINITIAL> {CONST}      {  datos.tokens("PR_const",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.CONST, yyline, yycolumn,yytext());}

<YYINITIAL> {IF}      {     datos.tokens("PR_if",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.IF, yyline, yycolumn,yytext());}

<YYINITIAL> {ELSE}      {   datos.tokens("PR_else",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.ELSE, yyline, yycolumn,yytext());}

<YYINITIAL> {FOR}      {    datos.tokens("PR_for",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.FOR, yyline, yycolumn,yytext());}

<YYINITIAL> {DO}      {     datos.tokens("PR_do",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.DO, yyline, yycolumn,yytext());}

<YYINITIAL> {WHILE}      {  datos.tokens("PR_while",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.WHILE, yyline, yycolumn,yytext());}

<YYINITIAL> {SWITCH}      { datos.tokens("PR_switch",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.SWITCH, yyline, yycolumn,yytext());}

<YYINITIAL> {CASE}      {   datos.tokens("PR_case",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a"); 
                            return new Symbol(sym.CASE, yyline, yycolumn,yytext());}

<YYINITIAL> {BREAK}      {  datos.tokens("PR_break",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a"); 
                            return new Symbol(sym.BREAK, yyline, yycolumn,yytext());}

<YYINITIAL> {DEFAULT}      {datos.tokens("PR_default",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.DEFAULT, yyline, yycolumn,yytext());}

<YYINITIAL> {REQUIRE}      {datos.tokens("PR_require",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.REQUIRE, yyline, yycolumn,yytext());}

<YYINITIAL> {CONSOLA}      {datos.tokens("PR_consol.log",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.CONSOLA, yyline, yycolumn,yytext());}


<YYINITIAL> {PAR_IZQ}     { datos.tokens("parentesisizquierdo",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.PAR_IZQ, yyline, yycolumn,yytext());}

<YYINITIAL> {PAR_DER}     { datos.tokens("parentesisderecho",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.PAR_DER, yyline, yycolumn,yytext());}

<YYINITIAL> {LLAV_IZQ}    { datos.tokens("llaveizquierdo",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.LLAV_IZQ, yyline, yycolumn,yytext());}

<YYINITIAL> {LLAV_DER}    { datos.tokens("llavederecho",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.LLAV_DER, yyline, yycolumn,yytext());}

<YYINITIAL> {COMA}      {   datos.tokens("coma",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");  
                            return new Symbol(sym.COMA, yyline, yycolumn,yytext());}

<YYINITIAL> {PTCOMA}    {   datos.tokens("puntoycoma",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.PTCOMA, yyline, yycolumn,yytext());}

<YYINITIAL> {IGUAL}    {    datos.tokens("signo_igual",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.IGUAL, yyline, yycolumn,yytext());}

<YYINITIAL> {DOSPT}    {    datos.tokens("dospuntos",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.DOSPT, yyline, yycolumn,yytext());}

<YYINITIAL> {IGUALACION}  { datos.tokens("signoigualacion",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.IGUALACION, yyline, yycolumn,yytext());}

<YYINITIAL> {DIFERENCIA} {  datos.tokens("signodiferencia",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.DIFERENCIA, yyline, yycolumn,yytext());}

<YYINITIAL> {MENOR_Q}    {  datos.tokens("signomenor",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.MENOR_Q, yyline, yycolumn,yytext());}

<YYINITIAL> {MAYOR_Q}    {  datos.tokens("signomayor",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.MAYOR_Q, yyline, yycolumn,yytext());}

<YYINITIAL> {MENOR_IGUAL} { datos.tokens("signomenorigual",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.MENOR_IGUAL, yyline, yycolumn,yytext());}

<YYINITIAL> {MAYOR_IGUAL} { datos.tokens("signomayorigual",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.MAYOR_IGUAL, yyline, yycolumn,yytext());}

<YYINITIAL> {AND}    {      datos.tokens("signo_and",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.AND, yyline, yycolumn,yytext());}

<YYINITIAL> {OR}    {       datos.tokens("signo_or",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.OR, yyline, yycolumn,yytext());}

<YYINITIAL> {NOT}    {      datos.tokens("negacion",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a"); 
                            return new Symbol(sym.NOT, yyline, yycolumn,yytext());}

<YYINITIAL> {MAS}    {      datos.tokens("signo_mas",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.MAS, yyline, yycolumn,yytext());}

<YYINITIAL> {MENOS}    {    datos.tokens("signo_menos",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.MENOS, yyline, yycolumn,yytext());}

<YYINITIAL> {POR}    {      datos.tokens("signo_por",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.POR, yyline, yycolumn,yytext());}

<YYINITIAL> {DIVISION}    { datos.tokens("signo_division",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.DIVISION, yyline, yycolumn,yytext());}

<YYINITIAL> {POTENCIA}    { datos.tokens("potencia",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.POTENCIA, yyline, yycolumn,yytext());}

<YYINITIAL> {MODULO}    {   datos.tokens("modulo",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.MODULO, yyline, yycolumn,yytext());}

<YYINITIAL> {ENTERO}    {   datos.tokens("entero",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.ENTERO, yyline, yycolumn,yytext());}

<YYINITIAL> {DECIMAL}    {  datos.tokens("decimal",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.DECIMAL, yyline, yycolumn,yytext());}

<YYINITIAL> {ID}        {   datos.tokens("id",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.ID, yyline, yycolumn,yytext());}

<YYINITIAL> {CADENA}    {   datos.tokens("cadena",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.CADENA, yyline, yycolumn,yytext());}

<YYINITIAL> {CADENA_SIMP} { datos.tokens("cadena",yytext(),String.valueOf((yyline)), String.valueOf((yycolumn)), "a");
                            return new Symbol(sym.CADENA_SIMP, yyline, yycolumn,yytext());}

<YYINITIAL> {COMENTARIO_LINEA}    {return new Symbol(sym.COMENTARIO_LINEA, yyline, yycolumn,yytext());} 

<YYINITIAL> {COMENTARIO_MULINEA}    {return new Symbol(sym.COMENTARIO_MULINEA, yyline, yycolumn,yytext());} 


<YYINITIAL> {SPACE}     { /*Espacios en blanco, ignorados*/ }
//<YYINITIAL> {ENTER}     { /*Saltos de linea, ignorados*/}
<YYINITIAL> {ENTER}    {return new Symbol(sym.ENTER, yyline, yycolumn,yytext());}



<YYINITIAL> . {
        String errLex = "Error léxico : '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+(yycolumn+1);
        System.out.println(errLex);
        String a= yytext().toString();
        String b= yytext().toString();
        int cc = (yyline+1);
        int dd= (yycolumn+1);
        String c= String.valueOf(cc);
        String d= String.valueOf(dd);
        datos.errores(a,"Error Lexico: "+b,c,d,"a");
}

