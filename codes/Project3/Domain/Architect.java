package Project3.Domain;

import Project3.Service.Status;

public class Architect extends Designer{
    private double stock;

    public void setStock(double stock) {
        this.stock = stock;
    }
    public double getStock() {
        return stock;
    }
    public Architect(){
    }
    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, double stock){
        super(id, name, age, salary, equipment, bonus);
        this.stock=stock;
    }

    @Override
    public String toString() {
        return getDetails()+"\t�ܹ�ʦ\t"+getStatus()+"\t\t"+getBonus()+
                "\t\t"+stock+"\t"+getEquipment().getDescription();
    }
    public String getDetailsForTeam(){
        return getMemberId()+"/"+getId()+"\t"+getName()+"\t"+getAge()+
                "\t"+getSalary()+"\t�ܹ�ʦ\t"+getBonus()+"\t"+getStock();
    }
}
