package expression;
//Terence Parr: ANTLR4
import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Parser;
public class MyErrorListener extends BaseErrorListener {
	public static boolean hasError=false;
	
	@Override
	public void syntaxError(Recognizer<?,?> recognizer,Object offendingSymbol,int line,int charPos,String mes,RecognitionException e) {
		hasError=true;
		List<String> stack= ((Parser) recognizer).getRuleInvocationStack();
		Collections.reverse(stack);
		System.err.println("Errore sintattico!" );
		System.err.println("Token " +" \" " +((Token) offendingSymbol).getText() +"\"" +"(line" +line +",col: "+(charPos+1)+" ) " + ": " +mes);
		System.err.println("Rule Stack :"  + stack);
	}

}
