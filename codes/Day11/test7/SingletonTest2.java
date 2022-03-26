package Day11.test7;

//����ʽ���� �õ�ʱ�����½�����
public class SingletonTest2 {
    public static void main(String[] args) {
       Order o1=Order.getInstance();
       Order o2=Order.getInstance();

       System.out.println(o1==o2);
    }
}

class Order{
    //˽�л�������
    private Order(){
    }

    //������ǰ�����,����������
    private static Order instance=null;

    //
    public static Order getInstance(){
        if(instance==null) instance=new Order();
        return instance;
    }
}


