import java.io.FileWriter;
import java.io.IOException;

public class Visitor extends JavaCodeBaseVisitor<String>{

    int blockNumber = 0;



    @Override
    public String visitCodeBlock(JavaCodeParser.CodeBlockContext ctx) {
        blockNumber++;

        char firstChar = ctx.getText().charAt(0);
        String remainingText = ctx.getText().substring(1);
String comment = "// block number " + blockNumber;
        String output = firstChar + comment + remainingText;
//        System.out.println("// block number " + blockNumber);
//        System.out.println(ctx.getText());

        System.out.println(firstChar+comment+remainingText);

        try {
            FileWriter writer = new FileWriter("output.java", true);
            writer.write(output + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}