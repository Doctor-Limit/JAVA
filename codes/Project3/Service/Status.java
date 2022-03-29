package Project3.Service;

//��ʾԱ��״̬
public class Status {

    private final String NAME;

    private Status (String NAME){
        this.NAME=NAME;
    }
    public static final Status FREE=new Status("FREE");
    public static final Status Busy=new Status("BUSY");
    public static final Status VOCATION=new Status("VOCATION");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
