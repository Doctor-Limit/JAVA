package Day11.test6;
/*
*******************��̬(static)
ʹ��static�������ԣ�
* ��̬����������ļ��ض����أ�ͨ����.��̬����������
* ��̬�����ļ���Ҫ���ڶ���Ĵ���
* ������ֻ�����һ�Σ�����̬�������ڴ���ֻ����һ�ݣ������ڷ����ľ�̬����

ʹ��static���η�����
*������ļ��ض����أ�ͨ����.��̬����������
* ��̬�����У�ֻ�ܵ��þ�̬�ķ���������
* �Ǿ�̬�����У��ɵ��÷Ǿ�̬���������ԣ�Ҳ�ɵ��þ�̬����������

***********staticע���
�ھ�̬�����У�����ʹ��this�ؼ��֣�super�ؼ���
���ھ�̬�����;�̬���Ե�ʹ�ã����������ڵĽǶ�ȥ���

 * �����У�ȷ���Ƿ�Ҫ����Ϊstatic�����Ի򷽷���
 *���ԣ��ɱ��������������ģ��������Ŷ���ĸı���ı�
 *
 *�����������ֱ࣬��ͨ����.����
 *
 *
 *
 */

class Circle{
    private double radius;
    private int id;
     private static int total;
     private static int init=1001;
     public Circle(){
         id=init++;
         total++;
     }

     public Circle(double radius){
        this();
        this.radius=radius;
     }
     public double findArea(){
         return 3.14*radius*radius;
     }

}

public class StaticTest {
    public static void main(String[] args) {

    }


}












