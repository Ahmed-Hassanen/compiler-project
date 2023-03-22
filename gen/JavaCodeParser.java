// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class JavaCodeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, Whitespace=3, Invalid=4, Any=5;
	public static final int
		RULE_compilationUnit = 0, RULE_string = 1, RULE_codeBlock = 2, RULE_parseJavaCode = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "string", "codeBlock", "parseJavaCode"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "Whitespace", "Invalid", "Any"
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JavaCodeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompilationUnitContext extends ParserRuleContext {
		public List<StringContext> string() {
			return getRuleContexts(StringContext.class);
		}
		public StringContext string(int i) {
			return getRuleContext(StringContext.class,i);
		}
		public List<CodeBlockContext> codeBlock() {
			return getRuleContexts(CodeBlockContext.class);
		}
		public CodeBlockContext codeBlock(int i) {
			return getRuleContext(CodeBlockContext.class,i);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaCodeListener ) ((JavaCodeListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaCodeListener ) ((JavaCodeListener)listener).exitCompilationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaCodeVisitor ) return ((JavaCodeVisitor<? extends T>)visitor).visitCompilationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(10);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Any:
					{
					setState(8);
					string();
					}
					break;
				case T__0:
					{
					setState(9);
					codeBlock();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(12); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 || _la==Any );
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
	public static class StringContext extends ParserRuleContext {
		public List<TerminalNode> Any() { return getTokens(JavaCodeParser.Any); }
		public TerminalNode Any(int i) {
			return getToken(JavaCodeParser.Any, i);
		}
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaCodeListener ) ((JavaCodeListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaCodeListener ) ((JavaCodeListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaCodeVisitor ) return ((JavaCodeVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_string);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(15); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(14);
					match(Any);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(17); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
	public static class CodeBlockContext extends ParserRuleContext {
		public List<StringContext> string() {
			return getRuleContexts(StringContext.class);
		}
		public StringContext string(int i) {
			return getRuleContext(StringContext.class,i);
		}
		public CodeBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaCodeListener ) ((JavaCodeListener)listener).enterCodeBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaCodeListener ) ((JavaCodeListener)listener).exitCodeBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaCodeVisitor ) return ((JavaCodeVisitor<? extends T>)visitor).visitCodeBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeBlockContext codeBlock() throws RecognitionException {
		CodeBlockContext _localctx = new CodeBlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_codeBlock);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			match(T__0);
			setState(24);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(22);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						setState(20);
						string();
						}
						break;
					case 2:
						{
						setState(21);
						_la = _input.LA(1);
						if ( _la <= 0 || (_la==T__0 || _la==T__1) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(26);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(27);
				match(T__1);
				}
			}

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
	public static class ParseJavaCodeContext extends ParserRuleContext {
		public CompilationUnitContext compilationUnit() {
			return getRuleContext(CompilationUnitContext.class,0);
		}
		public ParseJavaCodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseJavaCode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaCodeListener ) ((JavaCodeListener)listener).enterParseJavaCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaCodeListener ) ((JavaCodeListener)listener).exitParseJavaCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaCodeVisitor ) return ((JavaCodeVisitor<? extends T>)visitor).visitParseJavaCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseJavaCodeContext parseJavaCode() throws RecognitionException {
		ParseJavaCodeContext _localctx = new ParseJavaCodeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parseJavaCode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			compilationUnit();
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

	public static final String _serializedATN =
		"\u0004\u0001\u0005!\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000\u0004"+
		"\u0000\u000b\b\u0000\u000b\u0000\f\u0000\f\u0001\u0001\u0004\u0001\u0010"+
		"\b\u0001\u000b\u0001\f\u0001\u0011\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002\u0017\b\u0002\n\u0002\f\u0002\u001a\t\u0002\u0001\u0002\u0003"+
		"\u0002\u001d\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0000\u0000\u0004"+
		"\u0000\u0002\u0004\u0006\u0000\u0001\u0001\u0000\u0001\u0002\"\u0000\n"+
		"\u0001\u0000\u0000\u0000\u0002\u000f\u0001\u0000\u0000\u0000\u0004\u0013"+
		"\u0001\u0000\u0000\u0000\u0006\u001e\u0001\u0000\u0000\u0000\b\u000b\u0003"+
		"\u0002\u0001\u0000\t\u000b\u0003\u0004\u0002\u0000\n\b\u0001\u0000\u0000"+
		"\u0000\n\t\u0001\u0000\u0000\u0000\u000b\f\u0001\u0000\u0000\u0000\f\n"+
		"\u0001\u0000\u0000\u0000\f\r\u0001\u0000\u0000\u0000\r\u0001\u0001\u0000"+
		"\u0000\u0000\u000e\u0010\u0005\u0005\u0000\u0000\u000f\u000e\u0001\u0000"+
		"\u0000\u0000\u0010\u0011\u0001\u0000\u0000\u0000\u0011\u000f\u0001\u0000"+
		"\u0000\u0000\u0011\u0012\u0001\u0000\u0000\u0000\u0012\u0003\u0001\u0000"+
		"\u0000\u0000\u0013\u0018\u0005\u0001\u0000\u0000\u0014\u0017\u0003\u0002"+
		"\u0001\u0000\u0015\u0017\b\u0000\u0000\u0000\u0016\u0014\u0001\u0000\u0000"+
		"\u0000\u0016\u0015\u0001\u0000\u0000\u0000\u0017\u001a\u0001\u0000\u0000"+
		"\u0000\u0018\u0016\u0001\u0000\u0000\u0000\u0018\u0019\u0001\u0000\u0000"+
		"\u0000\u0019\u001c\u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000"+
		"\u0000\u001b\u001d\u0005\u0002\u0000\u0000\u001c\u001b\u0001\u0000\u0000"+
		"\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d\u0005\u0001\u0000\u0000"+
		"\u0000\u001e\u001f\u0003\u0000\u0000\u0000\u001f\u0007\u0001\u0000\u0000"+
		"\u0000\u0006\n\f\u0011\u0016\u0018\u001c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}