public class InsufficientBalanceException extends Exception{
  public InsufficientBalanceException(){
    super();
  }
  public InsufficientBalanceException(String message){
    super(message);
  }
}
