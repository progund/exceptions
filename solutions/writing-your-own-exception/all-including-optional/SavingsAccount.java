public class SavingsAccount{
  private double balance;
  public SavingsAccount(){
    
  }
  public SavingsAccount(double initialBalance){
    if(initialBalance<0.0){
      throw new NegativeAmountException("Negative amount: " + initialBalance);
    }
    this.balance = initialBalance;
  }

  public void withdraw(double amount) throws InsufficientBalanceException{
    if(amount < 0.0){
      throw new NegativeAmountException("Can't withdraw a negative amount: " + amount);
    }
    if( (balance-amount) >=0.0 ){
      balance -= amount;
    }else{
      throw new InsufficientBalanceException("Current balance: " +
                                             balance +
                                             " requested withdrawal amount: " +
                                             amount);
    }
  }
  public void deposit(double amount){
    if(amount < 0.0){
      throw new NegativeAmountException("Can't deposit a negative amount: " + amount);
    }
    balance += amount;
  }
  public double balance(){
    return balance;
  }
  @Override
  public String toString(){
    return String.format("Balance: %.2f", balance); 
  }
}
