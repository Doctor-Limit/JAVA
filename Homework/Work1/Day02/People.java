package Work1.Day02;

public class People {
    int leg,hand;
    String name;
    People(String s){
        name=s;
        this.init();
    }
    void init(){
        leg=2;
        hand=2;
        System.out.println("��"+hand+"ֻ��"+leg+"����");
    }
    public static void main(String[] args) {
     People bush=new People("��ʲ");

    }
}
