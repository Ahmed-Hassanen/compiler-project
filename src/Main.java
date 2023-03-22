import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{

        System.out.print("Enter Java file path: ");
        Scanner sc=new Scanner(System.in);
        String fileName=sc.nextLine();

        File file=new File(fileName);
        FileInputStream fis=null;
        fis=new FileInputStream(file);

        ANTLRInputStream input = new ANTLRInputStream(fis);
        JavaLexer lexer = new JavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);
        ParseTree tree = parser.compilationUnit();
        TokenStreamRewriter rewriter=new TokenStreamRewriter(tokens);
        ParseTreeWalker walker=new ParseTreeWalker();
        walker.walk(new newListener(rewriter),tree);

        System.out.println(rewriter.getText());
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.java"));
        writer.write(rewriter.getText());
        writer.close();

    }
}