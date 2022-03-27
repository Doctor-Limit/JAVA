package Day12.test8;
/*
�ӿڵ�ʹ�ã�����ģʽ
ͨ����������Ĵ������������
 */
public class NetWorkTest {
    public static void main(String[] args) {
        Server server=new Server();
        ProxySrever proxySrever=new ProxySrever(server);
        proxySrever.browse();
    }
}

interface NetWork{
    void browse();
}

//��������
class Server implements NetWork{
    @Override
    public void browse() {
        System.out.println("��ʵ�ķ�������������");
    }
}
//������
class ProxySrever implements NetWork{
    private  NetWork work;

    public ProxySrever(NetWork work){
        this.work=work;
    }
    public void check(){
        System.out.println("����֮ǰ�ļ�鹤��");
    }
    @Override
    public void browse() {
      check();
      work.browse();
    }
}