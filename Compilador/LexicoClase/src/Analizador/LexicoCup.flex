package Analizador;
import java_cup.runtime.Symbol;
%%
%class LexicoCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%
(int) {return new Symbol(sym.Int, yychar, yyline, yytext());}
/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}

/* Salto de linea */

/* Comillas */
( "\"" ) {return new Symbol(sym.Comillas, yychar, yyline, yytext());}

/* Tipos de datos */
( byte | int | char | long | float | double | boolean | short ) {return new Symbol(sym.T_dato, yychar, yyline, yytext());}

/* Tipo de dato String */
( String ) {return new Symbol(sym.Cadena, yychar, yyline, yytext());}

/* Palabra reservada If */
( if ) {return new Symbol(sym.If, yychar, yyline, yytext());}


/* Palabra reservada Else */
( else ) {return new Symbol(sym.Else, yychar, yyline, yytext());}

/* Palabra reservada Abstract */
( abstract ) {return new Symbol(sym.Abstract, yychar, yyline, yytext());}

/* Palabra reservada As */
( as ) {return new Symbol(sym.As, yychar, yyline, yytext());}

/* Palabra reservada Base */
( base ) {return new Symbol(sym.Base, yychar, yyline, yytext());}

/* Palabra reservada Catch */
( catch ) {return new Symbol(sym.Catch, yychar, yyline, yytext());}

/* Palabra reservada Checked */
( checked ) {return new Symbol(sym.Checked, yychar, yyline, yytext());}

/* Palabra reservada Class */
( class ) {return new Symbol(sym.Class, yychar, yyline, yytext());}

/* Palabra reservada Const */
( const ) {return new Symbol(sym.Const, yychar, yyline, yytext());}

/* Palabra reservada Decimal */
( decimal ) {return new Symbol(sym.Decimal, yychar, yyline, yytext());}

/* Palabra reservada Decimal */
( decimal ) {return new Symbol(sym.Decimal, yychar, yyline, yytext());}

/* Palabra reservada Delegate */
( delegate ) {return new Symbol(sym.Delegate, yychar, yyline, yytext());}

/* Palabra reservada Enum */
( enum ) {return new Symbol(sym.Enum, yychar, yyline, yytext());}

/* Palabra reservada Event */
( event ) {return new Symbol(sym.Event, yychar, yyline, yytext());}

/* Palabra reservada Explicit */
( explicit ) {return new Symbol(sym.Explicit, yychar, yyline, yytext());}

/* Palabra reservada Extern */
( extern ) {return new Symbol(sym.Extern, yychar, yyline, yytext());}

/* Palabra reservada Finally */
( finally ) {return new Symbol(sym.Finally, yychar, yyline, yytext());}


/* Palabra reservada  Bool*/
( bool ) {return new Symbol(sym.Bool, yychar, yyline, yytext());}

/* Palabra reservada  False*/
( false ) {return new Symbol(sym.False, yychar, yyline, yytext());}

/* Palabra reservada  True*/
( true ) {return new Symbol(sym.True, yychar, yyline, yytext());}

/* Palabra reservada  Fixed*/
( fixed ) {return new Symbol(sym.Fixed, yychar, yyline, yytext());}

/* Palabra reservada  Foreach*/
( foreach ) {return new Symbol(sym.Foreach, yychar, yyline, yytext());}

/* Palabra reservada  Goto*/
( goto ) {return new Symbol(sym.Goto, yychar, yyline, yytext());}

/* Palabra reservada  Implicit*/
( implicit ) {return new Symbol(sym.Implicit, yychar, yyline, yytext());}

/* Palabra reservada  In*/
( in ) {return new Symbol(sym.In, yychar, yyline, yytext());}

/* Palabra reservada  Interface*/
( interface ) {return new Symbol(sym.Interface, yychar, yyline, yytext());}

/* Palabra reservada  Internal*/
( internal ) {return new Symbol(sym.Internal, yychar, yyline, yytext());}

/* Palabra reservada  Is*/
( is ) {return new Symbol(sym.Is, yychar, yyline, yytext());}

/* Palabra reservada  Lock*/
( lock ) {return new Symbol(sym.Lock, yychar, yyline, yytext());}

/* Palabra reservada  Namespace*/
( namespace ) {return new Symbol(sym.Namespace, yychar, yyline, yytext());}

/* Palabra reservada  New*/
( new ) {return new Symbol(sym.New, yychar, yyline, yytext());}

/* Palabra reservada  Null*/
( null ) {return new Symbol(sym.Null, yychar, yyline, yytext());}

/* Palabra reservada  Object*/
( object ) {return new Symbol(sym.Object, yychar, yyline, yytext());}

/* Palabra reservada  Operator*/
( operator ) {return new Symbol(sym.Operator, yychar, yyline, yytext());}

/* Palabra reservada  Out*/
( out ) {return new Symbol(sym.Out, yychar, yyline, yytext());}

/* Palabra reservada  Override*/
( override ) {return new Symbol(sym.Override, yychar, yyline, yytext());}

/* Palabra reservada  Params*/
( params ) {return new Symbol(sym.Params, yychar, yyline, yytext());}

/* Palabra reservada  Private*/
( private ) {return new Symbol(sym.Private, yychar, yyline, yytext());}

/* Palabra reservada  Protected*/
( protected ) {return new Symbol(sym.Protected, yychar, yyline, yytext());}

/* Palabra reservada  Public*/
( public ) {return new Symbol(sym.Public, yychar, yyline, yytext());}

/* Palabra reservada  Readonly*/
( readonly ) {return new Symbol(sym.Readonly, yychar, yyline, yytext());}

/* Palabra reservada  Ref*/
( ref ) {return new Symbol(sym.Ref, yychar, yyline, yytext());}

/* Palabra reservada  Return*/
( return ) {return new Symbol(sym.Return, yychar, yyline, yytext());}

/* Palabra reservada  Sbyte*/
( sbyte ) {return new Symbol(sym.Sbyte, yychar, yyline, yytext());}

/* Palabra reservada  Sealed*/
( sealed ) {return new Symbol(sym.Sealed, yychar, yyline, yytext());}

/* Palabra reservada  Sizeof*/
( sizeof ) {return new Symbol(sym.Sizeof, yychar, yyline, yytext());}

/* Palabra reservada  Stackalloc*/
( stackalloc ) {return new Symbol(sym.Stackalloc, yychar, yyline, yytext());}

/* Palabra reservada  Statict*/
( statict ) {return new Symbol(sym.Statict, yychar, yyline, yytext());}

/* Palabra reservada  Struct*/
( struct ) {return new Symbol(sym.Struct, yychar, yyline, yytext());}

/* Palabra reservada  This*/
( this ) {return new Symbol(sym.This, yychar, yyline, yytext());}

/* Palabra reservada  Throw*/
( throw ) {return new Symbol(sym.Throw, yychar, yyline, yytext());}

/* Palabra reservada  Try*/
( try ) {return new Symbol(sym.Try, yychar, yyline, yytext());}

/* Palabra reservada  Typeof*/
( typeof ) {return new Symbol(sym.Typeof, yychar, yyline, yytext());}

/* Palabra reservada  Uint*/
( uint ) {return new Symbol(sym.Uint, yychar, yyline, yytext());}

/* Palabra reservada  Ulong*/
( ulong ) {return new Symbol(sym.Ulong, yychar, yyline, yytext());}

/* Palabra reservada  Unchecked*/
( unchecked ) {return new Symbol(sym.Unchecked, yychar, yyline, yytext());}

/* Palabra reservada  Unsafe*/
( unsafe ) {return new Symbol(sym.Unsafe, yychar, yyline, yytext());}

/* Palabra reservada  Ushort*/
( ushort ) {return new Symbol(sym.Ushort, yychar, yyline, yytext());}

/* Palabra reservada  Using*/
( using ) {return new Symbol(sym.Using, yychar, yyline, yytext());}

/* Palabra reservada  Virtual*/
( virtual ) {return new Symbol(sym.Virtual, yychar, yyline, yytext());}

/* Palabra reservada  Volatile*/
( volatile ) {return new Symbol(sym.Volatile, yychar, yyline, yytext());}

/* Palabra reservada  Void*/
( void ) {return new Symbol(sym.Void, yychar, yyline, yytext());}


/* Palabra reservada Switch */
( switch ) {return new Symbol(sym.Switch, yychar, yyline, yytext());}

/* Palabra reservada Case */
( case ) {return new Symbol(sym.Case, yychar, yyline, yytext());}

/* Palabra reservada Break */
( break ) {return new Symbol(sym.Break, yychar, yyline, yytext());}

/* Palabra reservada Continue */
( continue ) {return new Symbol(sym.Continue, yychar, yyline, yytext());}

/* Palabra reservada Do */
( do ) {return new Symbol(sym.Do, yychar, yyline, yytext());}

/* Palabra reservada While */
( while ) {return new Symbol(sym.While, yychar, yyline, yytext());}

/* Palabra reservada For */
( for ) {return new Symbol(sym.For, yychar, yyline, yytext());}

/* Operador Igual */
( "=" ) {return new Symbol(sym.Igual, yychar, yyline, yytext());}

/* Operador Suma */
( "+" ) {return new Symbol(sym.Suma, yychar, yyline, yytext());}

/* Operador Resta */
( "-" ) {return new Symbol(sym.Resta, yychar, yyline, yytext());}

/* Operador Multiplicacion */
( "*" ) {return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());}

/* Operador Division */
( "/" ) {return new Symbol(sym.Division, yychar, yyline, yytext());}

/* Operador Y_Logico */
( "&&" ) {return new Symbol(sym.Y_Logico, yychar, yyline, yytext());}

/* Operador logico O_Logico */
( "||" ) {return new Symbol(sym.O_Logico, yychar, yyline, yytext());}

/* Operador logico Negacion */
( "!" ) {return new Symbol(sym.Negacion, yychar, yyline, yytext());}

/* Operador logico Y_Logico_Bit */
( "&" ) {return new Symbol(sym.Y_Logico_Bit, yychar, yyline, yytext());}

/* Operador logico O_Logico_Bit */
( "|" ) {return new Symbol(sym.O_Logico_Bit, yychar, yyline, yytext());}

/* Operador relacional Menor que */
( ">" ) {return new Symbol(sym.Menor_que, yychar, yyline, yytext());}

/* Operador relacional Mayor que */
( "<" ) {return new Symbol(sym.Mayor_que, yychar, yyline, yytext());}

/* Operador relacional Igual a */
( "==" ) {return new Symbol(sym.Igual_a, yychar, yyline, yytext());}

/* Operador relacional Diferente de */
( "!=" ) {return new Symbol(sym.Diferente_de, yychar, yyline, yytext());}

/* Operador relacional Mayor o igual que */
( ">=" ) {return new Symbol(sym.Mayor_o_igual_que, yychar, yyline, yytext());}

/* Operador relacional Menor o igual que */
( "<=" ) {return new Symbol(sym.Menor_o_igual_que, yychar, yyline, yytext());}

/* Operador de bit Desplazar a derecha */
( ">>" ) {return new Symbol(sym.Desplazar_a_derecha, yychar, yyline, yytext());}

/* Operador de bit Desplazar a izquierda */
( "<<" ) {return new Symbol(sym.Desplazar_a_izquierda, yychar, yyline, yytext());}

/* Operador atribucion Asignacion suma */
( "+=" ) {return new Symbol(sym.Asignacion_suma, yychar, yyline, yytext());}

/* Operador atribucion Asignacion resta */
( "-=" ) {return new Symbol(sym.Asignacion_resta, yychar, yyline, yytext());}

/* Operador atribucion Asignacion multiplicacion */
( "*=" ) {return new Symbol(sym.Asignacion_multiplicacion, yychar, yyline, yytext());}

/* Operador atribucion Asignacion division */
( "/=" ) {return new Symbol(sym.Asignacion_division, yychar, yyline, yytext());}

/* Operador atribucion Asignacion modulo */
( "%=" ) {return new Symbol(sym.Asignacion_modulo, yychar, yyline, yytext());}

/* Operador Incremento unitario */
( "++" ) {return new Symbol(sym.Incremento_unitario, yychar, yyline, yytext());}

/* Operador Decremento unitario */
( "--" ) {return new Symbol(sym.Decremento_unitario, yychar, yyline, yytext());}

/* Operador Boleano true */
( true ) {return new Symbol(sym.Boleano_true, yychar, yyline, yytext());}

/* Operador Boleano false */
( false ) {return new Symbol(sym.Boleano_false, yychar, yyline, yytext());}

/* Parentesis de apertura */
( "(" ) {return new Symbol(sym.Parentesis_a, yychar, yyline, yytext());}

/* Parentesis de cierre */
( ")" ) {return new Symbol(sym.Parentesis_c, yychar, yyline, yytext());}

/* Llave de apertura */
( "{" ) {return new Symbol(sym.Llave_a, yychar, yyline, yytext());}

/* Llave de cierre */
( "}" ) {return new Symbol(sym.Llave_c, yychar, yyline, yytext());}

/* Corchete de apertura */
( "[" ) {lexemas = yytext(), yychar, yyline, yytext()); return Corchete_a, yychar, yyline, yytext());}

/* Corchete de cierre */
( "]" ) {lexemas = yytext(), yychar, yyline, yytext()); return Corchete_c, yychar, yyline, yytext());}

/* Marcador de inicio de algoritmo */
( "main" ) {return new Symbol(sym.Main, yychar, yyline, yytext());}

/* Marcador de inicio de impresion en pantalla */
( "printf" ) {return new Symbol(sym.Printf, yychar, yyline, yytext());}

/* Punto y coma */
( ", yychar, yyline, yytext());" ) {return new Symbol(sym.P_coma, yychar, yyline, yytext());}

/* Punto */
( "." ) {return new Symbol(sym.Punto, yychar, yyline, yytext());}

/* Numero */
("(-"{D}+")")|{D}+ {return new Symbol(sym.Numero, yychar, yyline, yytext());}

/* Identificador */
{L}({L}|{D})* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}

/* Error de analisis */
 . {return ERROR;}

