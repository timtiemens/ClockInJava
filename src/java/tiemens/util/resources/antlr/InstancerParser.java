// $ANTLR 3.4 Instancer.g 2011-10-25 13:33:17
  
 package tiemens.util.resources.antlr; 


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class InstancerParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CLASSNAME", "DIGIT", "EscapeSequence", "IDENTIFIER", "NUMBER", "STRINGLITERAL", "WHITESPACE", "'('", "')'"
    };

    public static final int EOF=-1;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int CLASSNAME=4;
    public static final int DIGIT=5;
    public static final int EscapeSequence=6;
    public static final int IDENTIFIER=7;
    public static final int NUMBER=8;
    public static final int STRINGLITERAL=9;
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



    // $ANTLR start "top"
    // Instancer.g:39:1: top returns [List<Object> toplist] : c= topInner ;
    public final List<Object> top() throws RecognitionException {
        List<Object> toplist = null;


        Object c =null;


         toplist = new java.util.ArrayList<Object>(); 
        try {
            // Instancer.g:41:5: (c= topInner )
            // Instancer.g:41:7: c= topInner
            {
            pushFollow(FOLLOW_topInner_in_top63);
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



    // $ANTLR start "topInner"
    // Instancer.g:44:1: topInner returns [Object value] : ( '(' cmd= command clz= classname (args= topInner )? ')' |c= STRINGLITERAL );
    public final Object topInner() throws RecognitionException {
        Object value = null;


        Token c=null;
        String cmd =null;

        String clz =null;

        Object args =null;


        try {
            // Instancer.g:45:5: ( '(' cmd= command clz= classname (args= topInner )? ')' |c= STRINGLITERAL )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==STRINGLITERAL) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // Instancer.g:45:7: '(' cmd= command clz= classname (args= topInner )? ')'
                    {
                    match(input,11,FOLLOW_11_in_topInner86); 

                    pushFollow(FOLLOW_command_in_topInner90);
                    cmd=command();

                    state._fsp--;


                    pushFollow(FOLLOW_classname_in_topInner94);
                    clz=classname();

                    state._fsp--;


                    // Instancer.g:45:41: (args= topInner )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==STRINGLITERAL||LA1_0==11) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // Instancer.g:45:41: args= topInner
                            {
                            pushFollow(FOLLOW_topInner_in_topInner98);
                            args=topInner();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input,12,FOLLOW_12_in_topInner101); 

                     value = InstancerCode.create(cmd, clz, args); 

                    }
                    break;
                case 2 :
                    // Instancer.g:46:7: c= STRINGLITERAL
                    {
                    c=(Token)match(input,STRINGLITERAL,FOLLOW_STRINGLITERAL_in_topInner113); 

                     value = InstancerCode.unescape(c.getText()); 

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
    // Instancer.g:49:1: command returns [String value] : c= IDENTIFIER ;
    public final String command() throws RecognitionException {
        String value = null;


        Token c=null;

        try {
            // Instancer.g:50:5: (c= IDENTIFIER )
            // Instancer.g:50:7: c= IDENTIFIER
            {
            c=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_command176); 

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
    // Instancer.g:53:1: classname returns [String value] : c= CLASSNAME ;
    public final String classname() throws RecognitionException {
        String value = null;


        Token c=null;

        try {
            // Instancer.g:54:5: (c= CLASSNAME )
            // Instancer.g:54:8: c= CLASSNAME
            {
            c=(Token)match(input,CLASSNAME,FOLLOW_CLASSNAME_in_classname202); 

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

    // Delegated rules


 

    public static final BitSet FOLLOW_topInner_in_top63 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_topInner86 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_command_in_topInner90 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_classname_in_topInner94 = new BitSet(new long[]{0x0000000000001A00L});
    public static final BitSet FOLLOW_topInner_in_topInner98 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_topInner101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGLITERAL_in_topInner113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_command176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLASSNAME_in_classname202 = new BitSet(new long[]{0x0000000000000002L});

}