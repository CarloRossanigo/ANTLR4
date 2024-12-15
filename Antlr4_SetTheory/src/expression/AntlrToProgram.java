package expression;

import java.util.*;

import ANTLR4.TeoriaBaseVisitor;
import ANTLR4.TeoriaParser.ProgramContext;

public class AntlrToProgram extends TeoriaBaseVisitor<Program>{

	public List<String> semanticErrors; // lista degli errori semantici 
	@Override
	public Program visitProgram(ProgramContext ctx) {
		Program prog=new Program();
		
		semanticErrors= new ArrayList<>();
		
		// aiuto visitor per trasformare ogni sottoalbero in oggetto Espression
		
		AntlrToExpression esprVisitor= new AntlrToExpression(semanticErrors);
		for(int i=0;i<ctx.getChildCount();i++) {
			if(i==ctx.getChildCount()-1) {
				// l'ultimo figlio è EOF quindi non lo visito
			}
			else {
				prog.addExpression(esprVisitor.visit(ctx.getChild(i)));
			}
		}
			
		return prog;
		
	}
}
//Metodo per restituire la lista degli errori semantici?
