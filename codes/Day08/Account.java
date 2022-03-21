package Day08;

public class Account {
    private int id;
    private double balance;
    private double annuallnterestRate;//������

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
    public double getMothlyInterest(){ //������
        return annuallnterestRate/12;
    }
    public void withdraw(double amount){//ȡǮ
        if(balance>=amount){
            balance-=amount;
            return;
        }
        System.out.println("����");
    }
    public void deposit(double amount){
        if(amount>0) balance+=amount;
    }
}








