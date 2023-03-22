// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JavaCodeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JavaCodeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JavaCodeParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(JavaCodeParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaCodeParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(JavaCodeParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaCodeParser#codeBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeBlock(JavaCodeParser.CodeBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaCodeParser#parseJavaCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParseJavaCode(JavaCodeParser.ParseJavaCodeContext ctx);
}