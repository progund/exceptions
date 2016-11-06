import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
public class WritingFile{
  public static void main(String[] args){
    try{
      writeFile();
    }catch(Exception e){
      System.err.println("Something went wrong: " + e.getMessage());
      System.exit(1);
    }
  }

  static void writeFile(){
    try{
      PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
    }catch(IOException ex){
      throw new RuntimeException("Problem writing: "+ex.getMessage(), ex);
      //System.err.println("Couldn't open file for writing: " + ex.getMessage());
      //ex.printStackTrace();
    }
  }
}
