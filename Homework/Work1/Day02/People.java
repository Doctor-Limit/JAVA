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
        System.out.println("有"+hand+"只手"+leg+"条腿");
    }
    public static void main(String[] args) {
     People bush=new People("布什");

    }
}
