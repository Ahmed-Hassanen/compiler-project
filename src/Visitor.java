public class Visitor extends JavaCodeBaseVisitor<String>{

    int blockNumber = 0;



    @Override
    public String visitCodeBlock(JavaCodeParser.CodeBlockContext ctx) {
        String result = super.visitCodeBlock(ctx);
        blockNumber++;
        System.out.println("// block number " + blockNumber);
        System.out.println(ctx.getText());
        return result;
    }
    @Override
    public String visitString(JavaCodeParser.StringContext ctx) {
        return ctx.getText();
    }


}