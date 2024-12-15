package Espr;

import java.util.*;


import Antlr4.CalcBaseVisitor;
import Antlr4.CalcParser.ProgramContext;
public class AntlrToProgram extends CalcBaseVisitor<Program>{

	private List<String> semErrors;// lista degli errori semantici 
	@Override
	public Program visitProgram(ProgramContext ctx) {
		Program prog=new Program();
		
		semErrors= new ArrayList<>();
		// aiuto visitor per trasformare ogni sottoalbero in oggetto Espression
		
		AntlrToExpression esprVisitor= new AntlrToExpression(semErrors);
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
	public List<String> getSemErr(){return semErrors;}
	// restituisce la lista degli errori semantici 
	
		

}
