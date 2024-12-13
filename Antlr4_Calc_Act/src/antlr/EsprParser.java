// Generated from Espr.g4 by ANTLR 4.13.1

    package antlr;
    import org.antlr.v4.runtime.*;
    import java.io.*;
    import java.util.*;
    import Espr.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class EsprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, ID=15, NUM=16, TYPE=17, 
		COST=18, FUNCTION=19, COMMENT=20, WS=21;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_expr = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decl", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'<'", "'\\u2264'", "'\\u2265'", "'>'", "'\\u2260'", "'='", 
			"'^'", "'('", "')'", "'*'", "'/'", "'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "ID", "NUM", "TYPE", "COST", "FUNCTION", "COMMENT", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Espr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    // per gestione errori
	    public List<String> vars = new ArrayList<>();
	    public List<String> semErrors = new ArrayList<>();
	    // radice dell'AST (di tipo Expression)
	    public Program program = new Program();

	public EsprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public Program p;
		public DeclContext d;
		public ExprContext e;
		public TerminalNode EOF() { return getToken(EsprParser.EOF, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EsprListener ) ((EsprListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EsprListener ) ((EsprListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(12);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(6);
					((ProgContext)_localctx).d = decl();

					            program.addExpression(((ProgContext)_localctx).d.d);
					        
					}
					break;
				case 2:
					{
					setState(9);
					((ProgContext)_localctx).e = expr(0);

					            program.addExpression(((ProgContext)_localctx).e.e);
					        
					}
					break;
				}
				}
				setState(14); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 885248L) != 0) );
			setState(16);
			match(EOF);
			 ((ProgContext)_localctx).p =  program; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends ParserRuleContext {
		public Expression d;
		public Token name;
		public Token type;
		public Token val;
		public TerminalNode ID() { return getToken(EsprParser.ID, 0); }
		public TerminalNode TYPE() { return getToken(EsprParser.TYPE, 0); }
		public TerminalNode NUM() { return getToken(EsprParser.NUM, 0); }
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EsprListener ) ((EsprListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EsprListener ) ((EsprListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			((DeclContext)_localctx).name = match(ID);
			setState(20);
			match(T__0);
			setState(21);
			((DeclContext)_localctx).type = match(TYPE);
			setState(22);
			match(T__0);
			setState(23);
			((DeclContext)_localctx).val = match(NUM);

			        int line = ((DeclContext)_localctx).name.getLine();
			        int col = ((DeclContext)_localctx).name.getCharPositionInLine() + 1;
			        String id = ((DeclContext)_localctx).name.getText();
			        if (vars.contains(id)) {
			            semErrors.add("Error, variable: " + id + "already declared (line " + line + ", col " + col + ")");
			        } else {
			            vars.add(id);
			        }
			        String tipo = ((DeclContext)_localctx).type.getText();
			        double val = Double.parseDouble(((DeclContext)_localctx).val.getText());
			        ((DeclContext)_localctx).d =  new VariableDeclaration(id, tipo, val);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public Expression e;
		public ExprContext left;
		public ExprContext middle;
		public Token id;
		public Token n;
		public Token c;
		public Token func;
		public ExprContext param;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ID() { return getToken(EsprParser.ID, 0); }
		public TerminalNode NUM() { return getToken(EsprParser.NUM, 0); }
		public TerminalNode COST() { return getToken(EsprParser.COST, 0); }
		public TerminalNode FUNCTION() { return getToken(EsprParser.FUNCTION, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EsprListener ) ((EsprListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EsprListener ) ((EsprListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				{
				setState(27);
				match(T__8);
				setState(28);
				((ExprContext)_localctx).middle = expr(0);
				setState(29);
				match(T__9);

				        ((ExprContext)_localctx).e =  ((ExprContext)_localctx).middle.e;
				    
				}
				break;
			case ID:
				{
				setState(32);
				((ExprContext)_localctx).id = match(ID);

				        int line = ((ExprContext)_localctx).id.getLine();
				        int col = ((ExprContext)_localctx).id.getCharPositionInLine() + 1;
				        if (!vars.contains(((ExprContext)_localctx).id.getText())) {
				            semErrors.add("Error, variable : " + ((ExprContext)_localctx).id.getText() + " not declared (line " + line + ", col " + col + ")");
				        }
				        ((ExprContext)_localctx).e =  new Var(((ExprContext)_localctx).id.getText());
				    
				}
				break;
			case NUM:
				{
				setState(34);
				((ExprContext)_localctx).n = match(NUM);

				        ((ExprContext)_localctx).e =  new NumericExpression(Double.parseDouble(((ExprContext)_localctx).n.getText()));
				    
				}
				break;
			case COST:
				{
				setState(36);
				((ExprContext)_localctx).c = match(COST);

				        switch (((ExprContext)_localctx).c.getText()) {
				            case "PI":
				                ((ExprContext)_localctx).e = new  NumericExpression("PI");
				                break;
				            case "-PI":
				                ((ExprContext)_localctx).e =  new NumericExpression("-PI");
				                break;
				            case "EULER":
				                ((ExprContext)_localctx).e =  new NumericExpression("EULER");
				                break;
				            case "-EULER":
				                ((ExprContext)_localctx).e =  new NumericExpression("-EULER");
				                break;
				        }
				    
				}
				break;
			case FUNCTION:
				{
				setState(38);
				((ExprContext)_localctx).func = match(FUNCTION);
				setState(39);
				match(T__8);
				setState(40);
				((ExprContext)_localctx).param = expr(0);
				setState(41);
				match(T__9);

				        try {
				            Functions funcEnum = Functions.valueOf(((ExprContext)_localctx).func.getText());
				            ((ExprContext)_localctx).e =  new NumericExpression(funcEnum, ((ExprContext)_localctx).param.e);
				        } catch (IllegalArgumentException ex) {
				            semErrors.add("Error: function not supported " + ((ExprContext)_localctx).func.getText());
				        }
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(103);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(101);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(46);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(47);
						match(T__1);
						setState(48);
						((ExprContext)_localctx).right = expr(17);

						                  ((ExprContext)_localctx).e =  new BooleanExpression(((ExprContext)_localctx).left.e, ((ExprContext)_localctx).right.e,"<");
						              
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(51);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(52);
						match(T__2);
						setState(53);
						((ExprContext)_localctx).right = expr(16);

						                  ((ExprContext)_localctx).e =  new BooleanExpression(((ExprContext)_localctx).left.e, ((ExprContext)_localctx).right.e,"≤");
						              
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(56);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(57);
						match(T__3);
						setState(58);
						((ExprContext)_localctx).right = expr(15);

						                  ((ExprContext)_localctx).e =  new BooleanExpression(((ExprContext)_localctx).left.e, ((ExprContext)_localctx).right.e,"≥");
						              
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(61);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(62);
						match(T__4);
						setState(63);
						((ExprContext)_localctx).right = expr(14);

						                  ((ExprContext)_localctx).e =  new BooleanExpression(((ExprContext)_localctx).left.e, ((ExprContext)_localctx).right.e,">");
						              
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(66);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(67);
						match(T__5);
						setState(68);
						((ExprContext)_localctx).right = expr(13);

						                  ((ExprContext)_localctx).e =  new  BooleanExpression(((ExprContext)_localctx).left.e, ((ExprContext)_localctx).right.e,"≠");
						              
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(71);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(72);
						match(T__6);
						setState(73);
						((ExprContext)_localctx).right = expr(12);

						                  ((ExprContext)_localctx).e =  new BooleanExpression(((ExprContext)_localctx).left.e, ((ExprContext)_localctx).right.e,"=");
						              
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(76);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(77);
						match(T__7);
						setState(78);
						((ExprContext)_localctx).right = expr(11);

						                  ((ExprContext)_localctx).e =  new NumericExpression(((ExprContext)_localctx).left.e, ((ExprContext)_localctx).right.e,"^");
						              
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(81);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(82);
						match(T__10);
						setState(83);
						((ExprContext)_localctx).right = expr(9);

						                  ((ExprContext)_localctx).e =  new NumericExpression(((ExprContext)_localctx).left.e, ((ExprContext)_localctx).right.e,"*");
						              
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(86);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(87);
						match(T__11);
						setState(88);
						((ExprContext)_localctx).right = expr(8);

						                  ((ExprContext)_localctx).e =  new NumericExpression(((ExprContext)_localctx).left.e, ((ExprContext)_localctx).right.e,"/");
						              
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(91);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(92);
						match(T__12);
						setState(93);
						((ExprContext)_localctx).right = expr(7);

						                  ((ExprContext)_localctx).e =  new NumericExpression(((ExprContext)_localctx).left.e, ((ExprContext)_localctx).right.e,"+");
						              
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(96);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(97);
						match(T__13);
						setState(98);
						((ExprContext)_localctx).right = expr(6);

						                  ((ExprContext)_localctx).e =  new NumericExpression(((ExprContext)_localctx).left.e, ((ExprContext)_localctx).right.e,"-");
						              
						}
						break;
					}
					} 
				}
				setState(105);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 16);
		case 1:
			return precpred(_ctx, 15);
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 10);
		case 7:
			return precpred(_ctx, 8);
		case 8:
			return precpred(_ctx, 7);
		case 9:
			return precpred(_ctx, 6);
		case 10:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0015k\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0004\u0000\r\b\u0000\u000b\u0000\f\u0000\u000e\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002-\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002f\b\u0002\n\u0002\f\u0002i\t\u0002\u0001\u0002\u0000"+
		"\u0001\u0004\u0003\u0000\u0002\u0004\u0000\u0000x\u0000\f\u0001\u0000"+
		"\u0000\u0000\u0002\u0013\u0001\u0000\u0000\u0000\u0004,\u0001\u0000\u0000"+
		"\u0000\u0006\u0007\u0003\u0002\u0001\u0000\u0007\b\u0006\u0000\uffff\uffff"+
		"\u0000\b\r\u0001\u0000\u0000\u0000\t\n\u0003\u0004\u0002\u0000\n\u000b"+
		"\u0006\u0000\uffff\uffff\u0000\u000b\r\u0001\u0000\u0000\u0000\f\u0006"+
		"\u0001\u0000\u0000\u0000\f\t\u0001\u0000\u0000\u0000\r\u000e\u0001\u0000"+
		"\u0000\u0000\u000e\f\u0001\u0000\u0000\u0000\u000e\u000f\u0001\u0000\u0000"+
		"\u0000\u000f\u0010\u0001\u0000\u0000\u0000\u0010\u0011\u0005\u0000\u0000"+
		"\u0001\u0011\u0012\u0006\u0000\uffff\uffff\u0000\u0012\u0001\u0001\u0000"+
		"\u0000\u0000\u0013\u0014\u0005\u000f\u0000\u0000\u0014\u0015\u0005\u0001"+
		"\u0000\u0000\u0015\u0016\u0005\u0011\u0000\u0000\u0016\u0017\u0005\u0001"+
		"\u0000\u0000\u0017\u0018\u0005\u0010\u0000\u0000\u0018\u0019\u0006\u0001"+
		"\uffff\uffff\u0000\u0019\u0003\u0001\u0000\u0000\u0000\u001a\u001b\u0006"+
		"\u0002\uffff\uffff\u0000\u001b\u001c\u0005\t\u0000\u0000\u001c\u001d\u0003"+
		"\u0004\u0002\u0000\u001d\u001e\u0005\n\u0000\u0000\u001e\u001f\u0006\u0002"+
		"\uffff\uffff\u0000\u001f-\u0001\u0000\u0000\u0000 !\u0005\u000f\u0000"+
		"\u0000!-\u0006\u0002\uffff\uffff\u0000\"#\u0005\u0010\u0000\u0000#-\u0006"+
		"\u0002\uffff\uffff\u0000$%\u0005\u0012\u0000\u0000%-\u0006\u0002\uffff"+
		"\uffff\u0000&\'\u0005\u0013\u0000\u0000\'(\u0005\t\u0000\u0000()\u0003"+
		"\u0004\u0002\u0000)*\u0005\n\u0000\u0000*+\u0006\u0002\uffff\uffff\u0000"+
		"+-\u0001\u0000\u0000\u0000,\u001a\u0001\u0000\u0000\u0000, \u0001\u0000"+
		"\u0000\u0000,\"\u0001\u0000\u0000\u0000,$\u0001\u0000\u0000\u0000,&\u0001"+
		"\u0000\u0000\u0000-g\u0001\u0000\u0000\u0000./\n\u0010\u0000\u0000/0\u0005"+
		"\u0002\u0000\u000001\u0003\u0004\u0002\u001112\u0006\u0002\uffff\uffff"+
		"\u00002f\u0001\u0000\u0000\u000034\n\u000f\u0000\u000045\u0005\u0003\u0000"+
		"\u000056\u0003\u0004\u0002\u001067\u0006\u0002\uffff\uffff\u00007f\u0001"+
		"\u0000\u0000\u000089\n\u000e\u0000\u00009:\u0005\u0004\u0000\u0000:;\u0003"+
		"\u0004\u0002\u000f;<\u0006\u0002\uffff\uffff\u0000<f\u0001\u0000\u0000"+
		"\u0000=>\n\r\u0000\u0000>?\u0005\u0005\u0000\u0000?@\u0003\u0004\u0002"+
		"\u000e@A\u0006\u0002\uffff\uffff\u0000Af\u0001\u0000\u0000\u0000BC\n\f"+
		"\u0000\u0000CD\u0005\u0006\u0000\u0000DE\u0003\u0004\u0002\rEF\u0006\u0002"+
		"\uffff\uffff\u0000Ff\u0001\u0000\u0000\u0000GH\n\u000b\u0000\u0000HI\u0005"+
		"\u0007\u0000\u0000IJ\u0003\u0004\u0002\fJK\u0006\u0002\uffff\uffff\u0000"+
		"Kf\u0001\u0000\u0000\u0000LM\n\n\u0000\u0000MN\u0005\b\u0000\u0000NO\u0003"+
		"\u0004\u0002\u000bOP\u0006\u0002\uffff\uffff\u0000Pf\u0001\u0000\u0000"+
		"\u0000QR\n\b\u0000\u0000RS\u0005\u000b\u0000\u0000ST\u0003\u0004\u0002"+
		"\tTU\u0006\u0002\uffff\uffff\u0000Uf\u0001\u0000\u0000\u0000VW\n\u0007"+
		"\u0000\u0000WX\u0005\f\u0000\u0000XY\u0003\u0004\u0002\bYZ\u0006\u0002"+
		"\uffff\uffff\u0000Zf\u0001\u0000\u0000\u0000[\\\n\u0006\u0000\u0000\\"+
		"]\u0005\r\u0000\u0000]^\u0003\u0004\u0002\u0007^_\u0006\u0002\uffff\uffff"+
		"\u0000_f\u0001\u0000\u0000\u0000`a\n\u0005\u0000\u0000ab\u0005\u000e\u0000"+
		"\u0000bc\u0003\u0004\u0002\u0006cd\u0006\u0002\uffff\uffff\u0000df\u0001"+
		"\u0000\u0000\u0000e.\u0001\u0000\u0000\u0000e3\u0001\u0000\u0000\u0000"+
		"e8\u0001\u0000\u0000\u0000e=\u0001\u0000\u0000\u0000eB\u0001\u0000\u0000"+
		"\u0000eG\u0001\u0000\u0000\u0000eL\u0001\u0000\u0000\u0000eQ\u0001\u0000"+
		"\u0000\u0000eV\u0001\u0000\u0000\u0000e[\u0001\u0000\u0000\u0000e`\u0001"+
		"\u0000\u0000\u0000fi\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000"+
		"gh\u0001\u0000\u0000\u0000h\u0005\u0001\u0000\u0000\u0000ig\u0001\u0000"+
		"\u0000\u0000\u0005\f\u000e,eg";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}