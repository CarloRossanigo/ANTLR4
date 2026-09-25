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
		//Just file name as argument 
		if(args.length!=1) {
			System.err.print("nome file?");
		}
		else {
			String fileName=args[0];
			TeoriaParser parser=getParser(fileName);
			
			ParseTree antlrAST=parser.prog();
			
			if(MyErrorListener.hasError) {
				//Handle Listener error 
			}
			else {
			
			AntlrToProgram progVisitor=new AntlrToProgram();
			Program prog=progVisitor.visit(antlrAST);
			if(progVisitor.semanticErrors.isEmpty()) {
				// Evaluate the expression 
				ExpressionProcessor ep=new ExpressionProcessor(prog.expressions);
				for(String evaluation:ep.getEvaluationResults()) {
					System.out.println(evaluation);
				}
			}else {
				for(String err:progVisitor.semanticErrors) {
					//Handle semantic error 
					System.out.println(err);
				}
			}
			}
			
		}
		
	}
	//Methods to ontain parser from filename 
	private static TeoriaParser getParser(String fileName) {
		TeoriaParser parser=null;
		try {
			// Creation stream input form the file
			CharStream input=CharStreams.fromFileName(fileName);
			TeoriaLexer lexer=new TeoriaLexer(input);
			CommonTokenStream tokens=new CommonTokenStream(lexer); 
			parser=new TeoriaParser(tokens);
			
			parser.removeErrorListeners();
			parser.addErrorListener(new MyErrorListener());
			
		} catch(IOException e) {
			// Handle exception  
			e.printStackTrace();
		}
		
		return parser;
	}
	
}
