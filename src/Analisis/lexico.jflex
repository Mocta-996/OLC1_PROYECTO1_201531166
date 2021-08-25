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

//palabras reservadas

INT1     = "int"
CHAR1    = "char"
PUB      = "public"
PRI      = "private"
VOI      = "void"
PRINT    = "print"

//expresiones

ENTERO  = [0-9]+   
ID      = [A-Za-zñÑ][_0-9A-Za-zñÑ]*
CADENA  = (\"([^\"\n]|(\\\"))*\")+
CADENA_SIMP  = (\'([^\"\n]|(\\\"))*\')+
COMENTARIO_LINEA =("##".*\r\n)|("//".*\n)|("//".*\r)
COMENTARIO_MULINEA ="#*""/"*([^*/]|[^*]"/"|"*"[^/])*"*"*"*#"

SPACE   = [\ \r\t\f\t]
ENTER   = [\ \n]

%%

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


<YYINITIAL> {ENTERO}    { return new Symbol(sym.ENTERO, yyline, yycolumn,yytext());}
<YYINITIAL> {ID}        {return new Symbol(sym.ID, yyline, yycolumn,yytext());}
<YYINITIAL> {CADENA}    {return new Symbol(sym.CADENA, yyline, yycolumn,yytext());}
<YYINITIAL> {CADENA_SIMP}    {return new Symbol(sym.CADENA_SIMP, yyline, yycolumn,yytext());}
<YYINITIAL> {COMENTARIO_LINEA}    {System.out.println("Este es un comentario:"+yytext());} 
<YYINITIAL> {COMENTARIO_MULINEA}    {System.out.println("Este es un comentario:"+yytext());} 


<YYINITIAL> [\"]        { yybegin(CADENA); cadena+="\""; }
<YYINITIAL> {SPACE}     { /*Espacios en blanco, ignorados*/ }
<YYINITIAL> {ENTER}     { /*Saltos de linea, ignorados*/}


<YYINITIAL> . {
        String errLex = "Error léxico : '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+(yycolumn+1);
        System.out.println(errLex);
}

<CADENA> {
        [\"] { String tmp=cadena+"\""; cadena=""; yybegin(YYINITIAL);  return new Symbol(sym.CADENA, yychar,yyline,tmp); }
        [\n] {String tmp=cadena; cadena="";  
                System.out.println("Se esperaba cierre de cadena (\")."); 
                yybegin(YYINITIAL);
            }
        [^\"] { cadena+=yytext();}
}
