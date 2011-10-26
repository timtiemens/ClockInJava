// $ANTLR 3.4 Instancer.g 2011-10-25 22:30:18
  
 package tiemens.util.resources.antlr; 


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class InstancerParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CLASSNAME", "DIGIT", "EscapeSequence", "IDENTIFIER", "NUMBER", "QUOTEDLITERAL", "WHITESPACE", "'('", "')'", "';'", "'import'", "'logging'", "'{'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int CLASSNAME=4;
    public static final int DIGIT=5;
    public static final int EscapeSequence=6;
    public static final int IDENTIFIER=7;
    public static final int NUMBER=8;
    public static final int QUOTEDLITERAL=9;
    public static final int WHITESPACE=10;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public InstancerParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public InstancerParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return InstancerParser.tokenNames; }
    public String getGrammarFileName() { return "Instancer.g"; }


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



    // $ANTLR start "top"
    // Instancer.g:45:1: top returns [List<Object> toplist] : ( initStatements )? c= topInner ;
    public final List<Object> top() throws RecognitionException {
        List<Object> toplist = null;


        Object c =null;


         toplist = new java.util.ArrayList<Object>(); 
        try {
            // Instancer.g:47:5: ( ( initStatements )? c= topInner )
            // Instancer.g:47:7: ( initStatements )? c= topInner
            {
            // Instancer.g:47:7: ( initStatements )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==16) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // Instancer.g:47:7: initStatements
                    {
                    pushFollow(FOLLOW_initStatements_in_top61);
                    initStatements();

                    state._fsp--;


                    }
                    break;

            }


            pushFollow(FOLLOW_topInner_in_top66);
            c=topInner();

            state._fsp--;


             toplist.add(c); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return toplist;
    }
    // $ANTLR end "top"



    // $ANTLR start "initStatements"
    // Instancer.g:50:1: initStatements : '{' ( initStatementChoice ';' )* '}' ;
    public final void initStatements() throws RecognitionException {
        try {
            // Instancer.g:51:5: ( '{' ( initStatementChoice ';' )* '}' )
            // Instancer.g:51:7: '{' ( initStatementChoice ';' )* '}'
            {
            match(input,16,FOLLOW_16_in_initStatements89); 

            // Instancer.g:51:11: ( initStatementChoice ';' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= 14 && LA2_0 <= 15)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Instancer.g:51:12: initStatementChoice ';'
            	    {
            	    pushFollow(FOLLOW_initStatementChoice_in_initStatements92);
            	    initStatementChoice();

            	    state._fsp--;


            	    match(input,13,FOLLOW_13_in_initStatements94); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            match(input,17,FOLLOW_17_in_initStatements98); 

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
    // $ANTLR end "initStatements"



    // $ANTLR start "initStatementChoice"
    // Instancer.g:54:1: initStatementChoice : ( 'import' clz= classname | 'logging' c= QUOTEDLITERAL );
    public final void initStatementChoice() throws RecognitionException {
        Token c=null;
        String clz =null;


        try {
            // Instancer.g:55:5: ( 'import' clz= classname | 'logging' c= QUOTEDLITERAL )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            else if ( (LA3_0==15) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // Instancer.g:55:7: 'import' clz= classname
                    {
                    match(input,14,FOLLOW_14_in_initStatementChoice115); 

                    pushFollow(FOLLOW_classname_in_initStatementChoice120);
                    clz=classname();

                    state._fsp--;


                     instancerCode.addImport(clz); 

                    }
                    break;
                case 2 :
                    // Instancer.g:56:7: 'logging' c= QUOTEDLITERAL
                    {
                    match(input,15,FOLLOW_15_in_initStatementChoice133); 

                    c=(Token)match(input,QUOTEDLITERAL,FOLLOW_QUOTEDLITERAL_in_initStatementChoice137); 

                     instancerCode.configureLogging( 
                                                            instancerCode.unescape(c.getText())); 

                    }
                    break;

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
    // $ANTLR end "initStatementChoice"



    // $ANTLR start "topInner"
    // Instancer.g:60:1: topInner returns [Object value] : ( '(' cmd= command clz= classname (args= topInner )? ')' |c= QUOTEDLITERAL );
    public final Object topInner() throws RecognitionException {
        Object value = null;


        Token c=null;
        String cmd =null;

        String clz =null;

        Object args =null;


        try {
            // Instancer.g:61:5: ( '(' cmd= command clz= classname (args= topInner )? ')' |c= QUOTEDLITERAL )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==11) ) {
                alt5=1;
            }
            else if ( (LA5_0==QUOTEDLITERAL) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // Instancer.g:61:7: '(' cmd= command clz= classname (args= topInner )? ')'
                    {
                    match(input,11,FOLLOW_11_in_topInner166); 

                    pushFollow(FOLLOW_command_in_topInner170);
                    cmd=command();

                    state._fsp--;


                    pushFollow(FOLLOW_classname_in_topInner174);
                    clz=classname();

                    state._fsp--;


                    // Instancer.g:61:41: (args= topInner )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==QUOTEDLITERAL||LA4_0==11) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // Instancer.g:61:41: args= topInner
                            {
                            pushFollow(FOLLOW_topInner_in_topInner178);
                            args=topInner();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input,12,FOLLOW_12_in_topInner181); 

                     value = instancerCode.create(cmd, clz, args); 

                    }
                    break;
                case 2 :
                    // Instancer.g:62:7: c= QUOTEDLITERAL
                    {
                    c=(Token)match(input,QUOTEDLITERAL,FOLLOW_QUOTEDLITERAL_in_topInner193); 

                     value = instancerCode.unescape(c.getText()); 

                    }
                    break;

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
    // $ANTLR end "topInner"



    // $ANTLR start "command"
    // Instancer.g:65:1: command returns [String value] : c= IDENTIFIER ;
    public final String command() throws RecognitionException {
        String value = null;


        Token c=null;

        try {
            // Instancer.g:66:5: (c= IDENTIFIER )
            // Instancer.g:66:7: c= IDENTIFIER
            {
            c=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_command256); 

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
    // Instancer.g:69:1: classname returns [String value] : (c= CLASSNAME |c= IDENTIFIER );
    public final String classname() throws RecognitionException {
        String value = null;


        Token c=null;

        try {
            // Instancer.g:70:5: (c= CLASSNAME |c= IDENTIFIER )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==CLASSNAME) ) {
                alt6=1;
            }
            else if ( (LA6_0==IDENTIFIER) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // Instancer.g:70:8: c= CLASSNAME
                    {
                    c=(Token)match(input,CLASSNAME,FOLLOW_CLASSNAME_in_classname282); 

                     value = c.getText(); 

                    }
                    break;
                case 2 :
                    // Instancer.g:71:8: c= IDENTIFIER
                    {
                    c=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_classname297); 

                     value = c.getText(); 

                    }
                    break;

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

    // Delegated rules


 

    public static final BitSet FOLLOW_initStatements_in_top61 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_topInner_in_top66 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_initStatements89 = new BitSet(new long[]{0x000000000002C000L});
    public static final BitSet FOLLOW_initStatementChoice_in_initStatements92 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_initStatements94 = new BitSet(new long[]{0x000000000002C000L});
    public static final BitSet FOLLOW_17_in_initStatements98 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_initStatementChoice115 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_classname_in_initStatementChoice120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_initStatementChoice133 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTEDLITERAL_in_initStatementChoice137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_topInner166 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_command_in_topInner170 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_classname_in_topInner174 = new BitSet(new long[]{0x0000000000001A00L});
    public static final BitSet FOLLOW_topInner_in_topInner178 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_topInner181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTEDLITERAL_in_topInner193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_command256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLASSNAME_in_classname282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_classname297 = new BitSet(new long[]{0x0000000000000002L});

}