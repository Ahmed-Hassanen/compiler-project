public class newListener extends JavaParserBaseListener{
    private int blockNumber = 1;
        @Override public void enterBlock(JavaParser.BlockContext ctx) {
            System.out.println("block "+blockNumber+"\n");
            System.out.println(ctx.getText());
            blockNumber++;
        }

    }

