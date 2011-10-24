// $ANTLR 3.4 Instancer.g 2011-10-24 17:44:00
  
 package tiemens.util.resources.antlr; 


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class InstancerParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CLASSNAME", "DIGIT", "IDENTIFIER", "NUMBER", "WHITESPACE", "'\"'", "'('", "')'"
    };

    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int CLASSNAME=4;
    public static final int DIGIT=5;
    public static final int IDENTIFIER=6;
    public static final int NUMBER=7;
    public static final int WHITESPACE=8;

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
                parser.expr();
            } catch (RecognitionException e)  {
                e.printStackTrace();
            }
        }



    // $ANTLR start "expr"
    // Instancer.g:35:1: expr : '(' cmd= command clz= classname ')' ;
    public final void expr() throws RecognitionException {
        String cmd =null;

        String clz =null;


        try {
            // Instancer.g:36:5: ( '(' cmd= command clz= classname ')' )
            // Instancer.g:36:7: '(' cmd= command clz= classname ')'
            {
            match(input,10,FOLLOW_10_in_expr41); 

            pushFollow(FOLLOW_command_in_expr45);
            cmd=command();

            state._fsp--;


            pushFollow(FOLLOW_classname_in_expr49);
            clz=classname();

            state._fsp--;


            match(input,11,FOLLOW_11_in_expr51); 

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
    // $ANTLR end "expr"



    // $ANTLR start "command"
    // Instancer.g:39:1: command returns [String value] : c= IDENTIFIER ;
    public final String command() throws RecognitionException {
        String value = null;


        Token c=null;

        try {
            // Instancer.g:40:5: (c= IDENTIFIER )
            // Instancer.g:40:7: c= IDENTIFIER
            {
            c=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_command79); 

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
    // Instancer.g:43:1: classname returns [String value] : '\"' c= CLASSNAME '\"' ;
    public final String classname() throws RecognitionException {
        String value = null;


        Token c=null;

        try {
            // Instancer.g:44:5: ( '\"' c= CLASSNAME '\"' )
            // Instancer.g:44:7: '\"' c= CLASSNAME '\"'
            {
            match(input,9,FOLLOW_9_in_classname102); 

            c=(Token)match(input,CLASSNAME,FOLLOW_CLASSNAME_in_classname106); 

            match(input,9,FOLLOW_9_in_classname108); 

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


 

    public static final BitSet FOLLOW_10_in_expr41 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_command_in_expr45 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_classname_in_expr49 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_expr51 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_command79 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_classname102 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_CLASSNAME_in_classname106 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_classname108 = new BitSet(new long[]{0x0000000000000002L});

}