// Generated from C:/Users/HP 840G4/IdeaProjects/lab1/src/main/antlr4/imports\Calculator.g4 by ANTLR 4.10.1
package antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculatorLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, VARIABLE=4, CYCLE=5, OPERAND=6, INT=7, DOUBLE=8, 
		ADD=9, MINUS=10, MUL=11, DIV=12, INT_DIV=13, MOD=14, POW=15, INC=16, DEC=17, 
		PI_CONSTANT=18, EXP_CONSTANT=19, NEWLINE=20, WS=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "VARIABLE", "CYCLE", "OPERAND", "INT", "DOUBLE", 
			"ADD", "MINUS", "MUL", "DIV", "INT_DIV", "MOD", "POW", "INC", "DEC", 
			"PI_CONSTANT", "EXP_CONSTANT", "NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "' = '", "'('", "')'", null, "'???'", null, null, null, "'+'", 
			"'-'", "'*'", "'/'", null, null, "'^'", null, null, null, null, null, 
			"' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "VARIABLE", "CYCLE", "OPERAND", "INT", "DOUBLE", 
			"ADD", "MINUS", "MUL", "DIV", "INT_DIV", "MOD", "POW", "INC", "DEC", 
			"PI_CONSTANT", "EXP_CONSTANT", "NEWLINE", "WS"
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


	public CalculatorLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calculator.g4"; }

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
		"\u0004\u0000\u0015\u00bc\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0004\u00035\b\u0003\u000b\u0003"+
		"\f\u00036\u0001\u0003\u0004\u0003:\b\u0003\u000b\u0003\f\u0003;\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0003"+
		"\u0005D\b\u0005\u0001\u0006\u0005\u0006G\b\u0006\n\u0006\f\u0006J\t\u0006"+
		"\u0001\u0006\u0004\u0006M\b\u0006\u000b\u0006\f\u0006N\u0001\u0006\u0001"+
		"\u0006\u0004\u0006S\b\u0006\u000b\u0006\f\u0006T\u0005\u0006W\b\u0006"+
		"\n\u0006\f\u0006Z\t\u0006\u0001\u0007\u0005\u0007]\b\u0007\n\u0007\f\u0007"+
		"`\t\u0007\u0001\u0007\u0004\u0007c\b\u0007\u000b\u0007\f\u0007d\u0001"+
		"\u0007\u0001\u0007\u0004\u0007i\b\u0007\u000b\u0007\f\u0007j\u0005\u0007"+
		"m\b\u0007\n\u0007\f\u0007p\t\u0007\u0001\u0007\u0001\u0007\u0004\u0007"+
		"t\b\u0007\u000b\u0007\f\u0007u\u0001\u0007\u0001\u0007\u0004\u0007z\b"+
		"\u0007\u000b\u0007\f\u0007{\u0005\u0007~\b\u0007\n\u0007\f\u0007\u0081"+
		"\t\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0091\b"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0099\b\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u00a3\b\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00ab\b\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00b1\b\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0000\u0000\u0015\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015\u0001\u0000\u0004\u0001"+
		"\u0000AZ\u0001\u000009\u0002\u0000EEee\u0002\u0000\t\n\r\r\u00ce\u0000"+
		"\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000"+
		"\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000"+
		"\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r"+
		"\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0001+\u0001\u0000\u0000\u0000\u0003/\u0001\u0000\u0000\u0000\u00051"+
		"\u0001\u0000\u0000\u0000\u00074\u0001\u0000\u0000\u0000\t=\u0001\u0000"+
		"\u0000\u0000\u000bC\u0001\u0000\u0000\u0000\rH\u0001\u0000\u0000\u0000"+
		"\u000f^\u0001\u0000\u0000\u0000\u0011\u0082\u0001\u0000\u0000\u0000\u0013"+
		"\u0084\u0001\u0000\u0000\u0000\u0015\u0086\u0001\u0000\u0000\u0000\u0017"+
		"\u0088\u0001\u0000\u0000\u0000\u0019\u0090\u0001\u0000\u0000\u0000\u001b"+
		"\u0098\u0001\u0000\u0000\u0000\u001d\u009a\u0001\u0000\u0000\u0000\u001f"+
		"\u00a2\u0001\u0000\u0000\u0000!\u00aa\u0001\u0000\u0000\u0000#\u00b0\u0001"+
		"\u0000\u0000\u0000%\u00b2\u0001\u0000\u0000\u0000\'\u00b4\u0001\u0000"+
		"\u0000\u0000)\u00b8\u0001\u0000\u0000\u0000+,\u0005 \u0000\u0000,-\u0005"+
		"=\u0000\u0000-.\u0005 \u0000\u0000.\u0002\u0001\u0000\u0000\u0000/0\u0005"+
		"(\u0000\u00000\u0004\u0001\u0000\u0000\u000012\u0005)\u0000\u00002\u0006"+
		"\u0001\u0000\u0000\u000035\u0007\u0000\u0000\u000043\u0001\u0000\u0000"+
		"\u000056\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000067\u0001\u0000"+
		"\u0000\u000079\u0001\u0000\u0000\u00008:\u0007\u0001\u0000\u000098\u0001"+
		"\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000"+
		";<\u0001\u0000\u0000\u0000<\b\u0001\u0000\u0000\u0000=>\u0005?\u0000\u0000"+
		">?\u0005?\u0000\u0000?@\u0005?\u0000\u0000@\n\u0001\u0000\u0000\u0000"+
		"AD\u0003\r\u0006\u0000BD\u0003\u000f\u0007\u0000CA\u0001\u0000\u0000\u0000"+
		"CB\u0001\u0000\u0000\u0000D\f\u0001\u0000\u0000\u0000EG\u0005-\u0000\u0000"+
		"FE\u0001\u0000\u0000\u0000GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000"+
		"\u0000HI\u0001\u0000\u0000\u0000IL\u0001\u0000\u0000\u0000JH\u0001\u0000"+
		"\u0000\u0000KM\u0007\u0001\u0000\u0000LK\u0001\u0000\u0000\u0000MN\u0001"+
		"\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000"+
		"OX\u0001\u0000\u0000\u0000PR\u0005_\u0000\u0000QS\u0007\u0001\u0000\u0000"+
		"RQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000"+
		"\u0000TU\u0001\u0000\u0000\u0000UW\u0001\u0000\u0000\u0000VP\u0001\u0000"+
		"\u0000\u0000WZ\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000XY\u0001"+
		"\u0000\u0000\u0000Y\u000e\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000"+
		"\u0000[]\u0005-\u0000\u0000\\[\u0001\u0000\u0000\u0000]`\u0001\u0000\u0000"+
		"\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_b\u0001\u0000"+
		"\u0000\u0000`^\u0001\u0000\u0000\u0000ac\u0007\u0001\u0000\u0000ba\u0001"+
		"\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000"+
		"de\u0001\u0000\u0000\u0000en\u0001\u0000\u0000\u0000fh\u0005_\u0000\u0000"+
		"gi\u0007\u0001\u0000\u0000hg\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000"+
		"\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000km\u0001\u0000"+
		"\u0000\u0000lf\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000\u0000nl\u0001"+
		"\u0000\u0000\u0000no\u0001\u0000\u0000\u0000oq\u0001\u0000\u0000\u0000"+
		"pn\u0001\u0000\u0000\u0000qs\u0005.\u0000\u0000rt\u0007\u0001\u0000\u0000"+
		"sr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000us\u0001\u0000\u0000"+
		"\u0000uv\u0001\u0000\u0000\u0000v\u007f\u0001\u0000\u0000\u0000wy\u0005"+
		"_\u0000\u0000xz\u0007\u0001\u0000\u0000yx\u0001\u0000\u0000\u0000z{\u0001"+
		"\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000"+
		"|~\u0001\u0000\u0000\u0000}w\u0001\u0000\u0000\u0000~\u0081\u0001\u0000"+
		"\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000"+
		"\u0000\u0080\u0010\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000"+
		"\u0000\u0082\u0083\u0005+\u0000\u0000\u0083\u0012\u0001\u0000\u0000\u0000"+
		"\u0084\u0085\u0005-\u0000\u0000\u0085\u0014\u0001\u0000\u0000\u0000\u0086"+
		"\u0087\u0005*\u0000\u0000\u0087\u0016\u0001\u0000\u0000\u0000\u0088\u0089"+
		"\u0005/\u0000\u0000\u0089\u0018\u0001\u0000\u0000\u0000\u008a\u008b\u0005"+
		"d\u0000\u0000\u008b\u008c\u0005i\u0000\u0000\u008c\u0091\u0005v\u0000"+
		"\u0000\u008d\u008e\u0005D\u0000\u0000\u008e\u008f\u0005I\u0000\u0000\u008f"+
		"\u0091\u0005V\u0000\u0000\u0090\u008a\u0001\u0000\u0000\u0000\u0090\u008d"+
		"\u0001\u0000\u0000\u0000\u0091\u001a\u0001\u0000\u0000\u0000\u0092\u0093"+
		"\u0005m\u0000\u0000\u0093\u0094\u0005o\u0000\u0000\u0094\u0099\u0005d"+
		"\u0000\u0000\u0095\u0096\u0005M\u0000\u0000\u0096\u0097\u0005O\u0000\u0000"+
		"\u0097\u0099\u0005D\u0000\u0000\u0098\u0092\u0001\u0000\u0000\u0000\u0098"+
		"\u0095\u0001\u0000\u0000\u0000\u0099\u001c\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0005^\u0000\u0000\u009b\u001e\u0001\u0000\u0000\u0000\u009c\u009d"+
		"\u0005i\u0000\u0000\u009d\u009e\u0005n\u0000\u0000\u009e\u00a3\u0005c"+
		"\u0000\u0000\u009f\u00a0\u0005I\u0000\u0000\u00a0\u00a1\u0005N\u0000\u0000"+
		"\u00a1\u00a3\u0005C\u0000\u0000\u00a2\u009c\u0001\u0000\u0000\u0000\u00a2"+
		"\u009f\u0001\u0000\u0000\u0000\u00a3 \u0001\u0000\u0000\u0000\u00a4\u00a5"+
		"\u0005d\u0000\u0000\u00a5\u00a6\u0005e\u0000\u0000\u00a6\u00ab\u0005c"+
		"\u0000\u0000\u00a7\u00a8\u0005D\u0000\u0000\u00a8\u00a9\u0005E\u0000\u0000"+
		"\u00a9\u00ab\u0005C\u0000\u0000\u00aa\u00a4\u0001\u0000\u0000\u0000\u00aa"+
		"\u00a7\u0001\u0000\u0000\u0000\u00ab\"\u0001\u0000\u0000\u0000\u00ac\u00ad"+
		"\u0005P\u0000\u0000\u00ad\u00b1\u0005I\u0000\u0000\u00ae\u00af\u0005p"+
		"\u0000\u0000\u00af\u00b1\u0005i\u0000\u0000\u00b0\u00ac\u0001\u0000\u0000"+
		"\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b1$\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b3\u0007\u0002\u0000\u0000\u00b3&\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b5\u0007\u0003\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b7\u0006\u0013\u0000\u0000\u00b7(\u0001\u0000\u0000\u0000\u00b8\u00b9"+
		"\u0005 \u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bb\u0006"+
		"\u0014\u0000\u0000\u00bb*\u0001\u0000\u0000\u0000\u0014\u00006;CHNTX^"+
		"djnu{\u007f\u0090\u0098\u00a2\u00aa\u00b0\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}