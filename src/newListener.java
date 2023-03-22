import org.antlr.v4.runtime.TokenStreamRewriter;

public class newListener extends JavaParserBaseListener {
    TokenStreamRewriter rewriter;

    public newListener(TokenStreamRewriter rewriter) {
        this.rewriter = rewriter;
    }

    private int blockNumber = 1;

    @Override
    public void enterBlock(JavaParser.BlockContext ctx) {
        rewriter.insertAfter(ctx.getStart(), "//Block " + blockNumber+"\n");
        blockNumber++;
    }

}