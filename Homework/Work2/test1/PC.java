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
        System.out.println("cpu速度为："+cpu.getSpeed());
        System.out.println("硬盘容量为："+HD.getAmount());
    }
}
