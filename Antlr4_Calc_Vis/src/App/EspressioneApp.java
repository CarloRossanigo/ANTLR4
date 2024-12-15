package App;

import Antlr4.CalcLexer;
import Antlr4.CalcParser;
import Espr.ExpressionProcessor;
import Espr.AntlrToProgram;
import Espr.MyErrorListener;
import Espr.Program;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.List;

public class EspressioneApp {

	public static void main(String[] args) {
		
		//nome file come unico argomento
		if(args.length!=1) {
			System.err.print("file name?");
		}
		else {
			String fileName=args[0];
			CalcParser parser=getParser(fileName);
			// costruisco albero sintattico e inizio il parsing da 'prog'
			
			ParseTree antlrAST=parser.prog();
			
			if(Espr.MyErrorListener.hasError) {
				// riporto errori di sintassi 
				
			}
			else {
				// costruisco un visitor per la conversione dell'albero di parsing in espressioni
				
			AntlrToProgram progVisitor=new AntlrToProgram();
			Program prog=progVisitor.visit(antlrAST);
			if(progVisitor.getSemErr().isEmpty()) {
				//valutazione delle espressioni
				ExpressionProcessor ep=new ExpressionProcessor(prog.getExpr());
				for(String evaluation:ep.getEvaluationResults()) {
					System.out.println(evaluation);
				}
			}else {
				List<String> Errori=progVisitor.getSemErr();
				for(String err:Errori) {
					//errori semantici
					System.out.println(err);
				}
			}
			}
			
		}
		
	}
//metodo per ottenere il parser dal nome del file
	private static CalcParser getParser(String fileName) {
		CalcParser parser=null;
		try {
			// Creazione dello stream di input a partire dal file
			CharStream input=CharStreams.fromFileName(fileName);
			CalcLexer lexer=new CalcLexer(input);
			CommonTokenStream tokens=new CommonTokenStream(lexer); 
			parser=new CalcParser(tokens);
			//gestisco gli errori di sintassi
			
			parser.removeErrorListeners();
			parser.addErrorListener(new MyErrorListener());
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return parser;
	}

}



