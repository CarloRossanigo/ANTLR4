package expression;

import java.util.*;

import ANTLR4.TeoriaBaseVisitor;
import ANTLR4.TeoriaParser.ProgramContext;

public class AntlrToProgram extends TeoriaBaseVisitor<Program>{

	public List<String> semanticErrors; // Semantic error list  
	@Override
	public Program visitProgram(ProgramContext ctx) {
		Program prog=new Program();
		
		semanticErrors= new ArrayList<>();
		
		// Helping visitor to transform each undertree in an expression object 
		
		AntlrToExpression esprVisitor= new AntlrToExpression(semanticErrors);
		for(int i=0;i<ctx.getChildCount();i++) {
			if(i==ctx.getChildCount()-1) {
				//Last childis EOF so i don't visit it 
			}
			else {
				prog.addExpression(esprVisitor.visit(ctx.getChild(i)));
			}
		}
			
		return prog;
		
	}
}
//Metodo per restituire la lista degli errori semantici?
