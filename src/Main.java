import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        // Create an input stream from a Java file
        FileInputStream inputStream = new FileInputStream("HelloWorld.java");

        // Create a CharStream that reads from the input stream
        CharStream charStream = CharStreams.fromStream(inputStream);

        // Create a lexer that reads from the CharStream
        JavaCodeLexer lexer = new JavaCodeLexer(charStream);

        // Create a token stream from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create a parser that reads from the token stream
        JavaCodeParser parser = new JavaCodeParser(tokens);

        // Parse the input to generate a parse tree
        ParseTree tree = parser.parseJavaCode();
Visitor l=new Visitor();
        l.visit(tree);
        // Print the original input code
//        System.out.println(charStream.toString());
    }
}
