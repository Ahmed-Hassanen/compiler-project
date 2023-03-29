import org.antlr.v4.runtime.TokenStreamRewriter;

public class newListener extends JavaParserBaseListener {
    TokenStreamRewriter rewriter;
    private int blockNumber = 1;

    public newListener(TokenStreamRewriter rewriter) {
        this.rewriter = rewriter;
    }
    @Override
    public void enterCompilationUnit(JavaParser.CompilationUnitContext ctx) {
        rewriter.insertBefore(ctx.getStart(),"import java.io.FileWriter;\n");
    }
    @Override
    public void enterBlock(JavaParser.BlockContext ctx) {
        if(blockNumber==1) {
            rewriter.insertAfter(ctx.getStart(),
                "\n \t \tFileWriter outpt" + blockNumber + " = new FileWriter(\"output.txt\");\n" +
                    "        outpt" + blockNumber + ".write(\"Block number \" +" + blockNumber + "+ \" is visited\\n\");\n" +
                    "        outpt" + blockNumber + ".close();\n");
        }
        else{
            rewriter.insertAfter(ctx.getStart(),
                "\n \t \tFileWriter outpt" + blockNumber + " = new FileWriter(\"output.txt\", true);\n" +
                    "        outpt" + blockNumber + ".write(\"Block number \" +" + blockNumber + "+ \" is visited\\n\");\n" +
                    "        outpt" + blockNumber + ".close();\n");
        }
            blockNumber++;
    }
}

