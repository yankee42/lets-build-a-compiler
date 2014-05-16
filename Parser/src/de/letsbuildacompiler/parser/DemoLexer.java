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
		T__19=1, T__18=2, T__17=3, T__16=4, T__15=5, T__14=6, T__13=7, T__12=8, 
		T__11=9, T__10=10, T__9=11, T__8=12, T__7=13, T__6=14, T__5=15, T__4=16, 
		T__3=17, T__2=18, T__1=19, T__0=20, IDENTIFIER=21, NUMBER=22, WHITESPACE=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"')'", "'println('", "','", "'+'", "'-'", "'*'", "'('", "'if'", "'<'", 
		"'int'", "'='", "'return'", "';'", "'<='", "'{'", "'>'", "'/'", "'else'", 
		"'}'", "'>='", "IDENTIFIER", "NUMBER", "WHITESPACE"
	};
	public static final String[] ruleNames = {
		"T__19", "T__18", "T__17", "T__16", "T__15", "T__14", "T__13", "T__12", 
		"T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", 
		"T__2", "T__1", "T__0", "IDENTIFIER", "NUMBER", "WHITESPACE"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\31\u0080\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\7\26p\n\26"+
		"\f\26\16\26s\13\26\3\27\6\27v\n\27\r\27\16\27w\3\30\6\30{\n\30\r\30\16"+
		"\30|\3\30\3\30\2\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\3\2\6\4\2"+
		"C\\c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\u0082\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\5\63"+
		"\3\2\2\2\7<\3\2\2\2\t>\3\2\2\2\13@\3\2\2\2\rB\3\2\2\2\17D\3\2\2\2\21F"+
		"\3\2\2\2\23I\3\2\2\2\25K\3\2\2\2\27O\3\2\2\2\31Q\3\2\2\2\33X\3\2\2\2\35"+
		"Z\3\2\2\2\37]\3\2\2\2!_\3\2\2\2#a\3\2\2\2%c\3\2\2\2\'h\3\2\2\2)j\3\2\2"+
		"\2+m\3\2\2\2-u\3\2\2\2/z\3\2\2\2\61\62\7+\2\2\62\4\3\2\2\2\63\64\7r\2"+
		"\2\64\65\7t\2\2\65\66\7k\2\2\66\67\7p\2\2\678\7v\2\289\7n\2\29:\7p\2\2"+
		":;\7*\2\2;\6\3\2\2\2<=\7.\2\2=\b\3\2\2\2>?\7-\2\2?\n\3\2\2\2@A\7/\2\2"+
		"A\f\3\2\2\2BC\7,\2\2C\16\3\2\2\2DE\7*\2\2E\20\3\2\2\2FG\7k\2\2GH\7h\2"+
		"\2H\22\3\2\2\2IJ\7>\2\2J\24\3\2\2\2KL\7k\2\2LM\7p\2\2MN\7v\2\2N\26\3\2"+
		"\2\2OP\7?\2\2P\30\3\2\2\2QR\7t\2\2RS\7g\2\2ST\7v\2\2TU\7w\2\2UV\7t\2\2"+
		"VW\7p\2\2W\32\3\2\2\2XY\7=\2\2Y\34\3\2\2\2Z[\7>\2\2[\\\7?\2\2\\\36\3\2"+
		"\2\2]^\7}\2\2^ \3\2\2\2_`\7@\2\2`\"\3\2\2\2ab\7\61\2\2b$\3\2\2\2cd\7g"+
		"\2\2de\7n\2\2ef\7u\2\2fg\7g\2\2g&\3\2\2\2hi\7\177\2\2i(\3\2\2\2jk\7@\2"+
		"\2kl\7?\2\2l*\3\2\2\2mq\t\2\2\2np\t\3\2\2on\3\2\2\2ps\3\2\2\2qo\3\2\2"+
		"\2qr\3\2\2\2r,\3\2\2\2sq\3\2\2\2tv\t\4\2\2ut\3\2\2\2vw\3\2\2\2wu\3\2\2"+
		"\2wx\3\2\2\2x.\3\2\2\2y{\t\5\2\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2"+
		"\2}~\3\2\2\2~\177\b\30\2\2\177\60\3\2\2\2\6\2qw|\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}