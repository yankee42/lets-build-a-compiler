// Generated from Demo.g4 by ANTLR 4.2
package de.letsbuildacompiler.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DemoParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__3=1, T__2=2, T__1=3, T__0=4, ZAHL=5;
	public static final String[] tokenNames = {
		"<INVALID>", "')'", "'println('", "'+'", "';'", "ZAHL"
	};
	public static final int
		RULE_program = 0, RULE_addition = 1, RULE_println = 2;
	public static final String[] ruleNames = {
		"program", "addition", "println"
	};

	@Override
	public String getGrammarFileName() { return "Demo.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DemoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<PrintlnContext> println() {
			return getRuleContexts(PrintlnContext.class);
		}
		public PrintlnContext println(int i) {
			return getRuleContext(PrintlnContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DemoVisitor ) return ((DemoVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(6); println();
				setState(7); match(4);
				}
				}
				setState(11); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==2 );
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

	public static class AdditionContext extends ParserRuleContext {
		public AdditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addition; }
	 
		public AdditionContext() { }
		public void copyFrom(AdditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PlusContext extends AdditionContext {
		public AdditionContext links;
		public Token rechts;
		public TerminalNode ZAHL() { return getToken(DemoParser.ZAHL, 0); }
		public AdditionContext addition() {
			return getRuleContext(AdditionContext.class,0);
		}
		public PlusContext(AdditionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DemoVisitor ) return ((DemoVisitor<? extends T>)visitor).visitPlus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ZahlContext extends AdditionContext {
		public Token zahl;
		public TerminalNode ZAHL() { return getToken(DemoParser.ZAHL, 0); }
		public ZahlContext(AdditionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DemoVisitor ) return ((DemoVisitor<? extends T>)visitor).visitZahl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditionContext addition() throws RecognitionException {
		return addition(0);
	}

	private AdditionContext addition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditionContext _localctx = new AdditionContext(_ctx, _parentState);
		AdditionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_addition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ZahlContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(14); ((ZahlContext)_localctx).zahl = match(ZAHL);
			}
			_ctx.stop = _input.LT(-1);
			setState(21);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PlusContext(new AdditionContext(_parentctx, _parentState));
					((PlusContext)_localctx).links = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_addition);
					setState(16);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(17); match(3);
					setState(18); ((PlusContext)_localctx).rechts = match(ZAHL);
					}
					} 
				}
				setState(23);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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

	public static class PrintlnContext extends ParserRuleContext {
		public AdditionContext argument;
		public AdditionContext addition() {
			return getRuleContext(AdditionContext.class,0);
		}
		public PrintlnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_println; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DemoVisitor ) return ((DemoVisitor<? extends T>)visitor).visitPrintln(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintlnContext println() throws RecognitionException {
		PrintlnContext _localctx = new PrintlnContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_println);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24); match(2);
			setState(25); ((PrintlnContext)_localctx).argument = addition(0);
			setState(26); match(1);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1: return addition_sempred((AdditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean addition_sempred(AdditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\7\37\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\3\2\3\2\6\2\f\n\2\r\2\16\2\r\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\7\3\26\n\3\f\3\16\3\31\13\3\3\4\3\4\3\4\3\4\3\4\2\3\4\5\2\4\6\2\2\35"+
		"\2\13\3\2\2\2\4\17\3\2\2\2\6\32\3\2\2\2\b\t\5\6\4\2\t\n\7\6\2\2\n\f\3"+
		"\2\2\2\13\b\3\2\2\2\f\r\3\2\2\2\r\13\3\2\2\2\r\16\3\2\2\2\16\3\3\2\2\2"+
		"\17\20\b\3\1\2\20\21\7\7\2\2\21\27\3\2\2\2\22\23\f\4\2\2\23\24\7\5\2\2"+
		"\24\26\7\7\2\2\25\22\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2"+
		"\30\5\3\2\2\2\31\27\3\2\2\2\32\33\7\4\2\2\33\34\5\4\3\2\34\35\7\3\2\2"+
		"\35\7\3\2\2\2\4\r\27";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}