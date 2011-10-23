// $ANTLR 3.4 Resource.g 2011-10-22 22:20:10

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
    public static final int IDENTIFIER=6;
    public static final int NEWLINE=7;
    public static final int Number=8;
    public static final int SPACE=9;

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
            // Resource.g:21:7: ( '\"' )
            // Resource.g:21:9: '\"'
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
            // Resource.g:22:7: ( '(' )
            // Resource.g:22:9: '('
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
            // Resource.g:23:7: ( ')' )
            // Resource.g:23:9: ')'
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

    // $ANTLR start "Number"
    public final void mNumber() throws RecognitionException {
        try {
            int _type = Number;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Resource.g:83:3: ( ( '0' .. '9' )+ )
            // Resource.g:83:6: ( '0' .. '9' )+
            {
            // Resource.g:83:6: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
                    alt1=1;
                }


                switch (alt1) {
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
    // $ANTLR end "Number"

    // $ANTLR start "COMMAND"
    public final void mCOMMAND() throws RecognitionException {
        String value = null;


        try {
            int _type = COMMAND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken c=null;

            // Resource.g:96:5: (c= 'new' )
            // Resource.g:96:8: c= 'new'
            {
            int cStart = getCharIndex();
            match("new"); 
            int cStartLine77 = getLine();
            int cStartCharPos77 = getCharPositionInLine();
            c = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, cStart, getCharIndex()-1);
            c.setLine(cStartLine77);
            c.setCharPositionInLine(cStartCharPos77);


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

    // $ANTLR start "SPACE"
    public final void mSPACE() throws RecognitionException {
        try {
            int _type = SPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Resource.g:102:3: ( ( ' ' | '\\t' ) )
            // Resource.g:102:6: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SPACE"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Resource.g:108:3: ( ( '\\r' )? '\\n' | '\\r' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1=='\n') ) {
                    alt3=1;
                }
                else {
                    alt3=2;
                }
            }
            else if ( (LA3_0=='\n') ) {
                alt3=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // Resource.g:108:6: ( '\\r' )? '\\n'
                    {
                    // Resource.g:108:6: ( '\\r' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0=='\r') ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // Resource.g:108:6: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // Resource.g:109:6: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "CLASSNAME"
    public final void mCLASSNAME() throws RecognitionException {
        try {
            int _type = CLASSNAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Resource.g:113:6: ( IDENTIFIER ( '.' IDENTIFIER )+ )
            // Resource.g:113:8: IDENTIFIER ( '.' IDENTIFIER )+
            {
            mIDENTIFIER(); 


            // Resource.g:113:19: ( '.' IDENTIFIER )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='.') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Resource.g:113:20: '.' IDENTIFIER
            	    {
            	    match('.'); 

            	    mIDENTIFIER(); 


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
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

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Resource.g:117:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ )
            // Resource.g:117:8: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // Resource.g:117:28: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Resource.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENTIFIER"

    public void mTokens() throws RecognitionException {
        // Resource.g:1:8: ( T__10 | T__11 | T__12 | Number | COMMAND | SPACE | NEWLINE | CLASSNAME | IDENTIFIER )
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
                // Resource.g:1:28: Number
                {
                mNumber(); 


                }
                break;
            case 5 :
                // Resource.g:1:35: COMMAND
                {
                mCOMMAND(); 


                }
                break;
            case 6 :
                // Resource.g:1:43: SPACE
                {
                mSPACE(); 


                }
                break;
            case 7 :
                // Resource.g:1:49: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 8 :
                // Resource.g:1:57: CLASSNAME
                {
                mCLASSNAME(); 


                }
                break;
            case 9 :
                // Resource.g:1:67: IDENTIFIER
                {
                mIDENTIFIER(); 


                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\11\uffff\2\14\1\16\3\uffff";
    static final String DFA6_eofS =
        "\17\uffff";
    static final String DFA6_minS =
        "\1\11\4\uffff\1\60\2\uffff\1\60\3\56\3\uffff";
    static final String DFA6_maxS =
        "\1\172\4\uffff\1\172\2\uffff\4\172\3\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\6\1\7\4\uffff\1\11\1\10\1\5";
    static final String DFA6_specialS =
        "\17\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\6\1\7\2\uffff\1\7\22\uffff\1\6\1\uffff\1\1\5\uffff\1\2\1"+
            "\3\6\uffff\12\4\7\uffff\32\10\6\uffff\15\10\1\5\14\10",
            "",
            "",
            "",
            "",
            "\12\12\7\uffff\32\12\6\uffff\4\12\1\11\25\12",
            "",
            "",
            "\12\12\7\uffff\32\12\6\uffff\32\12",
            "\1\15\1\uffff\12\12\7\uffff\32\12\6\uffff\26\12\1\13\3\12",
            "\1\15\1\uffff\12\12\7\uffff\32\12\6\uffff\32\12",
            "\1\15\1\uffff\12\12\7\uffff\32\12\6\uffff\32\12",
            "",
            "",
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
            return "1:1: Tokens : ( T__10 | T__11 | T__12 | Number | COMMAND | SPACE | NEWLINE | CLASSNAME | IDENTIFIER );";
        }
    }
 

}