public class TestSavingsAccount{
  public static void main(String[] args){
    SavingsAccount a = new SavingsAccount(100.0);
    try{
      System.out.println("Before withdrawal: " + a);
      System.out.println("Withdraw 50.00");
      a.withdraw(50.00);
      System.out.println("After withdrawal: " + a);
      System.out.println("Withdraw 50.01");
      a.withdraw(50.01);
      System.out.println("After withdrawal: " + a);      
    }catch(InsufficientBalanceException e){
      System.err.println("Couldn't withdraw: " + e.getMessage());
    }
    try{
      System.out.println("Creating account with a negative amount");
      new SavingsAccount(-1);
    }catch(Exception e){
      System.err.println(e.getMessage());
    }
    try{
      System.out.println("Deposit of a negative amount");
      a.deposit(-1);
    }catch(Exception e){
      System.err.println(e.getMessage());
    }
    try{
      System.out.println("Withdrawal of a negative amount");
      a.withdraw(-1);
    }catch(Exception e){
      System.err.println(e.getMessage());
    }
    System.out.println("Final state of a: " + a);    
  }
}
