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

@lexer::members 
{
    List<RecognitionException> exceptions = new ArrayList<RecognitionException>();

    public List<RecognitionException> getExceptions() 
    {
        return exceptions;
    }

    @Override
    public void reportError(RecognitionException e) 
    {
        super.reportError(e);
        exceptions.add(e);
    }
}


@members {
    /** Store arguments ?  */
    List argList = new ArrayList();

    public static void main(String[] args) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        // input = new ANTLRFileStream(args[0]));
        ResourceLexer lexer = new ResourceLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        ResourceParser parser = new ResourceParser(tokens);

        try {
            parser.prog();
            if (lexer.getExceptions().size() > 0)
            {
               System.out.println("There were exceptions.  Check output.");
            }
        } catch (RecognitionException e)  {
            e.printStackTrace();
        }
    }
}


prog:   instance* ;
                
instance
    :   '(' c=command name=classname  l=line ')'    
                         {System.out.println("command-is " + $c.value + 
                                             " classname=[" + $name.value + "]");
                          System.out.println("list.size=" + $l.row.size());
                          System.out.println(l); 
                         }
    ;

command returns [String value]
    :  c=COMMAND  {$value = $c.getText();}
    ;
 
 classname returns [String value]
    : '"' c=CLASSNAME '"'    {$value = $c.getText();}
    ;
    
 argslist returns [Object value]
    : 
    ;
    
    

Number
  :  ('0'..'9')+
  ;
  
line returns [List<Integer> row]
@init {
  $row = new ArrayList<Integer>();
}
  :  ( a=Number {$row.add(Integer.parseInt($a.text));} )+ 
  ;
    
    
    
COMMAND returns [String value]
    :  c='new'    {$value = $c.getText();} 
    ;
    


SPACE
  :  (' ' | '\t') {$channel = HIDDEN;}
  ;
  
/* WS         :   (' '|'\t')+     {skip();} ; */

NEWLINE
  :  '\r'? '\n'
  |  '\r'
  ;
  
CLASSNAME  
     : IDENTIFIER ('.' IDENTIFIER)+
     ;
     
IDENTIFIER
     : ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9')+ 
     ;

/*
ID         :   ('a'..'z'|'A'..'Z')+ ;
*/


