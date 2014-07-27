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
		T__22=1, T__21=2, T__20=3, T__19=4, T__18=5, T__17=6, T__16=7, T__15=8, 
		T__14=9, T__13=10, T__12=11, T__11=12, T__10=13, T__9=14, T__8=15, T__7=16, 
		T__6=17, T__5=18, T__4=19, T__3=20, T__2=21, T__1=22, T__0=23, IDENTIFIER=24, 
		NUMBER=25, WHITESPACE=26, STRING=27;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'print('", "')'", "'println('", "','", "'+'", "'-'", "'*'", "'('", "'if'", 
		"'<'", "'int'", "'='", "'return'", "';'", "'<='", "'&&'", "'||'", "'{'", 
		"'>'", "'/'", "'else'", "'}'", "'>='", "IDENTIFIER", "NUMBER", "WHITESPACE", 
		"STRING"
	};
	public static final String[] ruleNames = {
		"T__22", "T__21", "T__20", "T__19", "T__18", "T__17", "T__16", "T__15", 
		"T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", 
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "IDENTIFIER", "NUMBER", 
		"WHITESPACE", "STRING"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\35\u009e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\30\3\31\3\31\7\31\u0085\n\31\f\31\16\31\u0088\13\31\3\32"+
		"\6\32\u008b\n\32\r\32\16\32\u008c\3\33\6\33\u0090\n\33\r\33\16\33\u0091"+
		"\3\33\3\33\3\34\3\34\7\34\u0098\n\34\f\34\16\34\u009b\13\34\3\34\3\34"+
		"\3\u0099\2\35\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34"+
		"\67\35\3\2\6\4\2C\\c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\u00a1\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\39\3\2\2\2\5@\3\2"+
		"\2\2\7B\3\2\2\2\tK\3\2\2\2\13M\3\2\2\2\rO\3\2\2\2\17Q\3\2\2\2\21S\3\2"+
		"\2\2\23U\3\2\2\2\25X\3\2\2\2\27Z\3\2\2\2\31^\3\2\2\2\33`\3\2\2\2\35g\3"+
		"\2\2\2\37i\3\2\2\2!l\3\2\2\2#o\3\2\2\2%r\3\2\2\2\'t\3\2\2\2)v\3\2\2\2"+
		"+x\3\2\2\2-}\3\2\2\2/\177\3\2\2\2\61\u0082\3\2\2\2\63\u008a\3\2\2\2\65"+
		"\u008f\3\2\2\2\67\u0095\3\2\2\29:\7r\2\2:;\7t\2\2;<\7k\2\2<=\7p\2\2=>"+
		"\7v\2\2>?\7*\2\2?\4\3\2\2\2@A\7+\2\2A\6\3\2\2\2BC\7r\2\2CD\7t\2\2DE\7"+
		"k\2\2EF\7p\2\2FG\7v\2\2GH\7n\2\2HI\7p\2\2IJ\7*\2\2J\b\3\2\2\2KL\7.\2\2"+
		"L\n\3\2\2\2MN\7-\2\2N\f\3\2\2\2OP\7/\2\2P\16\3\2\2\2QR\7,\2\2R\20\3\2"+
		"\2\2ST\7*\2\2T\22\3\2\2\2UV\7k\2\2VW\7h\2\2W\24\3\2\2\2XY\7>\2\2Y\26\3"+
		"\2\2\2Z[\7k\2\2[\\\7p\2\2\\]\7v\2\2]\30\3\2\2\2^_\7?\2\2_\32\3\2\2\2`"+
		"a\7t\2\2ab\7g\2\2bc\7v\2\2cd\7w\2\2de\7t\2\2ef\7p\2\2f\34\3\2\2\2gh\7"+
		"=\2\2h\36\3\2\2\2ij\7>\2\2jk\7?\2\2k \3\2\2\2lm\7(\2\2mn\7(\2\2n\"\3\2"+
		"\2\2op\7~\2\2pq\7~\2\2q$\3\2\2\2rs\7}\2\2s&\3\2\2\2tu\7@\2\2u(\3\2\2\2"+
		"vw\7\61\2\2w*\3\2\2\2xy\7g\2\2yz\7n\2\2z{\7u\2\2{|\7g\2\2|,\3\2\2\2}~"+
		"\7\177\2\2~.\3\2\2\2\177\u0080\7@\2\2\u0080\u0081\7?\2\2\u0081\60\3\2"+
		"\2\2\u0082\u0086\t\2\2\2\u0083\u0085\t\3\2\2\u0084\u0083\3\2\2\2\u0085"+
		"\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\62\3\2\2"+
		"\2\u0088\u0086\3\2\2\2\u0089\u008b\t\4\2\2\u008a\u0089\3\2\2\2\u008b\u008c"+
		"\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\64\3\2\2\2\u008e"+
		"\u0090\t\5\2\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u008f\3\2"+
		"\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\b\33\2\2\u0094"+
		"\66\3\2\2\2\u0095\u0099\7$\2\2\u0096\u0098\13\2\2\2\u0097\u0096\3\2\2"+
		"\2\u0098\u009b\3\2\2\2\u0099\u009a\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009c"+
		"\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009d\7$\2\2\u009d8\3\2\2\2\7\2\u0086"+
		"\u008c\u0091\u0099\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}