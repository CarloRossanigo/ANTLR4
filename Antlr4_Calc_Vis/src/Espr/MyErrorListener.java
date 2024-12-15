package Espr;
//Terence Parr: ANTLR4
import java.util.Collections;
import java.util.List;


import javax.swing.*;
import java.awt.*;



import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.RecognitionException;

import org.antlr.v4.runtime.Parser;
public class MyErrorListener extends BaseErrorListener {
	public static boolean hasError=false;
	
	@Override
	public void syntaxError(Recognizer<?,?> recognizer,Object offendingSymbol,int line,int charPos,String mes,RecognitionException e) {
		hasError=true;
		List<String> stack= ((Parser) recognizer).getRuleInvocationStack();
		Collections.reverse(stack);
		
		/* Definitive ANTLR4 Reference -> page 157  */
		 StringBuilder buf = new StringBuilder();
	        buf.append("rule stack: "+stack+" ");
	        buf.append("line "+line+":"+charPos+" at "+
	                   offendingSymbol+": "+mes);

	        JDialog dialog = new JDialog();
	        Container contentPane = dialog.getContentPane();
	        contentPane.add(new JLabel(buf.toString()));
	        contentPane.setBackground(Color.white);
	        dialog.setTitle("Syntax error");
	        dialog.pack();
	        dialog.setLocationRelativeTo(null);
	        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        dialog.setVisible(true);
	}

}


