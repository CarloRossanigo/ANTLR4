// Generated from Teoria.g4 by ANTLR 4.13.1

    package ANTLR4;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TeoriaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, MIN=4, MAX=5, ID=6, NUM=7, UNION=8, INTERSECTION=9, 
		DIFFERENZA=10, DIFFERENZASIMMETRICA=11, COMPLEMENTO=12, LP=13, RP=14, 
		EQUALS=15, NEQUAL=16, CONTENUTODX=17, CONTENUTOSX=18, STRING=19, COMMENT=20, 
		WS=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "MIN", "MAX", "ID", "NUM", "UNION", "INTERSECTION", 
			"DIFFERENZA", "DIFFERENZASIMMETRICA", "COMPLEMENTO", "LP", "RP", "EQUALS", 
			"NEQUAL", "CONTENUTODX", "CONTENUTOSX", "STRING", "COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':{'", "','", "'}'", "'MIN'", "'MAX'", null, null, "'+'", "'^'", 
			"'/'", "'\\u2206'", "'!'", "'('", "')'", "'='", "'\\u2260'", "'\\u2264'", 
			"'\\u2265'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "MIN", "MAX", "ID", "NUM", "UNION", "INTERSECTION", 
			"DIFFERENZA", "DIFFERENZASIMMETRICA", "COMPLEMENTO", "LP", "RP", "EQUALS", 
			"NEQUAL", "CONTENUTODX", "CONTENUTOSX", "STRING", "COMMENT", "WS"
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


	public TeoriaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Teoria.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0015\u007f\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0004\u0005<\b\u0005"+
		"\u000b\u0005\f\u0005=\u0001\u0006\u0001\u0006\u0003\u0006B\b\u0006\u0001"+
		"\u0006\u0004\u0006E\b\u0006\u000b\u0006\f\u0006F\u0001\u0006\u0001\u0006"+
		"\u0004\u0006K\b\u0006\u000b\u0006\f\u0006L\u0003\u0006O\b\u0006\u0003"+
		"\u0006Q\b\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0004\u0012j\b\u0012\u000b\u0012"+
		"\f\u0012k\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013"+
		"r\b\u0013\n\u0013\f\u0013u\t\u0013\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0004\u0014z\b\u0014\u000b\u0014\f\u0014{\u0001\u0014\u0001\u0014\u0000"+
		"\u0000\u0015\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b"+
		"\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015\u0001"+
		"\u0000\u0005\u0001\u0000AZ\u0001\u000009\u0001\u0000az\u0002\u0000\n\n"+
		"\r\r\u0003\u0000\t\n\r\r  \u0087\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0000)\u0001\u0000\u0000\u0000\u0001+\u0001\u0000\u0000\u0000\u0003."+
		"\u0001\u0000\u0000\u0000\u00050\u0001\u0000\u0000\u0000\u00072\u0001\u0000"+
		"\u0000\u0000\t6\u0001\u0000\u0000\u0000\u000b;\u0001\u0000\u0000\u0000"+
		"\rP\u0001\u0000\u0000\u0000\u000fR\u0001\u0000\u0000\u0000\u0011T\u0001"+
		"\u0000\u0000\u0000\u0013V\u0001\u0000\u0000\u0000\u0015X\u0001\u0000\u0000"+
		"\u0000\u0017Z\u0001\u0000\u0000\u0000\u0019\\\u0001\u0000\u0000\u0000"+
		"\u001b^\u0001\u0000\u0000\u0000\u001d`\u0001\u0000\u0000\u0000\u001fb"+
		"\u0001\u0000\u0000\u0000!d\u0001\u0000\u0000\u0000#f\u0001\u0000\u0000"+
		"\u0000%i\u0001\u0000\u0000\u0000\'m\u0001\u0000\u0000\u0000)y\u0001\u0000"+
		"\u0000\u0000+,\u0005:\u0000\u0000,-\u0005{\u0000\u0000-\u0002\u0001\u0000"+
		"\u0000\u0000./\u0005,\u0000\u0000/\u0004\u0001\u0000\u0000\u000001\u0005"+
		"}\u0000\u00001\u0006\u0001\u0000\u0000\u000023\u0005M\u0000\u000034\u0005"+
		"I\u0000\u000045\u0005N\u0000\u00005\b\u0001\u0000\u0000\u000067\u0005"+
		"M\u0000\u000078\u0005A\u0000\u000089\u0005X\u0000\u00009\n\u0001\u0000"+
		"\u0000\u0000:<\u0007\u0000\u0000\u0000;:\u0001\u0000\u0000\u0000<=\u0001"+
		"\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000"+
		">\f\u0001\u0000\u0000\u0000?Q\u00050\u0000\u0000@B\u0005-\u0000\u0000"+
		"A@\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BD\u0001\u0000\u0000"+
		"\u0000CE\u0007\u0001\u0000\u0000DC\u0001\u0000\u0000\u0000EF\u0001\u0000"+
		"\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GN\u0001"+
		"\u0000\u0000\u0000HJ\u0005.\u0000\u0000IK\u0007\u0001\u0000\u0000JI\u0001"+
		"\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000"+
		"LM\u0001\u0000\u0000\u0000MO\u0001\u0000\u0000\u0000NH\u0001\u0000\u0000"+
		"\u0000NO\u0001\u0000\u0000\u0000OQ\u0001\u0000\u0000\u0000P?\u0001\u0000"+
		"\u0000\u0000PA\u0001\u0000\u0000\u0000Q\u000e\u0001\u0000\u0000\u0000"+
		"RS\u0005+\u0000\u0000S\u0010\u0001\u0000\u0000\u0000TU\u0005^\u0000\u0000"+
		"U\u0012\u0001\u0000\u0000\u0000VW\u0005/\u0000\u0000W\u0014\u0001\u0000"+
		"\u0000\u0000XY\u0005\u2206\u0000\u0000Y\u0016\u0001\u0000\u0000\u0000"+
		"Z[\u0005!\u0000\u0000[\u0018\u0001\u0000\u0000\u0000\\]\u0005(\u0000\u0000"+
		"]\u001a\u0001\u0000\u0000\u0000^_\u0005)\u0000\u0000_\u001c\u0001\u0000"+
		"\u0000\u0000`a\u0005=\u0000\u0000a\u001e\u0001\u0000\u0000\u0000bc\u0005"+
		"\u2260\u0000\u0000c \u0001\u0000\u0000\u0000de\u0005\u2264\u0000\u0000"+
		"e\"\u0001\u0000\u0000\u0000fg\u0005\u2265\u0000\u0000g$\u0001\u0000\u0000"+
		"\u0000hj\u0007\u0002\u0000\u0000ih\u0001\u0000\u0000\u0000jk\u0001\u0000"+
		"\u0000\u0000ki\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000l&\u0001"+
		"\u0000\u0000\u0000mn\u0005-\u0000\u0000no\u0005-\u0000\u0000os\u0001\u0000"+
		"\u0000\u0000pr\b\u0003\u0000\u0000qp\u0001\u0000\u0000\u0000ru\u0001\u0000"+
		"\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tv\u0001"+
		"\u0000\u0000\u0000us\u0001\u0000\u0000\u0000vw\u0006\u0013\u0000\u0000"+
		"w(\u0001\u0000\u0000\u0000xz\u0007\u0004\u0000\u0000yx\u0001\u0000\u0000"+
		"\u0000z{\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000"+
		"\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0006\u0014\u0000\u0000~*\u0001"+
		"\u0000\u0000\u0000\n\u0000=AFLNPks{\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}