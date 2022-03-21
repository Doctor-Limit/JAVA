package Day08;

public class CheckAccount extends Account{
private double overdraft;//可透支额度
public CheckAccount(int id,double balance,double annuallnterestRate,double overdraft){
    super(id, balance, annuallnterestRate);
    this.overdraft=overdraft;
}
    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }
    public double getOverdraft() {
        return overdraft;
    }
    public void withdraw(double amount){
    if(getBalance()>=amount){ //余额足够消费
        setBalance(getBalance()-amount);//等价于  super.withdraw(amount);
    }
    else if(overdraft>=amount-getBalance()){//透支额度加余额足够
        overdraft-=amount-getBalance();
        setBalance(0);//等价于super.withdraw(getBalance());
    }
    else System.out.println("超过可透支限额");
}
}
