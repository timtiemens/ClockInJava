// $ANTLR 3.4 Resource.g 2011-10-21 21:03:10

 package tiemens.util.resources.antlr; 


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class ResourceLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public ResourceLexer() {} 
    public ResourceLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ResourceLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Resource.g"; }

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Resource.g:6:7: ( '\"' )
            // Resource.g:6:9: '\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Resource.g:7:7: ( '(' )
            // Resource.g:7:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Resource.g:8:7: ( ')' )
            // Resource.g:8:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "COMMAND"
    public final void mCOMMAND() throws RecognitionException {
        String value = null;


        try {
            int _type = COMMAND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken c=null;

            // Resource.g:53:5: (c= 'new' )
            // Resource.g:53:8: c= 'new'
            {
            int cStart = getCharIndex();
            match("new"); 
            int cStartLine54 = getLine();
            int cStartCharPos54 = getCharPositionInLine();
            c = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, cStart, getCharIndex()-1);
            c.setLine(cStartLine54);
            c.setCharPositionInLine(cStartCharPos54);


            value = c.getText();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMAND"

    // $ANTLR start "CLASSNAME"
    public final void mCLASSNAME() throws RecognitionException {
        try {
            int _type = CLASSNAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Resource.g:57:12: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '.' | '0' .. '9' )+ )
            // Resource.g:57:16: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '.' | '0' .. '9' )+
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // Resource.g:57:36: ( 'a' .. 'z' | 'A' .. 'Z' | '.' | '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='.'||(LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Resource.g:
            	    {
            	    if ( input.LA(1)=='.'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CLASSNAME"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Resource.g:59:12: ( ( 'a' .. 'z' | 'A' .. 'Z' )+ )
            // Resource.g:59:16: ( 'a' .. 'z' | 'A' .. 'Z' )+
            {
            // Resource.g:59:16: ( 'a' .. 'z' | 'A' .. 'Z' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= 'A' && LA2_0 <= 'Z')||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Resource.g:
            	    {
            	    if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Resource.g:60:12: ( ( '0' .. '9' )+ )
            // Resource.g:60:16: ( '0' .. '9' )+
            {
            // Resource.g:60:16: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Resource.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Resource.g:61:12: ( ( '\\r' )? '\\n' )
            // Resource.g:61:13: ( '\\r' )? '\\n'
            {
            // Resource.g:61:13: ( '\\r' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\r') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // Resource.g:61:13: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }


            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Resource.g:62:12: ( ( ' ' | '\\t' )+ )
            // Resource.g:62:16: ( ' ' | '\\t' )+
            {
            // Resource.g:62:16: ( ' ' | '\\t' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\t'||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Resource.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // Resource.g:1:8: ( T__10 | T__11 | T__12 | COMMAND | CLASSNAME | ID | INT | NEWLINE | WS )
        int alt6=9;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // Resource.g:1:10: T__10
                {
                mT__10(); 


                }
                break;
            case 2 :
                // Resource.g:1:16: T__11
                {
                mT__11(); 


                }
                break;
            case 3 :
                // Resource.g:1:22: T__12
                {
                mT__12(); 


                }
                break;
            case 4 :
                // Resource.g:1:28: COMMAND
                {
                mCOMMAND(); 


                }
                break;
            case 5 :
                // Resource.g:1:36: CLASSNAME
                {
                mCLASSNAME(); 


                }
                break;
            case 6 :
                // Resource.g:1:46: ID
                {
                mID(); 


                }
                break;
            case 7 :
                // Resource.g:1:49: INT
                {
                mINT(); 


                }
                break;
            case 8 :
                // Resource.g:1:53: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 9 :
                // Resource.g:1:61: WS
                {
                mWS(); 


                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\4\uffff\2\13\3\uffff\2\14\2\uffff\1\16\1\uffff";
    static final String DFA6_eofS =
        "\17\uffff";
    static final String DFA6_minS =
        "\1\11\3\uffff\2\56\3\uffff\2\101\2\uffff\1\56\1\uffff";
    static final String DFA6_maxS =
        "\1\172\3\uffff\2\172\3\uffff\2\172\2\uffff\1\172\1\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\1\2\1\3\2\uffff\1\7\1\10\1\11\2\uffff\1\6\1\5\1\uffff"+
        "\1\4";
    static final String DFA6_specialS =
        "\17\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\10\1\7\2\uffff\1\7\22\uffff\1\10\1\uffff\1\1\5\uffff\1\2"+
            "\1\3\6\uffff\12\6\7\uffff\32\5\6\uffff\15\5\1\4\14\5",
            "",
            "",
            "",
            "\1\14\1\uffff\12\14\7\uffff\32\12\6\uffff\4\12\1\11\25\12",
            "\1\14\1\uffff\12\14\7\uffff\32\12\6\uffff\32\12",
            "",
            "",
            "",
            "\32\12\6\uffff\26\12\1\15\3\12",
            "\32\12\6\uffff\32\12",
            "",
            "",
            "\1\14\1\uffff\12\14\7\uffff\32\12\6\uffff\32\12",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__10 | T__11 | T__12 | COMMAND | CLASSNAME | ID | INT | NEWLINE | WS );";
        }
    }
 

}