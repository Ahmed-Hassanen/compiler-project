import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

public class htmlGenerator extends JavaParserBaseListener {

    TokenStreamRewriter rewriter;
    TokenStreamRewriter rewriter2;
    int counter = 0;
    StringBuilder build = new StringBuilder("");

    public htmlGenerator(CommonTokenStream tokens) {
        rewriter = new TokenStreamRewriter(tokens);
        rewriter2 = new TokenStreamRewriter(tokens);
    }

    @Override
    public void enterCompilationUnit(JavaParser.CompilationUnitContext ctx) {
        rewriter.insertBefore(ctx.getStart().getTokenIndex(),
                " import java.io.PrintWriter;\n" + "import java.io.FileNotFoundException;\n");
    }

    @Override
    public void enterClassBody(JavaParser.ClassBodyContext ctx) {
        rewriter.insertAfter(ctx.getStart().getTokenIndex(),
                "\nprivate static PrintWriter blocks;\n" +
                        "    private static PrintWriter branches;\n");
    }



    @Override public void enterBlock(JavaParser.BlockContext ctx) {
        int start = ctx.getStart().getTokenIndex();
        rewriter.insertAfter(start,"//block " + (counter+1));
        rewriter2.insertAfter(start,"//block " + (counter+1));


        if (counter==0){
            rewriter.insertAfter(start,
                    "\n  blocks = new PrintWriter(\"textoutput/output1blocks.txt\");\n" +
                            "\n  branches = new PrintWriter(\"textoutput/output1branches.txt\");\n");
            rewriter.insertBefore(start,"throws FileNotFoundException");
            int end = ctx.getStop().getTokenIndex();
            rewriter.insertBefore(end, " blocks.close();\n" + "branches.close();\n");
        }

        counter++;
        rewriter.insertAfter(start, "\n\t\t blocks.println(\"block #" + counter + " is visited\");\n");

    }

    @Override
    public void enterForStatement(JavaParser.ForStatementContext ctx) {
        if(ctx.getChild(4).getText().charAt(0) != '{'){
            counter++;
            rewriter.insertBefore(ctx.statement().getStart(),
                    "{//block " + (counter) + "\n\t\t blocks.println(\"block #" + counter + " is visited\");\n");
            rewriter.insertAfter(ctx.statement().getStop(),"}");
            rewriter2.insertBefore(ctx.statement().getStart(), "{//block " + (counter) + "\n\t\t");
            rewriter2.insertAfter(ctx.statement().getStop(),"}");
        }
    }

    @Override
    public void enterIfStatement(JavaParser.IfStatementContext ctx) {

        // check if there is branch then append the build
        char[] character = ctx.parExpression().getText().toCharArray(); // get "(x<3 || y < 5)" into characters array [(, x , < , 3.......]
        build.append("for(int i = 0; i != 1 ;){\n\t\t if (");

        if(ctx.parExpression().getText().contains("|")){
            String conditions = ctx.parExpression().getText();
            String firstCondition = conditions.substring(1, conditions.indexOf("|"));
            String secondCondition = conditions.substring(conditions.indexOf("|") + 2, conditions.length() - 1);
            System.out.println("FIRST CONDITION " + firstCondition);
            System.out.println("SECOND CONDITION " + secondCondition);

            build.append("\n\t\tif(").append(firstCondition).append(") branches.println(\"branch of block #").append( (counter + 1) + " is not covered\");\n");

        }
        else{
            build.setLength(0);
        }
        //block comment and brackets
        System.out.println(ctx.getChild(2).getText());
        if(ctx.getChild(2).getText().charAt(0) != '{') {
            System.out.println("here");
            counter++;
            rewriter.insertBefore(ctx.statement(0).getStart(),
                    "{//block " + (counter) + "\n\t\t " + build.toString() + "\n\t\t blocks.println(\"block #" + counter + " is visited\");\n");
            rewriter.insertAfter(ctx.statement(0).getStop(), "}");
            rewriter2.insertBefore(ctx.statement(0).getStart(), "{//block " + (counter)+ "\n\t\t");
            rewriter2.insertAfter(ctx.statement(0).getStop(), "}");
        }
        else rewriter.insertAfter(ctx.statement(0).getStart(), "\n\t\t" + build.toString() + "\n\t\t");
        if( ctx.getChild(4) != null && ctx.getChild(4).getText().charAt(0) != '{') {
            counter++;
            rewriter.insertBefore(ctx.statement(1).getStart(),
                    "{//block " + (counter) + "\n\t\t  blocks.println(\"block #" + counter + " is visited\");\n");
            rewriter.insertAfter(ctx.statement(1).getStop(), "}");
            rewriter2.insertBefore(ctx.statement(1).getStart(), "{//block " + (counter)+ "\n\t\t");
            rewriter2.insertAfter(ctx.statement(1).getStop(), "}");
        }

    }


    @Override
    public void enterWhileStatement(JavaParser.WhileStatementContext ctx) {
        // check if there is branch then append the build
        if(ctx.parExpression().getText().contains("|")){
            String conditions = ctx.parExpression().getText();
            String firstCondition = conditions.substring(1, conditions.indexOf("|"));
            String secondCondition = conditions.substring(conditions.indexOf("|") + 2, conditions.length() - 1);
            System.out.println("FIRST CONDITION " + firstCondition);
            System.out.println("SECOND CONDITION " + secondCondition);

            build.append("\n\t\tif(").append(firstCondition).append(") branches.println(\"branch of block #").append( (counter + 1) + " is not covered\");\n");

        }
        else build.setLength(0);
        /////////////////////////////////////////////
        if(ctx.getChild(2).getText().charAt(0) != '{') {
            counter++;
            rewriter.insertBefore(ctx.statement().getStart(),
                    "{//block " + (counter) + "\n\t\t " + build.toString() + "\n\t\t blocks.println(\"block #" + counter + " is visited\");\n");
            rewriter.insertAfter(ctx.statement().getStop(), "}");
            rewriter2.insertBefore(ctx.statement().getStart(), "{//block " + (counter)+ "\n\t\t");
            rewriter2.insertAfter(ctx.statement().getStop(), "}");
        }
        else rewriter.insertAfter(ctx.statement().getStart(), "\n\t\t" + build.toString() + "\n\t\t");
    }

}



