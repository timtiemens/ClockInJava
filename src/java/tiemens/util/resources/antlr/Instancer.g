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
            List<Object> thelist = parser.top();
            System.out.println("MAIN: toplist.size() = " + thelist.size());
            Object zero = thelist.get(0);
            System.out.println("MAIN: [0]=" + zero);
            System.out.println("MAIN: class name=" + zero.getClass().getName());
        } catch (RecognitionException e)  {
            e.printStackTrace();
        }
    }
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

top returns [List<Object> toplist]
           @init { $toplist = new java.util.ArrayList<Object>(); }
    : c=topInner { toplist.add($c.value); }
    ;

topInner returns [Object value]
    : '(' cmd=command clz=classname args=topInner? ')' { $value = InstancerCode.create($cmd.value, $clz.value, $args.value); }
    | c=STRINGLITERAL                                  { $value = InstancerCode.unescape(c.getText()); }
    ;
    
command returns [String value] 
    : c=IDENTIFIER { $value = $c.getText(); }
    ;

classname returns [String value]
    :  c=CLASSNAME  { $value = $c.getText(); }
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


STRINGLITERAL
    :   '"' 
        (   EscapeSequence
        |   ~( '\\' | '"' | '\r' | '\n' )        
        )* 
        '"'    { setText( getText().substring(1, getText().length() - 1)); }
    ;

fragment
EscapeSequence 
    :   '\\' (
                 'b' 
             |   't' 
             |   'n' 
             |   'f' 
             |   'r' 
             |   '\"' 
             |   '\'' 
             |   '\\' 
             |       
                 ('0'..'3') ('0'..'7') ('0'..'7')
             |       
                 ('0'..'7') ('0'..'7') 
             |       
                 ('0'..'7')
             )          
;     



/*
STRING
   : '"' ( options {greedy=false;}:  ~'"' )*  '"';   */
   /*   : '"' ( options {greedy=false;}:  ~'"'  | '""')*  '"' */
/*
   : ('A' .. 'Z' | 'a' .. 'z') ('A' .. 'Z' | 'a' .. 'z' | DIGIT | '!' .. ')' )*
   */
   


WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+    { $channel = HIDDEN; } ;

fragment DIGIT  : '0'..'9' ;
