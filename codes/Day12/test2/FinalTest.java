package Day12.test2;
/*
final:���յ�
native�����õײ�c����ʵ��java���ܣ�����ʾ��

final���εĽṹ���ࡢ����������
1��final����һ���ࣺ���಻�ɱ��̳�  ���磺String�ࡢSystem�ࡢStringBuffer��
2��final���η������˷������ɱ���д  ���磺Object����getClass();
3��final���α�������ʱ�ı����ͳ�Ϊһ������
   (1)�������ԣ���ʾ��ʼ����������г�ʼ������������ʼ��
   (2)���ξֲ�������ʹ��final�����β�ʱ���������β�Ϊһ�����������÷���ʱ�������βθ�һ��ʵ�Σ���ֵ��
                 ֻ���ڷ�����ʹ�ô��βΣ��������¸�ֵ��

   static final :�������ԣ�ȫ�ֳ�����
 */

public class FinalTest {
    final int width=10;
//    public void doWidth(){
//        width=20; �޷����޸�
//    }


    public static void main(String[] args) {
        int num=10;
        num+=5;
    }
}
final class FinalA{

}
class AA{
    public final void show(){
    }
}
class BB extends AA{
//    public void show(){
//
//    }
}


