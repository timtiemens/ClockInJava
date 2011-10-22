package tiemens.util.resources.antlr;

import org.antlr.runtime.*;

public class ExprMain
{
    public static void main(String[] args) throws Exception 
    {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        parser.prog();
        
        
        
//        SimpleCalcLexer lex = new SimpleCalcLexer(new ANTLRFileStream(args[0]));
//        CommonTokenStream tokens = new CommonTokenStream(lex);

//        SimpleCalcParser parser = new SimpleCalcParser(tokens);

//        try {
//            parser.expr();
//        } catch (RecognitionException e)  {
//            e.printStackTrace();
//        }
    }
}