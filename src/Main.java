import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
public class Main {
    public static void main(String[] args) throws Exception{
        String fileName="test.java";
        FileInputStream is= new FileInputStream(fileName);
        ANTLRInputStream input = new ANTLRInputStream(is);
        JavaLexer lexer = new JavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);
        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker walker=new ParseTreeWalker();
        walker.walk(new newListener(),tree);
        //System.out.println(tree.toStringTree(parser));
    }
}