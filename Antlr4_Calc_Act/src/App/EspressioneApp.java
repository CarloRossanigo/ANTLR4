package App;

import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import Espr.*;
import antlr.EsprLexer;
import antlr.EsprParser;


public class EspressioneApp {

	public static void main(String[] args) {
		
		// Just the name of the file as  argument
		if(args.length!=1) {
			System.err.print("nome file?");
		}
		else {
			String fileName=args[0];
			//inzio il Parsing
			EsprParser parser=getParser(fileName);
			
			parser.prog();
			
			if(MyErrorListener.hasError) {
				// To hndle Listener error 
			}
			else {
			
			Program prog=parser.program;
			if(parser.semErrors.isEmpty()) {
				// Evaluate the expression 
				ExpressionProcessor ep=new ExpressionProcessor(prog.getExpr());
				for(String evaluation:ep.getEvaluationResults()) {
					System.out.println(evaluation);
				}
			}else {
				for(String err:parser.semErrors) {
					// Handle and printing semantic error 
					System.out.println(err);
				}
			}
			}
			
		}
		
	}
	// Methods to obtain parser from the file name 
	private static EsprParser getParser(String fileName) {
		EsprParser parser=null;
		try {
			// Creation streaming input from the file name  
			CharStream input=CharStreams.fromFileName(fileName);
			EsprLexer lexer=new EsprLexer(input);
			CommonTokenStream tokens=new CommonTokenStream(lexer); 
			parser=new EsprParser(tokens);
			
			parser.removeErrorListeners();
			parser.addErrorListener(new MyErrorListener());
			
		} catch(IOException e) {
			// Handle exceptions if there are errors opening the file 
			e.printStackTrace();
		}
		
		return parser;
	}
	
}
