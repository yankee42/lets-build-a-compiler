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
		T__21=1, T__20=2, T__19=3, T__18=4, T__17=5, T__16=6, T__15=7, T__14=8, 
		T__13=9, T__12=10, T__11=11, T__10=12, T__9=13, T__8=14, T__7=15, T__6=16, 
		T__5=17, T__4=18, T__3=19, T__2=20, T__1=21, T__0=22, IDENTIFIER=23, NUMBER=24, 
		WHITESPACE=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"')'", "'println('", "','", "'+'", "'-'", "'*'", "'('", "'if'", "'<'", 
		"'int'", "'='", "'return'", "';'", "'<='", "'&&'", "'||'", "'{'", "'>'", 
		"'/'", "'else'", "'}'", "'>='", "IDENTIFIER", "NUMBER", "WHITESPACE"
	};
	public static final String[] ruleNames = {
		"T__21", "T__20", "T__19", "T__18", "T__17", "T__16", "T__15", "T__14", 
		"T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", 
		"T__4", "T__3", "T__2", "T__1", "T__0", "IDENTIFIER", "NUMBER", "WHITESPACE"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u008a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\7\30z\n\30\f\30\16\30}\13\30"+
		"\3\31\6\31\u0080\n\31\r\31\16\31\u0081\3\32\6\32\u0085\n\32\r\32\16\32"+
		"\u0086\3\32\3\32\2\2\33\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\3\2\6\4\2C\\c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\u008c\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\3\65\3\2\2\2\5\67\3\2\2\2\7@\3\2\2\2\tB\3\2\2\2"+
		"\13D\3\2\2\2\rF\3\2\2\2\17H\3\2\2\2\21J\3\2\2\2\23M\3\2\2\2\25O\3\2\2"+
		"\2\27S\3\2\2\2\31U\3\2\2\2\33\\\3\2\2\2\35^\3\2\2\2\37a\3\2\2\2!d\3\2"+
		"\2\2#g\3\2\2\2%i\3\2\2\2\'k\3\2\2\2)m\3\2\2\2+r\3\2\2\2-t\3\2\2\2/w\3"+
		"\2\2\2\61\177\3\2\2\2\63\u0084\3\2\2\2\65\66\7+\2\2\66\4\3\2\2\2\678\7"+
		"r\2\289\7t\2\29:\7k\2\2:;\7p\2\2;<\7v\2\2<=\7n\2\2=>\7p\2\2>?\7*\2\2?"+
		"\6\3\2\2\2@A\7.\2\2A\b\3\2\2\2BC\7-\2\2C\n\3\2\2\2DE\7/\2\2E\f\3\2\2\2"+
		"FG\7,\2\2G\16\3\2\2\2HI\7*\2\2I\20\3\2\2\2JK\7k\2\2KL\7h\2\2L\22\3\2\2"+
		"\2MN\7>\2\2N\24\3\2\2\2OP\7k\2\2PQ\7p\2\2QR\7v\2\2R\26\3\2\2\2ST\7?\2"+
		"\2T\30\3\2\2\2UV\7t\2\2VW\7g\2\2WX\7v\2\2XY\7w\2\2YZ\7t\2\2Z[\7p\2\2["+
		"\32\3\2\2\2\\]\7=\2\2]\34\3\2\2\2^_\7>\2\2_`\7?\2\2`\36\3\2\2\2ab\7(\2"+
		"\2bc\7(\2\2c \3\2\2\2de\7~\2\2ef\7~\2\2f\"\3\2\2\2gh\7}\2\2h$\3\2\2\2"+
		"ij\7@\2\2j&\3\2\2\2kl\7\61\2\2l(\3\2\2\2mn\7g\2\2no\7n\2\2op\7u\2\2pq"+
		"\7g\2\2q*\3\2\2\2rs\7\177\2\2s,\3\2\2\2tu\7@\2\2uv\7?\2\2v.\3\2\2\2w{"+
		"\t\2\2\2xz\t\3\2\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\60\3\2\2\2"+
		"}{\3\2\2\2~\u0080\t\4\2\2\177~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\177\3"+
		"\2\2\2\u0081\u0082\3\2\2\2\u0082\62\3\2\2\2\u0083\u0085\t\5\2\2\u0084"+
		"\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2"+
		"\2\2\u0087\u0088\3\2\2\2\u0088\u0089\b\32\2\2\u0089\64\3\2\2\2\6\2{\u0081"+
		"\u0086\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}