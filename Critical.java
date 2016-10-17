import java.io.IOException;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;

public class Critical{
  public static void main(String[] args){
    // "Global handler of every type of Exception
    // starts with this try-block
    try{
      // Call the method which intializes the application
      initApplication();

      // this is the handler catch-block which deals with problems
    }catch(Exception e){
      /* We can't recover from critical problems, but we
       * can at least give the user an understandable message
       * rather than the stacktrace which otherwise would
       * be printed...
       * We ask the exception object if it has a message
       * and include it with our error message.
       */
      System.err.println("Severe problem: " + e.getMessage());
    }
  }
  // This method initializes the application.
  // It has no handler, so any exception will propagate
  // to the caller (which in this case is main )
  static void initApplication(){
    loadSuperImportantFile();
  }
  // This is called by initApplication.
  // It doesn't declare that it throws any checked exceptions.
  // So the callers, don't have to provide a handler, nor
  // declare that they throw any checked exceptions.
  static void loadSuperImportantFile(){
    // You can read about the Path class, if you are interested.
    // For now, it is enough to know that a Path object can
    // represent a path to a file somewhere.
    Path file = FileSystems.getDefault().getPath("important_file", "somepath");
    
    /* A try-with-resources statement does two things:
     * 1. It acts like a normal try-statement, which can have a catch-block
     * 2. It uses a resource which will be closed, either when the
     * try-block terminates normally, or if an exception is caught.
     * This works, becase the resource in the try-with-resources
     * must implement the AutoCloseable interface, which guarantees that
     * there is a close() method implemented for this resource.
     *
     * In this example, the resource is a BufferedReader connected
     * to the Path referred to by file. After the code, close() will
     * be called so that the reader closes its file and this is true
     * even if an exception occurs.
     */
    try ( BufferedReader reader = 
          Files.newBufferedReader(file,Charset.forName("US-ASCII")) )
    {
      String line = null;
      // We want to print every line of the file
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }        
    }catch(IOException e){
      /* Here, the handler catches any IOException and wraps it
       * in a RuntimeException, together with an error message.
       * This RuntimeException is thrown from the catch-block.
       */
      throw new RuntimeException("Important file not found, omg", e);
    }
  }
}
