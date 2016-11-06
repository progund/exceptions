public class NegativeAmountException extends RuntimeException{
  public NegativeAmountException(){
    super(); // would be implicit, but we'll write it to remind you
  }
  public NegativeAmountException(String message){
    super(message);
  }
}
