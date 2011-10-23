// $ANTLR 3.4 Resource.g 2011-10-22 22:20:09
  
 package tiemens.util.resources.antlr;
 import java.util.HashMap; 
 import java.util.List; 
 import java.util.ArrayList; 


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class ResourceParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CLASSNAME", "COMMAND", "IDENTIFIER", "NEWLINE", "Number", "SPACE", "'\"'", "'('", "')'"
    };

    public static final int EOF=-1;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int CLASSNAME=4;
    public static final int COMMAND=5;
    public static final int IDENTIFIER=6;
    public static final int NEWLINE=7;
    public static final int Number=8;
    public static final int SPACE=9;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public ResourceParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public ResourceParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return ResourceParser.tokenNames; }
    public String getGrammarFileName() { return "Resource.g"; }


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



    // $ANTLR start "prog"
    // Resource.g:57:1: prog : ( instance )* ;
    public final void prog() throws RecognitionException {
        try {
            // Resource.g:57:5: ( ( instance )* )
            // Resource.g:57:9: ( instance )*
            {
            // Resource.g:57:9: ( instance )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Resource.g:57:9: instance
            	    {
            	    pushFollow(FOLLOW_instance_in_prog47);
            	    instance();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "prog"



    // $ANTLR start "instance"
    // Resource.g:59:1: instance : '(' c= command name= classname l= line ')' ;
    public final void instance() throws RecognitionException {
        String c =null;

        String name =null;

        List<Integer> l =null;


        try {
            // Resource.g:60:5: ( '(' c= command name= classname l= line ')' )
            // Resource.g:60:9: '(' c= command name= classname l= line ')'
            {
            match(input,11,FOLLOW_11_in_instance79); 

            pushFollow(FOLLOW_command_in_instance83);
            c=command();

            state._fsp--;


            pushFollow(FOLLOW_classname_in_instance87);
            name=classname();

            state._fsp--;


            pushFollow(FOLLOW_line_in_instance92);
            l=line();

            state._fsp--;


            match(input,12,FOLLOW_12_in_instance94); 

            System.out.println("codmmand-is " + c + 
                                                         " classname=[" + name + "]");
                                      System.out.println("list.size=" + l.size());
                                      System.out.println(l); 
                                     

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "instance"



    // $ANTLR start "command"
    // Resource.g:68:1: command returns [String value] : c= COMMAND ;
    public final String command() throws RecognitionException {
        String value = null;


        Token c=null;

        try {
            // Resource.g:69:5: (c= COMMAND )
            // Resource.g:69:8: c= COMMAND
            {
            c=(Token)match(input,COMMAND,FOLLOW_COMMAND_in_command149); 

            value = c.getText();

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "command"



    // $ANTLR start "classname"
    // Resource.g:72:2: classname returns [String value] : '\"' c= CLASSNAME '\"' ;
    public final String classname() throws RecognitionException {
        String value = null;


        Token c=null;

        try {
            // Resource.g:73:5: ( '\"' c= CLASSNAME '\"' )
            // Resource.g:73:7: '\"' c= CLASSNAME '\"'
            {
            match(input,10,FOLLOW_10_in_classname175); 

            c=(Token)match(input,CLASSNAME,FOLLOW_CLASSNAME_in_classname179); 

            match(input,10,FOLLOW_10_in_classname181); 

            value = c.getText();

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "classname"



    // $ANTLR start "argslist"
    // Resource.g:76:2: argslist returns [Object value] :;
    public final Object argslist() throws RecognitionException {
        Object value = null;


        try {
            // Resource.g:77:5: ()
            // Resource.g:78:5: 
            {
            }

        }
        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "argslist"



    // $ANTLR start "line"
    // Resource.g:86:1: line returns [List<Integer> row] : (a= Number )+ ;
    public final List<Integer> line() throws RecognitionException {
        List<Integer> row = null;


        Token a=null;


          row = new ArrayList<Integer>();

        try {
            // Resource.g:90:3: ( (a= Number )+ )
            // Resource.g:90:6: (a= Number )+
            {
            // Resource.g:90:6: (a= Number )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Number) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Resource.g:90:8: a= Number
            	    {
            	    a=(Token)match(input,Number,FOLLOW_Number_in_line271); 

            	    row.add(Integer.parseInt((a!=null?a.getText():null)));

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return row;
    }
    // $ANTLR end "line"

    // Delegated rules


 

    public static final BitSet FOLLOW_instance_in_prog47 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_11_in_instance79 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_command_in_instance83 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_classname_in_instance87 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_line_in_instance92 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_instance94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMAND_in_command149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_classname175 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_CLASSNAME_in_classname179 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_classname181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Number_in_line271 = new BitSet(new long[]{0x0000000000000102L});

}