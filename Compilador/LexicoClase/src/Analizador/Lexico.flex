package Analizador;
import static Analizador.Tokens.*;
%%
%class Lexico
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r]+
%{
    public String lexemas;
%}
%%
(int) {lexemas=yytext(); return Int;}
/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}

/* Salto de linea */
( "\n" ) {return Linea;}

/* Comillas */
( "\"" ) {lexemas=yytext(); return Comillas;}

/* Tipos de datos */
( byte | int | char | long | float | double | boolean | short ) {lexemas=yytext(); return T_dato;}

/* Tipo de dato String */
( String ) {lexemas=yytext(); return Cadena;}

/* Palabra reservada If */
( if ) {lexemas=yytext(); return If;}


/* Palabra reservada Else */
( else ) {lexemas=yytext(); return Else;}

/* Palabra reservada Abstract */
( abstract ) {lexemas=yytext(); return Abstract;}

/* Palabra reservada As */
( as ) {lexemas=yytext(); return As;}

/* Palabra reservada Base */
( base ) {lexemas=yytext(); return Base;}

/* Palabra reservada Catch */
( catch ) {lexemas=yytext(); return Catch;}

/* Palabra reservada Checked */
( checked ) {lexemas=yytext(); return Checked;}

/* Palabra reservada Class */
( class ) {lexemas=yytext(); return Class;}

/* Palabra reservada Const */
( const ) {lexemas=yytext(); return Const;}

/* Palabra reservada Decimal */
( decimal ) {lexemas=yytext(); return Decimal;}

/* Palabra reservada Decimal */
( decimal ) {lexemas=yytext(); return Decimal;}

/* Palabra reservada Delegate */
( delegate ) {lexemas=yytext(); return Delegate;}

/* Palabra reservada Enum */
( enum ) {lexemas=yytext(); return Enum;}

/* Palabra reservada Event */
( event ) {lexemas=yytext(); return Event;}

/* Palabra reservada Explicit */
( explicit ) {lexemas=yytext(); return Explicit;}

/* Palabra reservada Extern */
( extern ) {lexemas=yytext(); return Extern;}

/* Palabra reservada Finally */
( finally ) {lexemas=yytext(); return Finally;}


/* Palabra reservada  Bool*/
( bool ) {lexemas=yytext(); return Bool;}

/* Palabra reservada  False*/
( false ) {lexemas=yytext(); return False;}

/* Palabra reservada  True*/
( true ) {lexemas=yytext(); return True;}

/* Palabra reservada  Fixed*/
( fixed ) {lexemas=yytext(); return Fixed;}

/* Palabra reservada  Foreach*/
( foreach ) {lexemas=yytext(); return Foreach;}

/* Palabra reservada  Goto*/
( goto ) {lexemas=yytext(); return Goto;}

/* Palabra reservada  Implicit*/
( implicit ) {lexemas=yytext(); return Implicit;}

/* Palabra reservada  In*/
( in ) {lexemas=yytext(); return In;}

/* Palabra reservada  Interface*/
( interface ) {lexemas=yytext(); return Interface;}

/* Palabra reservada  Internal*/
( internal ) {lexemas=yytext(); return Internal;}

/* Palabra reservada  Is*/
( is ) {lexemas=yytext(); return Is;}

/* Palabra reservada  Lock*/
( lock ) {lexemas=yytext(); return Lock;}

/* Palabra reservada  Namespace*/
( namespace ) {lexemas=yytext(); return Namespace;}

/* Palabra reservada  New*/
( new ) {lexemas=yytext(); return New;}

/* Palabra reservada  Null*/
( null ) {lexemas=yytext(); return Null;}

/* Palabra reservada  Object*/
( object ) {lexemas=yytext(); return Object;}

/* Palabra reservada  Operator*/
( operator ) {lexemas=yytext(); return Operator;}

/* Palabra reservada  Out*/
( out ) {lexemas=yytext(); return Out;}

/* Palabra reservada  Override*/
( override ) {lexemas=yytext(); return Override;}

/* Palabra reservada  Params*/
( params ) {lexemas=yytext(); return Params;}

/* Palabra reservada  Private*/
( private ) {lexemas=yytext(); return Private;}

/* Palabra reservada  Protected*/
( protected ) {lexemas=yytext(); return Protected;}

/* Palabra reservada  Public*/
( public ) {lexemas=yytext(); return Public;}

/* Palabra reservada  Readonly*/
( readonly ) {lexemas=yytext(); return Readonly;}

/* Palabra reservada  Ref*/
( ref ) {lexemas=yytext(); return Ref;}

/* Palabra reservada  Return*/
( return ) {lexemas=yytext(); return Return;}

/* Palabra reservada  Sbyte*/
( sbyte ) {lexemas=yytext(); return Sbyte;}

/* Palabra reservada  Sealed*/
( sealed ) {lexemas=yytext(); return Sealed;}

/* Palabra reservada  Sizeof*/
( sizeof ) {lexemas=yytext(); return Sizeof;}

/* Palabra reservada  Stackalloc*/
( stackalloc ) {lexemas=yytext(); return Stackalloc;}

/* Palabra reservada  Statict*/
( statict ) {lexemas=yytext(); return Statict;}

/* Palabra reservada  Struct*/
( struct ) {lexemas=yytext(); return Struct;}

/* Palabra reservada  This*/
( this ) {lexemas=yytext(); return This;}

/* Palabra reservada  Throw*/
( throw ) {lexemas=yytext(); return Throw;}

/* Palabra reservada  Try*/
( try ) {lexemas=yytext(); return Try;}

/* Palabra reservada  Typeof*/
( typeof ) {lexemas=yytext(); return Typeof;}

/* Palabra reservada  Uint*/
( uint ) {lexemas=yytext(); return Uint;}

/* Palabra reservada  Ulong*/
( ulong ) {lexemas=yytext(); return Ulong;}

/* Palabra reservada  Unchecked*/
( unchecked ) {lexemas=yytext(); return Unchecked;}

/* Palabra reservada  Unsafe*/
( unsafe ) {lexemas=yytext(); return Unsafe;}

/* Palabra reservada  Ushort*/
( ushort ) {lexemas=yytext(); return Ushort;}

/* Palabra reservada  Using*/
( using ) {lexemas=yytext(); return Using;}

/* Palabra reservada  Virtual*/
( virtual ) {lexemas=yytext(); return Virtual;}

/* Palabra reservada  Volatile*/
( volatile ) {lexemas=yytext(); return Volatile;}

/* Palabra reservada  Void*/
( void ) {lexemas=yytext(); return Void;}



/* Palabra reservada Switch */
( switch ) {lexemas=yytext(); return Switch;}

/* Palabra reservada Case */
( case ) {lexemas=yytext(); return Case;}

/* Palabra reservada Break */
( break ) {lexemas=yytext(); return Break;}

/* Palabra reservada Continue */
( continue ) {lexemas=yytext(); return Continue;}

/* Palabra reservada Do */
( do ) {lexemas=yytext(); return Do;}

/* Palabra reservada While */
( while ) {lexemas=yytext(); return While;}

/* Palabra reservada For */
( for ) {lexemas=yytext(); return For;}

/* Operador Igual */
( "=" ) {lexemas=yytext(); return Igual;}

/* Operador Suma */
( "+" ) {lexemas=yytext(); return Suma;}

/* Operador Resta */
( "-" ) {lexemas=yytext(); return Resta;}

/* Operador Multiplicacion */
( "*" ) {lexemas=yytext(); return Multiplicacion;}

/* Operador Division */
( "/" ) {lexemas=yytext(); return Division;}


/* Operador Y_Logico */
( "&&" ) {lexemas=yytext(); return Y_Logico;}

/* Operador logico O_Logico */
( "||" ) {lexemas=yytext(); return O_Logico;}

/* Operador logico Negacion */
( "!" ) {lexemas=yytext(); return Negacion;}

/* Operador logico Y_Logico_Bit */
( "&" ) {lexemas=yytext(); return Y_Logico_Bit;}

/* Operador logico O_Logico_Bit */
( "|" ) {lexemas=yytext(); return O_Logico_Bit;}

/* Operador relacional Menor que */
( ">" ) {lexemas=yytext(); return Menor_que;}

/* Operador relacional Mayor que */
( "<" ) {lexemas=yytext(); return Mayor_que;}

/* Operador relacional Igual a */
( "==" ) {lexemas=yytext(); return Igual_a;}

/* Operador relacional Diferente de */
( "!=" ) {lexemas=yytext(); return Diferente_de;}

/* Operador relacional Mayor o igual que */
( ">=" ) {lexemas=yytext(); return Mayor_o_igual_que;}

/* Operador relacional Menor o igual que */
( "<=" ) {lexemas=yytext(); return Menor_o_igual_que;}

/* Operador de bit Desplazar a derecha */
( ">>" ) {lexemas=yytext(); return Desplazar_a_derecha;}

/* Operador de bit Desplazar a izquierda */
( "<<" ) {lexemas=yytext(); return Desplazar_a_izquierda;}

/* Operador atribucion Asignacion suma */
( "+=" ) {lexemas=yytext(); return Asignacion_suma;}

/* Operador atribucion Asignacion resta */
( "-=" ) {lexemas=yytext(); return Asignacion_resta;}

/* Operador atribucion Asignacion multiplicacion */
( "*=" ) {lexemas=yytext(); return Asignacion_multiplicacion;}

/* Operador atribucion Asignacion division */
( "/=" ) {lexemas=yytext(); return Asignacion_division;}

/* Operador atribucion Asignacion modulo */
( "%=" ) {lexemas=yytext(); return Asignacion_modulo;}

/* Operador Incremento unitario */
( "++" ) {lexemas=yytext(); return Incremento_unitario;}

/* Operador Decremento unitario */
( "--" ) {lexemas=yytext(); return Decremento_unitario;}

/* Operador Boleano true */
( true ) {lexemas=yytext(); return Boleano_true;}

/* Operador Boleano false */
( false ) {lexemas=yytext(); return Boleano_false;}

/* Parentesis de apertura */
( "(" ) {lexemas=yytext(); return Parentesis_a;}

/* Parentesis de cierre */
( ")" ) {lexemas=yytext(); return Parentesis_c;}

/* Llave de apertura */
( "{" ) {lexemas=yytext(); return Llave_a;}

/* Llave de cierre */
( "}" ) {lexemas=yytext(); return Llave_c;}

/* Corchete de apertura */
( "[" ) {lexemas = yytext(); return Corchete_a;}

/* Corchete de cierre */
( "]" ) {lexemas = yytext(); return Corchete_c;}

/* Marcador de inicio de algoritmo */
( "main" ) {lexemas=yytext(); return Main;}

/* Marcador de inicio de impresion en pantalla */
( "printf" ) {lexemas=yytext(); return Printf;}

/* Punto y coma */
( ";" ) {lexemas=yytext(); return P_coma;}

/* Punto */
( "." ) {lexemas=yytext(); return Punto;}

/* Numero */
("(-"{D}+")")|{D}+ {lexemas=yytext(); return Numero;}

/* Identificador */
{L}({L}|{D})* {lexemas=yytext(); return Identificador;}

/* Error de analisis */
 . {return ERROR;}

