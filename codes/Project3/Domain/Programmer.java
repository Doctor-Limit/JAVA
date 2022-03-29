package Project3.Domain;

import Project3.Service.Status;

public class Programmer extends Employee implements Equipment {

    private int memberId;//�ڿ����Ŷ��е�ID
    private Status status=Status.FREE;//���ȸ�ֵ
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
                "\t����Ա\t"+status+"\t\t"+equipment.getDescription();
    }
    public String getTeamBaseDetails;
    public String getDetailsForTeam(){
        return memberId+"/"+getId()+"\t"+getName()+
                "\t"+getAge()+"\t"+getSalary()+"\t����Ա";
    }
}
