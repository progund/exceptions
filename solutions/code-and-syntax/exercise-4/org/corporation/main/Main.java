package org.corporation.main;
import org.corporation.files.JavaReader;
public class Main{
  public static void main(String[] args){
    JavaReader reader = new JavaReader("org/corporation/files/JavaReader.java");
    try{
      reader.readAndPrint();
    }catch(Exception e){
      System.err.println("Critical failure: " + e.getMessage());
      System.err.println("Cause: " + e.getCause());
    }
  }
}
