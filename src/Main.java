import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class Main {
    static int totalBlocks;

    static String s = "";

    static List<Integer> colors = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        // Create a scanner to read input file name from console
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input file name: ");
        String fileName = scanner.nextLine();
        CharStream input = CharStreams.fromFileName(fileName);
        JavaLexer lexer = new JavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);
        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker();
        htmlGenerator myListener = new htmlGenerator(tokens);
        walker.walk(myListener, tree);

        // initiates a parse tree traversal starting from the root node of the parse tree (tree) and visits each node of the tree As each node is visited, the corresponding method in the listener object (myListener) is called.
//obj points to the file
        File execFileObject = new File("htmlGenerator/execute.java");
        FileWriter fileWriter = new FileWriter("htmlGenerator/execute.java");
        fileWriter.write(myListener.rewriter.getText());
//overwrite or create if not existing
        fileWriter.close();
//         buffers are flushed and any system resources used by the FileWriter are released.

        //compile and run java code automatic
        Process proc = null;
        Process proc2 = null;
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, execFileObject.getPath());

        try {

            proc = Runtime.getRuntime().exec("javac htmlGenerator/execute.java");
            proc.waitFor(); // wait for the compilation to complete
            proc = Runtime.getRuntime().exec("java htmlGenerator/Main");



        } catch (IOException e) {
            System.err.println("err on execution");
            e.printStackTrace();
        }


        Pattern pattern = Pattern.compile("\\bblock\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(myListener.rewriter2.getText());

//        This line creates a new Pattern object using the Pattern.compile method. The pattern specifies that we want to search for the word "block", with the \b representing a word boundary, which ensures that we only match the word "block" and not words that contain "block" (e.g. "blocking"). The Pattern.CASE_INSENSITIVE flag indicates that the search should be case-insensitive
//         search with the text
        totalBlocks = 0;

        while (matcher.find()) totalBlocks++;



        genHtml(myListener.rewriter2.getText());
        String blocksPath = "htmlGenerator/blocks.txt";

        String branchCoveragePath = "htmlGenerator/branchCoverage.txt";
        File file1 = new File(blocksPath);
        File file2 = new File(branchCoveragePath);
        if (!file1.exists()) {
            try {
                // create new file
                file1.createNewFile();


            } catch (IOException e) {
                System.out.println("An error occurred while creating the file.");
                e.printStackTrace();
            }
        }
        if (!file2.exists()) {
            try {
                // create new file
                file2.createNewFile();


            } catch (IOException e) {
                System.out.println("An error occurred while creating the file.");
                e.printStackTrace();
            }
        }
        scanBlocksFromTxt("blocks.txt");
        scanBlocksFromTxt("branchCoverage.txt");
        File cssFile = new File("htmlGenerator/cssFile.css");
        FileUtils.writeStringToFile(cssFile, s);
    }

    static void scanBlocksFromTxt(String fileName) throws IOException {
        CharStream in = CharStreams.fromFileName("htmlGenerator/" + fileName);
        String text = in.toString();
        colors.clear();
        // extract the numbers from the text file to the array colors
        String pattern = "\\d+"; // Matches one or more digits
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(text);
        while (m.find()) {
            colors.add(Integer.parseInt(m.group()));
        }
        for(int i = 1; i <= totalBlocks; i++){
            if(!colors.contains(i) && fileName == "blocks.txt" ){
                s += "#b" + i + " \n{background-color: #FF0000;}\n";
            }
            if(colors.contains(i) && fileName == "branchCoverage.txt" ){
                s += "#c" + i + " \n{background-color: #ffa500;}\n";
            }
        }


    }


    static void genHtml(String code) throws IOException {

        String line;
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new StringReader(code));
        Pattern pattern = Pattern.compile("block" + "\\D*(\\d+)");

        while ((line = reader.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);


            if (line.contains("{")) {
                if(matcher.find()) {
                    // search "block #"
                    String numberString = matcher.group(1);
                    int number = Integer.parseInt(numberString);
                    // get number
                    line = "<div id=\"b" + number + "\"" + ">" + line;
                    if(line.contains("|")){
                        line = line.replace("(","(<span id = \"c" + number +"\"" +">");
                        line = line.replace(")","</span>)");
                    };

                } else line = "<div>" + line;
            }
            if (line.contains("}")) {
                line = line + "</div>";
            }

            sb.append(line + System.lineSeparator());


        }
        reader.close();

        File newHtmlFile = new File("htmlGenerator/generatedHtml.html");
        // replace our code in the html body
        File base = new File("htmlGenerator/base.html");
        String baseString = FileUtils.readFileToString(base);
        baseString = baseString.replace("##BODY", sb.toString());
        baseString = baseString.replace("##HREF", "href=\"cssFile.css\"");
        FileUtils.writeStringToFile(newHtmlFile, baseString);


    }
}