package Project3.Service;

//RuntimeException:运行时才会报错   Exception:编译时就会报错
public class TeamException extends Exception {
    static final long serialVersionUID = -70348971907766939L;
    public TeamException(){
    }
    public TeamException(String msg){
        super(msg);
    }
}
