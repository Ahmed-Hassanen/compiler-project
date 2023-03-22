// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JavaCodeParser}.
 */
public interface JavaCodeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JavaCodeParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(JavaCodeParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaCodeParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(JavaCodeParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaCodeParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(JavaCodeParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaCodeParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(JavaCodeParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaCodeParser#codeBlock}.
	 * @param ctx the parse tree
	 */
	void enterCodeBlock(JavaCodeParser.CodeBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaCodeParser#codeBlock}.
	 * @param ctx the parse tree
	 */
	void exitCodeBlock(JavaCodeParser.CodeBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaCodeParser#parseJavaCode}.
	 * @param ctx the parse tree
	 */
	void enterParseJavaCode(JavaCodeParser.ParseJavaCodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaCodeParser#parseJavaCode}.
	 * @param ctx the parse tree
	 */
	void exitParseJavaCode(JavaCodeParser.ParseJavaCodeContext ctx);
}