public class Visitor extends JavaCodeBaseVisitor<String>{

    int blockNumber = 0;



    @Override
    public String visitCodeBlock(JavaCodeParser.CodeBlockContext ctx) {
        blockNumber++;
        String result = super.visitCodeBlock(ctx);
        char firstChar = ctx.getText().charAt(0);
        String remainingText = ctx.getText().substring(1);
String comment = "// block number " + blockNumber;

//        System.out.println("// block number " + blockNumber);

        System.out.println(firstChar+comment+remainingText);
        return result;
    }
    @Override
    public String visitString(JavaCodeParser.StringContext ctx) {
        return ctx.getText();
    }


}