// Generated from Demo.g4 by ANTLR 4.2
package de.letsbuildacompiler.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DemoLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__15=1, T__14=2, T__13=3, T__12=4, T__11=5, T__10=6, T__9=7, T__8=8, 
		T__7=9, T__6=10, T__5=11, T__4=12, T__3=13, T__2=14, T__1=15, T__0=16, 
		IDENTIFIER=17, NUMBER=18, WHITESPACE=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"')'", "'println('", "','", "'+'", "'-'", "'*'", "'('", "'if'", "'int'", 
		"'='", "'return'", "';'", "'{'", "'/'", "'else'", "'}'", "IDENTIFIER", 
		"NUMBER", "WHITESPACE"
	};
	public static final String[] ruleNames = {
		"T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", 
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "IDENTIFIER", 
		"NUMBER", "WHITESPACE"
	};


	public DemoLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Demo.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\25n\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\22\3\22\7\22^\n\22\f\22\16\22a\13\22\3\23"+
		"\6\23d\n\23\r\23\16\23e\3\24\6\24i\n\24\r\24\16\24j\3\24\3\24\2\2\25\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25\3\2\6\4\2C\\c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17"+
		"\"\"p\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r"+
		"\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2"+
		"\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2"+
		"#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5+\3\2\2\2\7\64\3\2\2\2\t"+
		"\66\3\2\2\2\138\3\2\2\2\r:\3\2\2\2\17<\3\2\2\2\21>\3\2\2\2\23A\3\2\2\2"+
		"\25E\3\2\2\2\27G\3\2\2\2\31N\3\2\2\2\33P\3\2\2\2\35R\3\2\2\2\37T\3\2\2"+
		"\2!Y\3\2\2\2#[\3\2\2\2%c\3\2\2\2\'h\3\2\2\2)*\7+\2\2*\4\3\2\2\2+,\7r\2"+
		"\2,-\7t\2\2-.\7k\2\2./\7p\2\2/\60\7v\2\2\60\61\7n\2\2\61\62\7p\2\2\62"+
		"\63\7*\2\2\63\6\3\2\2\2\64\65\7.\2\2\65\b\3\2\2\2\66\67\7-\2\2\67\n\3"+
		"\2\2\289\7/\2\29\f\3\2\2\2:;\7,\2\2;\16\3\2\2\2<=\7*\2\2=\20\3\2\2\2>"+
		"?\7k\2\2?@\7h\2\2@\22\3\2\2\2AB\7k\2\2BC\7p\2\2CD\7v\2\2D\24\3\2\2\2E"+
		"F\7?\2\2F\26\3\2\2\2GH\7t\2\2HI\7g\2\2IJ\7v\2\2JK\7w\2\2KL\7t\2\2LM\7"+
		"p\2\2M\30\3\2\2\2NO\7=\2\2O\32\3\2\2\2PQ\7}\2\2Q\34\3\2\2\2RS\7\61\2\2"+
		"S\36\3\2\2\2TU\7g\2\2UV\7n\2\2VW\7u\2\2WX\7g\2\2X \3\2\2\2YZ\7\177\2\2"+
		"Z\"\3\2\2\2[_\t\2\2\2\\^\t\3\2\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2"+
		"\2\2`$\3\2\2\2a_\3\2\2\2bd\t\4\2\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2"+
		"\2\2f&\3\2\2\2gi\t\5\2\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3\2\2\2kl\3\2"+
		"\2\2lm\b\24\2\2m(\3\2\2\2\6\2_ej\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}