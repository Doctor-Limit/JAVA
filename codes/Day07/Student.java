package Day07;

public class Student extends Person{
    String major;
    public Student(){
    }
    public Student(String major){
        this.major=major;
    }
    public void study(){
        System.out.println("ѧϰרҵ�ǣ�"+major);
    }
    public void eat(){ //�����н���д����������б���д����
        System.out.println("ѧ��Ӧ�ö����Ӫ����ʳ��");
    }

}
