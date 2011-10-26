grammar Instancer;




@header {  
 package tiemens.util.resources.antlr; 
}
@lexer::header {
 package tiemens.util.resources.antlr; 
}


@members {
    private InstancerCode instancerCode = new InstancerCode();
    
    public static void main(String[] args) 
       throws Exception 
    {
        InstancerLexer lexer = new InstancerLexer(new ANTLRFileStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        InstancerParser parser = new InstancerParser(tokens);

        try 
        {
            List<Object> thelist = parser.top();
            
            System.out.println("MAIN: toplist.size() = " + thelist.size());
            Object zero = thelist.get(0);
            System.out.println("MAIN: [0]=" + zero);
            System.out.println("MAIN: class name=" + zero.getClass().getName());
        } 
        catch (RecognitionException e)  
        {
            e.printStackTrace();
        }
    }
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

top returns [List<Object> toplist]
           @init { $toplist = new java.util.ArrayList<Object>(); }
    : initStatements? c=topInner { toplist.add($c.value); }
    ;
    
initStatements
    : '{' (initStatementChoice ';')* '}'
    ;

initStatementChoice
    : 'import'  clz=classname    { instancerCode.addImport($clz.value); }
    | 'logging' c=QUOTEDLITERAL  { instancerCode.configureLogging( 
                                        instancerCode.unescape($c.getText())); }
    ;  
   
topInner returns [Object value]
    : '(' cmd=command clz=classname args=topInner? ')' { $value = instancerCode.create($cmd.value, $clz.value, $args.value); }
    | c=QUOTEDLITERAL                                  { $value = instancerCode.unescape(c.getText()); }
    ;
    
command returns [String value] 
    : c=IDENTIFIER { $value = $c.getText(); }
    ;

classname returns [String value]
    :  c=CLASSNAME  { $value = $c.getText(); } 
    |  c=IDENTIFIER { $value = $c.getText(); }   /* see NOTE-3 */
    ;

       

/*------------------------------------------------------------------
 * LEXER RULES  [see Note-1]
 *------------------------------------------------------------------*/
   
IDENTIFIER 
   : ('A' .. 'Z' | 'a' .. 'z') ('A' .. 'Z' | 'a' .. 'z' | DIGIT )*
   ;
   
CLASSNAME
   : IDENTIFIER ( '.' IDENTIFIER )*
   ;
    
NUMBER  : (DIGIT)+ ;


QUOTEDLITERAL
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
             |   ('0'..'3') ('0'..'7') ('0'..'7')
             |   ('0'..'7') ('0'..'7') 
             |   ('0'..'7')
             )          
    ;     

           
 
/*    [See Note-2]
STRING
   : '"' ( options {greedy=false;}:  ~'"' )*  '"';   */
   /*   : '"' ( options {greedy=false;}:  ~'"'  | '""')*  '"' */
/*
   : ('A' .. 'Z' | 'a' .. 'z') ('A' .. 'Z' | 'a' .. 'z' | DIGIT | '!' .. ')' )*
   */
   


WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+    { $channel = HIDDEN; } ;

fragment DIGIT  : '0'..'9' ;


/* Reference URLs
     http://jnb.ociweb.com/jnb/jnbJun2008.html
     http://www.antlr.org/wiki/display/ANTLR3/Lexer+grammar+for+floating+point,+dot,+range,+time+specs 
 */
/* Note-1: IfItStartsWithUpper - it is a lexer rule
           ifItStartsWithLower - it is a parser rule
 */
/* Note-2: It turns out even if a rule isn't ''used'' it is still
           part of the global lexer space.
           So, having extra stuff is a bad idea..
 */
 /* Note-3 - 
    started with just c=CLASSNAME. 
    then, when I tried input of << (new Date "12345") >>
       I got an error:     
          in.txt line 3:5 mismatched input 'Date' expecting CLASSNAME
    The tokens CLASSNAME and IDENTIFIER collide, so, of course,
       adding c=IDENTIFIER makes the error go away.
    Then, the "bare" Date matches IDENTIFIER.
 */
