package proyectojflex; //Se trabajara sobre el paquete proyectojflex.
import java_cup.runtime.*; //importación para que nuestro archivo pueda ser ejecutado.
%% // Comenzar el bloque de configuración del analizador.
%class Convertir // Se creará na clase con ese nombre.
%line //Acceder a la linea donde se encuentra el token en el cup.
%column //Acceder a la columna donde se encuentra el token en el cup.
%cup //Para tener compatibilidad con en archivo cup
%{ // Inicio de codijo java
/*Se crea un objeto de la clase Symbol 
  que nos presenta la información del token*/
  private Symbol symbol(int type){
    return new Symbol(type,yyline,yycolumn);
  }

/*Se crea un objeto de la clase Symbol que nos presenta
   la información del token con el valor actual*/
private Symbol symbol(int type, Object value){
    return new Symbol(type,yyline,yycolumn,value);
  }
%} //fin de codigo java

/*Rglas Léxicas*/
ALFA= [a-z] //Expresion definida para que acepte letras a-z minusculas.
%% //para espeficicar otro bloque
{ALFA} {return symbol((sym.ALFA),yytext());} //Busca el token ALFA y devuelve su valor.
"+" {return symbol((sym.SUMA),yytext());} //Busca el token SUMA y devuelve su valor.
">" {return symbol((sym.CONVERTIR),yytext());} //Busca el token CONVVERTIR y devuelve su valor.
. {System.out.println("error lexico");} //Presenta el error si no se ha encontrado el token.