package Project3.Domain;

import Project3.Service.Status;

public class Programmer extends Employee implements Equipment {

    private int memberId;//在开发团队中的ID
    private Status status=Status.FREE;//事先赋值
    private Equipment equipment;

    public void setStatus(Status status) {
        this.status = status;
    }
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
    public Status getStatus() {
        return status;
    }
    public Equipment getEquipment() {
        return equipment;
    }
    public int getMemberId() {
        return memberId;
    }

    public Programmer(){
    }
    public Programmer(int id,String name,int age,double salary,Equipment equipment){
        super(id, name, age, salary);

        this.equipment=equipment;
    }

    @Override
    public String toString() {
        return getDetails()+
                "\t程序员\t"+status+"\t\t"+equipment.getDescription();
    }
    public String getTeamBaseDetails;
    public String getDetailsForTeam(){
        return memberId+"/"+getId()+"\t"+getName()+
                "\t"+getAge()+"\t"+getSalary()+"\t程序员";
    }
}
