package Day08;

public class CheckAccount extends Account{
private double overdraft;//��͸֧���
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
    if(getBalance()>=amount){ //����㹻����
        setBalance(getBalance()-amount);//�ȼ���  super.withdraw(amount);
    }
    else if(overdraft>=amount-getBalance()){//͸֧��ȼ�����㹻
        overdraft-=amount-getBalance();
        setBalance(0);//�ȼ���super.withdraw(getBalance());
    }
    else System.out.println("������͸֧�޶�");
}
}
