import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class htmlGenerator extends JavaParserBaseListener {

    TokenStreamRewriter rewriter;
    TokenStreamRewriter branchesRewriter;
    int counter = 0;
    StringBuilder build = new StringBuilder();

    public htmlGenerator(CommonTokenStream tokens) {
        rewriter = new TokenStreamRewriter(tokens);
        branchesRewriter = new TokenStreamRewriter(tokens);
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

    @Override
    public void enterBlock(JavaParser.BlockContext ctx) {
        int start = ctx.getStart().getTokenIndex();
        rewriter.insertAfter(start,"//block " + (counter+1));
        branchesRewriter.insertAfter(start,"//block " + (counter+1));


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
        if (ctx.getChild(4).getText().charAt(0) != '{') {
            counter++;
            rewriter.insertBefore(ctx.statement().getStart(),
                    "{//block " + (counter) + "\n\t\t blocks.println(\"block #" + counter + " is visited\");\n");
            rewriter.insertAfter(ctx.statement().getStop(),"}");

            branchesRewriter.insertBefore(ctx.statement().getStart(), "{//block " + (counter) + "\n\t\t");
            branchesRewriter.insertAfter(ctx.statement().getStop(), "}");
        }
    }

    @Override
    public void enterIfStatement(JavaParser.IfStatementContext ctx) {

        writeToCodeFile(
                ctx.parExpression().getText(),
                ctx.getChild(2),
                ctx.getChild(4),
                ctx.statement()
        );

    }

    @Override
    public void enterWhileStatement(JavaParser.WhileStatementContext ctx) {

        final List<JavaParser.StatementContext> statements = new ArrayList<>();
        statements.add(ctx.statement());

        writeToCodeFile(
                ctx.parExpression().getText(),
                ctx.getChild(2),
                ctx.getChild(4),
                statements
        );
    }

    private void writeToCodeFile(
            String content,
            ParseTree secondChild,
            ParseTree forthChild,
            List<JavaParser.StatementContext> statementContextList
    ) {
        if (content.contains("|")) {
            String firstCondition = content.substring(1, content.indexOf("|"));
            String secondCondition = content.substring(content.indexOf("|") + 2, content.length() - 1);

            build.append("\n\t\tif(").append(firstCondition).append(") branches.println(\"branch of block #").append((counter + 1) + " is not covered\");\n");

        } else {
            build.setLength(0);
        }

        handleNoCurlyBraces(
                secondChild,
                forthChild,
                statementContextList
        );
    }


    private void handleNoCurlyBraces(
            ParseTree secondChild,
            ParseTree forthChild,
            List<JavaParser.StatementContext> statementContextList
    ) {
        //to handle with no curly braces situations
        if (secondChild.getText().charAt(0) != '{') {
            System.out.println("here");
            counter++;
            rewriter.insertBefore(statementContextList.get(0).getStart(),
                    "{//block " + (counter) + "\n\t\t " + build.toString() + "\n\t\t blocks.println(\"block #" + counter + " is visited\");\n");
            rewriter.insertAfter(statementContextList.get(0).getStop(), "}");
            branchesRewriter.insertBefore(statementContextList.get(0).getStart(), "{//block " + (counter) + "\n\t\t");
            branchesRewriter.insertAfter(statementContextList.get(0).getStop(), "}");
        }
        else{
            rewriter.insertAfter(statementContextList.get(0).getStart(), "\n\t\t" + build.toString() + "\n\t\t");
        }


        if (forthChild != null && forthChild.getText().charAt(0) != '{') {
            counter++;
            rewriter.insertBefore(statementContextList.get(1).getStart(),
                    "{//block " + (counter) + "\n\t\t  blocks.println(\"block #" + counter + " is visited\");\n");
            rewriter.insertAfter(statementContextList.get(1).getStop(), "}");
            branchesRewriter.insertBefore(statementContextList.get(1).getStart(), "{//block " + (counter) + "\n\t\t");
            branchesRewriter.insertAfter(statementContextList.get(1).getStop(), "}");
        }
    }
}



