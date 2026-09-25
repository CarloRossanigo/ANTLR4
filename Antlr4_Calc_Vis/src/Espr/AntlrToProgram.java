package Espr;

import java.util.*;


import Antlr4.CalcBaseVisitor;
import Antlr4.CalcParser.ProgramContext;
public class AntlrToProgram extends CalcBaseVisitor<Program>{

	private List<String> semErrors;// Semantic error list  
	@Override
	public Program visitProgram(ProgramContext ctx) {
		Program prog=new Program();
		
		semErrors= new ArrayList<>();
		// Helping visitor to transofrm each undertree in expression object 
		
		AntlrToExpression esprVisitor= new AntlrToExpression(semErrors);
		for(int i=0;i<ctx.getChildCount();i++) {
			if(i==ctx.getChildCount()-1) {
				// Last child is EOF so don't visit 
				
			}
			else {
				prog.addExpression(esprVisitor.visit(ctx.getChild(i)));
			}
		}
			
		return prog;
		
	}
	public List<String> getSemErr(){return semErrors;}
	// Return the error semantic list 
	
		

}
