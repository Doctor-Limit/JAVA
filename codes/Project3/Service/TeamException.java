package Project3.Service;

//RuntimeException:����ʱ�Żᱨ��   Exception:����ʱ�ͻᱨ��
public class TeamException extends Exception {
    static final long serialVersionUID = -70348971907766939L;
    public TeamException(){
    }
    public TeamException(String msg){
        super(msg);
    }
}
