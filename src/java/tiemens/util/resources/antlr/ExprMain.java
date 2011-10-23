package tiemens.util.resources.antlr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
        
        List<Integer> list = new ArrayList<Integer>();
        //System.out.println(Arrays.)
        
        
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