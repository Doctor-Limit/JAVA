package Work2.test1;

public class PC {
    CPU cpu=new CPU();
    HardDisk HD=new HardDisk();
    public void setCpu(CPU c){
        cpu=c;
    }
    public void setHardDisk(HardDisk h){
        HD=h;
    }
    public void show(){
        System.out.println("cpu�ٶ�Ϊ��"+cpu.getSpeed());
        System.out.println("Ӳ������Ϊ��"+HD.getAmount());
    }
}
