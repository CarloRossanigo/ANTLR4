package App;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import ANTLR4.TeoriaLexer;
import ANTLR4.TeoriaParser;
import expression.AntlrToProgram;
import expression.ExpressionProcessor;
import expression.MyErrorListener;
import expression.Program;


public class EspressioneApp {

	public static void main(String[] args) {
		//Un argomento: nome file
		if(args.length!=1) {
			System.err.print("nome file?");
		}
		else {
			String fileName=args[0];
			TeoriaParser parser=getParser(fileName);
			
			ParseTree antlrAST=parser.prog();
			
			if(MyErrorListener.hasError) {
				//Comunico eventuali errori del Listener
			}
			else {
			
			AntlrToProgram progVisitor=new AntlrToProgram();
			Program prog=progVisitor.visit(antlrAST);
			if(progVisitor.semanticErrors.isEmpty()) {
				//Valuto le espressioni
				ExpressionProcessor ep=new ExpressionProcessor(prog.expressions);
				for(String evaluation:ep.getEvaluationResults()) {
					System.out.println(evaluation);
				}
			}else {
				for(String err:progVisitor.semanticErrors) {
					//comunico eventuali errori semantici
					System.out.println(err);
				}
			}
			}
			
		}
		
	}
	// Metodo per ottenere il parser  dal nome del file
	private static TeoriaParser getParser(String fileName) {
		TeoriaParser parser=null;
		try {
			// Creazione dello stream di input a partire dal file
			CharStream input=CharStreams.fromFileName(fileName);
			TeoriaLexer lexer=new TeoriaLexer(input);
			CommonTokenStream tokens=new CommonTokenStream(lexer); 
			parser=new TeoriaParser(tokens);
			
			parser.removeErrorListeners();
			parser.addErrorListener(new MyErrorListener());
			
		} catch(IOException e) {
			// Gestione delle eccezioni 
			e.printStackTrace();
		}
		
		return parser;
	}
	
}
