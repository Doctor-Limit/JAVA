package Day12.test12;

public class StudentTest {
    public static void main(String[] args) {
        try {
            Student s = new Student();
            s.regist(-1001);
            System.out.println(s);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
class Student{
    private int id;
    public void regist(int id){
       if(id>0){
           this.id=id;
       }
       else{
           throw new MyException("不能输入负数");
       }
    }
}
