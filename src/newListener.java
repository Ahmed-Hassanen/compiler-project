import org.antlr.v4.runtime.TokenStreamRewriter;


public class newListener extends JavaParserBaseListener {
    TokenStreamRewriter rewriter;
    private int blockNumber = 1;

    public newListener(TokenStreamRewriter rewriter) {
        this.rewriter = rewriter;
        this.blockNumber = 1;
    }

    @Override
    public void enterBlock(JavaParser.BlockContext ctx) {

                rewriter.insertAfter(ctx.getStart(),"\nFileWriter outpt"+blockNumber+" = new FileWriter(\"output.txt\", true);\n" +
                        "        outpt"+blockNumber+".write(\"Block number \" +"+blockNumber +"+ \" is visited\\n\");\n" +
                        "        outpt"+blockNumber+".close();\n");

        blockNumber++;
    }

}

