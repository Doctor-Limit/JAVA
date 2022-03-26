package Day11.test5;

//数据值转化为类形式，new+数据类型(数据值)方式在JDK9后已废弃，替代方法：数据类型.valueOf(数据值)
import java.util.Scanner;
import java.util.Vector;

public class ScoreTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Vector v=new Vector();//创建对象来代替数组存储数据
        int maxScore=0;
        for(;;){
            System.out.println("请输入学生成绩（负数代表输入结束）：");
            int score=scanner.nextInt();
            if(score<0) break;
            if(score>100){
                System.out.println("输入有误，请重新输入：");
                continue;
            }
//            int inscore=Integer.valueOf(score);//new Integer(score)在JDK9后已废弃，替代方法
//            v.addElement(inscore);
            v.addElement(score);//自动装箱，等价于上面
            if(maxScore<score)maxScore=score;
        }
        char level=' ';
        for(int i=0;i<v.size();i++){
            Object obj=v.elementAt(i);
            Integer inScore=(Integer) obj;
            int score=inScore.intValue();//等价于int score=(int)obj;
            int x=maxScore-score;
            if(x<=10) level='A';
            if(x>10&&x<=20)level='B';
            if(x>20&&x<=30)level='C';
            else level='D';
            System.out.println("student-"+i+" score is"+score+",level is"+level);
        }

    }
}
