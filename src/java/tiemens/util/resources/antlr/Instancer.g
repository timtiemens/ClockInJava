grammar Instancer;




@header {  
 package tiemens.util.resources.antlr; 
}
@lexer::header {
 package tiemens.util.resources.antlr; 
}


@members {
    public static void main(String[] args) 
       throws Exception 
    {
        InstancerLexer lexer = new InstancerLexer(new ANTLRFileStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        InstancerParser parser = new InstancerParser(tokens);

        try {
            parser.expr();
        } catch (RecognitionException e)  {
            e.printStackTrace();
        }
    }
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

expr
    : '(' cmd=command clz=classname ')'
    ;
    
command returns [String value] 
    : c=IDENTIFIER { $value = $c.getText(); }
    ;

classname returns [String value]
    : '"' c=CLASSNAME '"' { $value = $c.getText(); }
    ;


/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
IDENTIFIER 
   : ('A' .. 'Z' | 'a' .. 'z') ('A' .. 'Z' | 'a' .. 'z' | DIGIT )*
   ;
CLASSNAME
   : IDENTIFIER ( '.' IDENTIFIER )*
   ;
    
NUMBER  : (DIGIT)+ ;

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+    { $channel = HIDDEN; } ;

fragment DIGIT  : '0'..'9' ;
