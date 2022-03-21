package Day08;

public class Account {
    private int id;
    private double balance;
    private double annuallnterestRate;//年利率

    public Account(int id,double balance,double annuallnterestRate){
        this.id=id;
        this.balance=balance;
        this.annuallnterestRate=annuallnterestRate;
    }
    public int getId(){
        return id;
    }
    public double getBalance() {
        return balance;
    }
    public double getAnnuallnterestRate() {
        return annuallnterestRate;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setAnnuallnterestRate(double annuallnterestRate) {
        this.annuallnterestRate = annuallnterestRate;
    }
    public double getMothlyInterest(){ //月利率
        return annuallnterestRate/12;
    }
    public void withdraw(double amount){//取钱
        if(balance>=amount){
            balance-=amount;
            return;
        }
        System.out.println("余额不足");
    }
    public void deposit(double amount){
        if(amount>0) balance+=amount;
    }
}








