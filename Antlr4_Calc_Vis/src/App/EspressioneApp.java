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
		
		//File name as the argument 
		if(args.length!=1) {
			System.err.print("file name?");
		}
		else {
			String fileName=args[0];
			CalcParser parser=getParser(fileName);
			// Building the sintax tree; starting the parsing from 'prog'  
			
			ParseTree antlrAST=parser.prog();
			
			if(Espr.MyErrorListener.hasError) {
				// Handle sintax error  
				
			}
			else {
				// Building a visitor for tree conversion from parsing to expression 
				
			AntlrToProgram progVisitor=new AntlrToProgram();
			Program prog=progVisitor.visit(antlrAST);
			if(progVisitor.getSemErr().isEmpty()) {
				// expression evaluation 
				ExpressionProcessor ep=new ExpressionProcessor(prog.getExpr());
				for(String evaluation:ep.getEvaluationResults()) {
					System.out.println(evaluation);
				}
			}else {
				List<String> Errori=progVisitor.getSemErr();
				for(String err:Errori) {
					// Semantic error 
					System.out.println(err);
				}
			}
			}
			
		}
		
	}
// Methods to obtain the parser from the filename 
	private static CalcParser getParser(String fileName) {
		CalcParser parser=null;
		try {
			// Creation of the input stream from the filename 
			CharStream input=CharStreams.fromFileName(fileName);
			CalcLexer lexer=new CalcLexer(input);
			CommonTokenStream tokens=new CommonTokenStream(lexer); 
			parser=new CalcParser(tokens);
			//Handle the sintax error
			
			parser.removeErrorListeners();
			parser.addErrorListener(new MyErrorListener());
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return parser;
	}

}



