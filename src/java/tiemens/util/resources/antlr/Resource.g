grammar Resource;


@parser::header {  
 package tiemens.util.resources.antlr;
 import java.util.HashMap; 
 import java.util.List; 
 import java.util.ArrayList; 
}
@lexer::header {
 package tiemens.util.resources.antlr; 
}



@members {
    /** Store arguments ?  */
    List argList = new ArrayList();

    public static void main(String[] args) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        // input = new ANTLRFileStream(args[0]));
        ResourceLexer lex = new ResourceLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lex);

        ResourceParser parser = new ResourceParser(tokens);

        try {
            parser.prog();
        } catch (RecognitionException e)  {
            e.printStackTrace();
        }
    }
}


prog:   instance+ EOF;
                
instance
    :   '(' c=command n=classname ')'     {System.out.println("command-is " + $c.value + " classname=[" + $n.value + "]");}
    |   NEWLINE
    ;

command returns [String value]
    :  c=COMMAND  {$value = $c.getText();}
    ;
 
 classname returns [String value]
    : '"' c=CLASSNAME '"'    {$value = $c.getText();}
    ;
    
COMMAND returns [String value]
    :  c='new'    {$value = $c.getText();} 
    ;
    

CLASSNAME  :   ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'.'|'0'..'9')+ ;

ID         :   ('a'..'z'|'A'..'Z')+ ;
INT        :   '0'..'9'+ ;
NEWLINE    :'\r'? '\n' ;
WS         :   (' '|'\t')+     {skip();} ;
