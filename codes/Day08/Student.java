package Day08;

public class Student extends Person {
String major;
int id=1002;//ѧ��
public Student(){
}
public Student(String major){
   this.major=major;
}
public Student(String name,int age,String major){
    super(name,age); //���ø����ж�Ӧ���β��б�Ĺ��캯��
    this.major=major;
}
public void eat(){
    System.out.println("ѧ�������Ӫ��ʳƷ");
}
public void study(){
    System.out.println("ѧ��ѧϰ֪ʶ");
    eat();
    super.eat();
}
public void show(){
    System.out.println("name:"+this.name+",age="+super.age);
    System.out.println("id="+id);//Ĭ��Ϊthis.id ����ǰ�����е�id
    System.out.println("id="+super.id);//��������ͬ��ʶ��ȥ���ø��������
}
}
