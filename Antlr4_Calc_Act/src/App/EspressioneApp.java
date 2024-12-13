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
		
		//Voglio un solo argomento: il nome del file
		if(args.length!=1) {
			System.err.print("nome file?");
		}
		else {
			String fileName=args[0];
			//inzio il Parsing
			EsprParser parser=getParser(fileName);
			
			parser.prog();
			
			if(MyErrorListener.hasError) {
				//comunico eventuali errori del Listener
			}
			else {
			
			Program prog=parser.program;
			if(parser.semErrors.isEmpty()) {
				//valuto le espressioni
				ExpressionProcessor ep=new ExpressionProcessor(prog.getExpr());
				for(String evaluation:ep.getEvaluationResults()) {
					System.out.println(evaluation);
				}
			}else {
				for(String err:parser.semErrors) {
					//comunico eventuali errori semantici
					System.out.println(err);
				}
			}
			}
			
		}
		
	}
	// Metodo per ottenere il parser a partire dal nome del file
	private static EsprParser getParser(String fileName) {
		EsprParser parser=null;
		try {
			// Creazione dello stream di input a partire dal file
			CharStream input=CharStreams.fromFileName(fileName);
			EsprLexer lexer=new EsprLexer(input);
			CommonTokenStream tokens=new CommonTokenStream(lexer); 
			parser=new EsprParser(tokens);
			
			parser.removeErrorListeners();
			parser.addErrorListener(new MyErrorListener());
			
		} catch(IOException e) {
			// Gestione delle eccezioni in caso di errore nell'apertura del file
			e.printStackTrace();
		}
		
		return parser;
	}
	
}
