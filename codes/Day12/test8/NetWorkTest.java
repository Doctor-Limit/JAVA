package Day12.test8;
/*
接口的使用：代理模式
通过被代理类的代理来具体操作
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

//被代理类
class Server implements NetWork{
    @Override
    public void browse() {
        System.out.println("真实的服务器访问网络");
    }
}
//代理类
class ProxySrever implements NetWork{
    private  NetWork work;

    public ProxySrever(NetWork work){
        this.work=work;
    }
    public void check(){
        System.out.println("联网之前的检查工作");
    }
    @Override
    public void browse() {
      check();
      work.browse();
    }
}