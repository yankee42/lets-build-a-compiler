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
		T__12=1, T__11=2, T__10=3, T__9=4, T__8=5, T__7=6, T__6=7, T__5=8, T__4=9, 
		T__3=10, T__2=11, T__1=12, T__0=13, IDENTIFIER=14, NUMBER=15, WHITESPACE=16;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'{'", "')'", "'println('", "'+'", "'*'", "'-'", "'('", "'/'", "'int'", 
		"'='", "'return'", "'}'", "';'", "IDENTIFIER", "NUMBER", "WHITESPACE"
	};
	public static final String[] ruleNames = {
		"T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", 
		"T__3", "T__2", "T__1", "T__0", "IDENTIFIER", "NUMBER", "WHITESPACE"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\22^\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b"+
		"\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\7\17N\n\17\f\17\16\17Q\13\17\3\20\6\20T\n\20"+
		"\r\20\16\20U\3\21\6\21Y\n\21\r\21\16\21Z\3\21\3\21\2\2\22\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22\3"+
		"\2\6\4\2C\\c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"`\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5%\3\2\2\2\7"+
		"\'\3\2\2\2\t\60\3\2\2\2\13\62\3\2\2\2\r\64\3\2\2\2\17\66\3\2\2\2\218\3"+
		"\2\2\2\23:\3\2\2\2\25>\3\2\2\2\27@\3\2\2\2\31G\3\2\2\2\33I\3\2\2\2\35"+
		"K\3\2\2\2\37S\3\2\2\2!X\3\2\2\2#$\7}\2\2$\4\3\2\2\2%&\7+\2\2&\6\3\2\2"+
		"\2\'(\7r\2\2()\7t\2\2)*\7k\2\2*+\7p\2\2+,\7v\2\2,-\7n\2\2-.\7p\2\2./\7"+
		"*\2\2/\b\3\2\2\2\60\61\7-\2\2\61\n\3\2\2\2\62\63\7,\2\2\63\f\3\2\2\2\64"+
		"\65\7/\2\2\65\16\3\2\2\2\66\67\7*\2\2\67\20\3\2\2\289\7\61\2\29\22\3\2"+
		"\2\2:;\7k\2\2;<\7p\2\2<=\7v\2\2=\24\3\2\2\2>?\7?\2\2?\26\3\2\2\2@A\7t"+
		"\2\2AB\7g\2\2BC\7v\2\2CD\7w\2\2DE\7t\2\2EF\7p\2\2F\30\3\2\2\2GH\7\177"+
		"\2\2H\32\3\2\2\2IJ\7=\2\2J\34\3\2\2\2KO\t\2\2\2LN\t\3\2\2ML\3\2\2\2NQ"+
		"\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\36\3\2\2\2QO\3\2\2\2RT\t\4\2\2SR\3\2\2\2"+
		"TU\3\2\2\2US\3\2\2\2UV\3\2\2\2V \3\2\2\2WY\t\5\2\2XW\3\2\2\2YZ\3\2\2\2"+
		"ZX\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\b\21\2\2]\"\3\2\2\2\6\2OUZ\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}