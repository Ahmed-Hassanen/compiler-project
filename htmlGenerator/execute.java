 import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;


class Main {
private static PrintWriter blocks;
    private static PrintWriter branches;

  public static void main(String[] args) throws FileNotFoundException{//block 1
  blocks = new PrintWriter("textoutput/output1blocks.txt");

  branches = new PrintWriter("textoutput/output1branches.txt");

		 blocks.println("block #1 is visited");

     int var = 0;
    int x = 0;
   

    if(x == 0||var==79){
		for(int i = 0; i != 1 ;){
		 if (
		if(x==0) branches.println("branch of block #2 is not covered");

		//block 2
		 blocks.println("block #2 is visited");

      var = 10;
    }
    else {//block 3
		 blocks.println("block #3 is visited");

      if(true){
		
		//block 4
		 blocks.println("block #4 is visited");

        x++;
      }
    }
      int var1=1;

  if(true||var1==2){
		for(int i = 0; i != 1 ;){
		 if (
		if(true) branches.println("branch of block #5 is not covered");

		//block 5
		 blocks.println("block #5 is visited");

  var1=3;
  }
    if(true||x==6){
		for(int i = 0; i != 1 ;){
		 if (
		if(true) branches.println("branch of block #5 is not covered");
for(int i = 0; i != 1 ;){
		 if (
		if(true) branches.println("branch of block #6 is not covered");

		//block 6
		 blocks.println("block #6 is visited");

      var = 10;
    }
    if(true){
		
		//block 7
		 blocks.println("block #7 is visited");

      var++;
    }
    int a[] = {1,2,3};
    for (int i = 0 ; x<1 ;x++){//block 8
		 blocks.println("block #8 is visited");


    }
    {//block 9
		 blocks.println("block #9 is visited");

    int w;
    int z;
  }
    if(false){//block 10
		 
		 blocks.println("block #10 is visited");
x=6;}
    if(true){//block 11
		 
		 blocks.println("block #11 is visited");
x=6;}
    if(false){//block 12
		 
		 blocks.println("block #12 is visited");
x=6;}
int var66=55;
  if(var66==55||x==200) {//block 13
		 for(int i = 0; i != 1 ;){
		 if (
		if(var66==55) branches.println("branch of block #13 is not covered");

		 blocks.println("block #13 is visited");
var1=3;}
  if(true||x==200) {//block 14
		 for(int i = 0; i != 1 ;){
		 if (
		if(var66==55) branches.println("branch of block #13 is not covered");
for(int i = 0; i != 1 ;){
		 if (
		if(true) branches.println("branch of block #14 is not covered");

		 blocks.println("block #14 is visited");
var1=3;}



   blocks.close();
branches.close();
}
  }

