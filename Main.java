import java.io.FileWriter;
public class Main {
    public static void main(String[] args) throws Exception{
FileWriter outpt1 = new FileWriter("output.txt", true);
        outpt1.write("Block number " +1+ " is visited\n");
        outpt1.close();

        int x=3;
        if(x==2){
FileWriter outpt2 = new FileWriter("output.txt", true);
        outpt2.write("Block number " +2+ " is visited\n");
        outpt2.close();

            x++;
            x=4;
        }
        while(x<10){
FileWriter outpt3 = new FileWriter("output.txt", true);
        outpt3.write("Block number " +3+ " is visited\n");
        outpt3.close();

            x++;
        }
    }
}
