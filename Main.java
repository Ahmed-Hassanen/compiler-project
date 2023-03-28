import java.io.FileWriter;
public class Main {
    public static void main(String[] args) throws Exception{
 	 	FileWriter outpt1 = new FileWriter("output.txt");
        outpt1.write("Block number " +1+ " is visited\n");
        outpt1.close();

        int x = 5;
        if(x == 5 || x == 6) {
 	 	FileWriter outpt2 = new FileWriter("output.txt", true);
        outpt2.write("Block number " +2+ " is visited\n");
        outpt2.close();

            System.out.println("hello");
        }
        else if(true) {
 	 	FileWriter outpt3 = new FileWriter("output.txt", true);
        outpt3.write("Block number " +3+ " is visited\n");
        outpt3.close();

            System.out.println("hello");
        }
        else {
 	 	FileWriter outpt4 = new FileWriter("output.txt", true);
        outpt4.write("Block number " +4+ " is visited\n");
        outpt4.close();

            System.out.println("hello");
        }
        for(int i = 0 ; i < 3  ;i++)
        {
 	 	FileWriter outpt5 = new FileWriter("output.txt", true);
        outpt5.write("Block number " +5+ " is visited\n");
        outpt5.close();

            System.out.println("hello");
        }
    }
}