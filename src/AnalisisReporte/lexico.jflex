package AnalisisReporte;

import java_cup.runtime.Symbol;



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

INT1     = "int"
CHAR1    = "char"
PUB      = "public"
PRI      = "private"
VOI      = "void"
PRINT    = "print"

//expresiones

ENTERO  = [0-9]+   
DECIMAL = [0-9]+("."[  |0-9]+)?
ID      = [A-Za-zñÑ][_0-9A-Za-zñÑ]*
CADENA  = (\"([^\"\n]|(\\\"))*\")+
CADENA_SIMP  = (\'([^\"\n]|(\\\"))*\')+
COMENTARIO_LINEA =("//".*\r\n)|("//".*\n)|("//".*\r)
COMENTARIO_MULINEA ="/*""/"*([^*/]|[^*]"/"|"*"[^/])*"*"*"*/"

SPACE   = [\ \r\t\f\t]
ENTER   = [\ \n]

%%

<YYINITIAL> {CLASE}      { return new Symbol(sym.CLASE, yyline, yycolumn,yytext());}
<YYINITIAL> {VAR}      { return new Symbol(sym.VAR, yyline, yycolumn,yytext());}
<YYINITIAL> {LET}      { return new Symbol(sym.LET, yyline, yycolumn,yytext());}
<YYINITIAL> {CONST}      { return new Symbol(sym.CONST, yyline, yycolumn,yytext());}
<YYINITIAL> {IF}      { return new Symbol(sym.IF, yyline, yycolumn,yytext());}
<YYINITIAL> {ELSE}      { return new Symbol(sym.ELSE, yyline, yycolumn,yytext());}
<YYINITIAL> {FOR}      { return new Symbol(sym.FOR, yyline, yycolumn,yytext());}
<YYINITIAL> {DO}      { return new Symbol(sym.DO, yyline, yycolumn,yytext());}
<YYINITIAL> {WHILE}      { return new Symbol(sym.WHILE, yyline, yycolumn,yytext());}
<YYINITIAL> {SWITCH}      { return new Symbol(sym.SWITCH, yyline, yycolumn,yytext());}
<YYINITIAL> {CASE}      { return new Symbol(sym.CASE, yyline, yycolumn,yytext());}
<YYINITIAL> {BREAK}      { return new Symbol(sym.BREAK, yyline, yycolumn,yytext());}
<YYINITIAL> {DEFAULT}      { return new Symbol(sym.DEFAULT, yyline, yycolumn,yytext());}
<YYINITIAL> {REQUIRE}      { return new Symbol(sym.REQUIRE, yyline, yycolumn,yytext());}


<YYINITIAL> {INT1}      { return new Symbol(sym.INT1, yyline, yycolumn,"entero");}
<YYINITIAL> {CHAR1}     { return new Symbol(sym.CHAR1, yyline, yycolumn,"caracter");}
<YYINITIAL> {PUB}       { return new Symbol(sym.PUB, yyline, yycolumn,"publico");}
<YYINITIAL> {PRI}       { return new Symbol(sym.PRI, yyline, yycolumn,"privado");}
<YYINITIAL> {VOI}       { return new Symbol(sym.VOI, yyline, yycolumn,yytext());}
<YYINITIAL> {PRINT}     { return new Symbol(sym.PRINT, yyline, yycolumn,yytext());}


<YYINITIAL> {PAR_IZQ}     {return new Symbol(sym.PAR_IZQ, yyline, yycolumn,yytext());}
<YYINITIAL> {PAR_DER}     {return new Symbol(sym.PAR_DER, yyline, yycolumn,yytext());}
<YYINITIAL> {LLAV_IZQ}    {return new Symbol(sym.LLAV_IZQ, yyline, yycolumn,yytext());}
<YYINITIAL> {LLAV_DER}    {return new Symbol(sym.LLAV_DER, yyline, yycolumn,yytext());}
<YYINITIAL> {COMA}      {return new Symbol(sym.COMA, yyline, yycolumn,yytext());}
<YYINITIAL> {PTCOMA}    {return new Symbol(sym.PTCOMA, yyline, yycolumn,yytext());}
<YYINITIAL> {IGUAL}    {return new Symbol(sym.IGUAL, yyline, yycolumn,yytext());}
<YYINITIAL> {DOSPT}    {return new Symbol(sym.DOSPT, yyline, yycolumn,yytext());}

<YYINITIAL> {IGUALACION}    {return new Symbol(sym.IGUALACION, yyline, yycolumn,yytext());}
<YYINITIAL> {DIFERENCIA}    {return new Symbol(sym.DIFERENCIA, yyline, yycolumn,yytext());}
<YYINITIAL> {MENOR_Q}    {return new Symbol(sym.MENOR_Q, yyline, yycolumn,yytext());}
<YYINITIAL> {MAYOR_Q}    {return new Symbol(sym.MAYOR_Q, yyline, yycolumn,yytext());}
<YYINITIAL> {MENOR_IGUAL}    {return new Symbol(sym.MENOR_IGUAL, yyline, yycolumn,yytext());}
<YYINITIAL> {MAYOR_IGUAL}    {return new Symbol(sym.MAYOR_IGUAL, yyline, yycolumn,yytext());}

<YYINITIAL> {AND}    {return new Symbol(sym.AND, yyline, yycolumn,yytext());}
<YYINITIAL> {OR}    {return new Symbol(sym.OR, yyline, yycolumn,yytext());}
<YYINITIAL> {NOT}    {return new Symbol(sym.NOT, yyline, yycolumn,yytext());}

<YYINITIAL> {MAS}    {return new Symbol(sym.MAS, yyline, yycolumn,yytext());}
<YYINITIAL> {MENOS}    {return new Symbol(sym.MENOS, yyline, yycolumn,yytext());}
<YYINITIAL> {POR}    {return new Symbol(sym.POR, yyline, yycolumn,yytext());}
<YYINITIAL> {DIVISION}    {return new Symbol(sym.DIVISION, yyline, yycolumn,yytext());}
<YYINITIAL> {POTENCIA}    {return new Symbol(sym.POTENCIA, yyline, yycolumn,yytext());}
//<YYINITIAL> {UNARIO}    {return new Symbol(sym.UNARIO, yyline, yycolumn,yytext());}
<YYINITIAL> {MODULO}    {return new Symbol(sym.MODULO, yyline, yycolumn,yytext());}

<YYINITIAL> {ENTERO}    { return new Symbol(sym.ENTERO, yyline, yycolumn,yytext());}
<YYINITIAL> {DECIMAL}    { return new Symbol(sym.DECIMAL, yyline, yycolumn,yytext());}
<YYINITIAL> {ID}        {return new Symbol(sym.ID, yyline, yycolumn,yytext());}
<YYINITIAL> {CADENA}    {return new Symbol(sym.CADENA, yyline, yycolumn,yytext());}
<YYINITIAL> {CADENA_SIMP}    {return new Symbol(sym.CADENA_SIMP, yyline, yycolumn,yytext());}
<YYINITIAL> {COMENTARIO_LINEA}    {System.out.println("Este es un comentario:"+yytext());} 
<YYINITIAL> {COMENTARIO_MULINEA}    {System.out.println("Este es un comentario:"+yytext());} 

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
