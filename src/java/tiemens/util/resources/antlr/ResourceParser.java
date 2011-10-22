// $ANTLR 3.4 Resource.g 2011-10-21 21:03:10
  
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CLASSNAME", "COMMAND", "ID", "INT", "NEWLINE", "WS", "'\"'", "'('", "')'"
    };

    public static final int EOF=-1;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int CLASSNAME=4;
    public static final int COMMAND=5;
    public static final int ID=6;
    public static final int INT=7;
    public static final int NEWLINE=8;
    public static final int WS=9;

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
            ResourceLexer lex = new ResourceLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lex);

            ResourceParser parser = new ResourceParser(tokens);

            try {
                parser.prog();
            } catch (RecognitionException e)  {
                e.printStackTrace();
            }
        }



    // $ANTLR start "prog"
    // Resource.g:37:1: prog : ( instance )+ EOF ;
    public final void prog() throws RecognitionException {
        try {
            // Resource.g:37:5: ( ( instance )+ EOF )
            // Resource.g:37:9: ( instance )+ EOF
            {
            // Resource.g:37:9: ( instance )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==NEWLINE||LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Resource.g:37:9: instance
            	    {
            	    pushFollow(FOLLOW_instance_in_prog38);
            	    instance();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            match(input,EOF,FOLLOW_EOF_in_prog41); 

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
    // Resource.g:39:1: instance : ( '(' c= command n= classname ')' | NEWLINE );
    public final void instance() throws RecognitionException {
        String c =null;

        String n =null;


        try {
            // Resource.g:40:5: ( '(' c= command n= classname ')' | NEWLINE )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==NEWLINE) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // Resource.g:40:9: '(' c= command n= classname ')'
                    {
                    match(input,11,FOLLOW_11_in_instance71); 

                    pushFollow(FOLLOW_command_in_instance75);
                    c=command();

                    state._fsp--;


                    pushFollow(FOLLOW_classname_in_instance79);
                    n=classname();

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_instance81); 

                    System.out.println("command-is " + c + " classname=[" + n + "]");

                    }
                    break;
                case 2 :
                    // Resource.g:41:9: NEWLINE
                    {
                    match(input,NEWLINE,FOLLOW_NEWLINE_in_instance97); 

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
    // $ANTLR end "instance"



    // $ANTLR start "command"
    // Resource.g:44:1: command returns [String value] : c= COMMAND ;
    public final String command() throws RecognitionException {
        String value = null;


        Token c=null;

        try {
            // Resource.g:45:5: (c= COMMAND )
            // Resource.g:45:8: c= COMMAND
            {
            c=(Token)match(input,COMMAND,FOLLOW_COMMAND_in_command121); 

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
    // Resource.g:48:2: classname returns [String value] : '\"' c= CLASSNAME '\"' ;
    public final String classname() throws RecognitionException {
        String value = null;


        Token c=null;

        try {
            // Resource.g:49:5: ( '\"' c= CLASSNAME '\"' )
            // Resource.g:49:7: '\"' c= CLASSNAME '\"'
            {
            match(input,10,FOLLOW_10_in_classname147); 

            c=(Token)match(input,CLASSNAME,FOLLOW_CLASSNAME_in_classname151); 

            match(input,10,FOLLOW_10_in_classname153); 

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


 

    public static final BitSet FOLLOW_instance_in_prog38 = new BitSet(new long[]{0x0000000000000900L});
    public static final BitSet FOLLOW_EOF_in_prog41 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_instance71 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_command_in_instance75 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_classname_in_instance79 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_instance81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_instance97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMAND_in_command121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_classname147 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_CLASSNAME_in_classname151 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_classname153 = new BitSet(new long[]{0x0000000000000002L});

}