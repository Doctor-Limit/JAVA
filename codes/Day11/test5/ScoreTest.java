package Day11.test5;

//����ֵת��Ϊ����ʽ��new+��������(����ֵ)��ʽ��JDK9���ѷ����������������������.valueOf(����ֵ)
import java.util.Scanner;
import java.util.Vector;

public class ScoreTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Vector v=new Vector();//������������������洢����
        int maxScore=0;
        for(;;){
            System.out.println("������ѧ���ɼ����������������������");
            int score=scanner.nextInt();
            if(score<0) break;
            if(score>100){
                System.out.println("�����������������룺");
                continue;
            }
//            int inscore=Integer.valueOf(score);//new Integer(score)��JDK9���ѷ������������
//            v.addElement(inscore);
            v.addElement(score);//�Զ�װ�䣬�ȼ�������
            if(maxScore<score)maxScore=score;
        }
        char level=' ';
        for(int i=0;i<v.size();i++){
            Object obj=v.elementAt(i);
            Integer inScore=(Integer) obj;
            int score=inScore.intValue();//�ȼ���int score=(int)obj;
            int x=maxScore-score;
            if(x<=10) level='A';
            if(x>10&&x<=20)level='B';
            if(x>20&&x<=30)level='C';
            else level='D';
            System.out.println("student-"+i+" score is"+score+",level is"+level);
        }

    }
}
