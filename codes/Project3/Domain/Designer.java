package Project3.Domain;


public class Designer extends Programmer{
    private double bonus;//����

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public double getBonus() {
        return bonus;
    }
    public Designer(){
    }
    public Designer(int id, String name, int age, double salary,Equipment equipment, double bonus){
        super(id, name, age, salary,equipment);
        this.bonus=bonus;
    }
    @Override
    public String toString() {
        return getDetails()+"\t���ʦ\t"+getStatus()+
                "\t\t"+bonus+"\t\t"+getEquipment().getDescription();
    }
    public String getDetailsForTeam(){
        return getMemberId()+"/"+getId()+"\t"+getName()+
                "\t"+getAge()+"\t"+getSalary()+"\t���ʦ\t"+getBonus();
    }
}
