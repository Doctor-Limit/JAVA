package Day12.test12;
/*
************************�Զ����쳣��
* 1���̳������е��쳣�ṹ��RuntimeException��Exception
* 2���ṩȫ�ֳ���serialVersionUID
* 3���ṩ���ع�����
*
 */
public class MyException extends RuntimeException {

    static final long serialVersionUID = -703489719066939L;//�ṩ���а汾����ȷ��Ϊͬһ��

    public MyException(){

    }

    public MyException(String msg){
        super(msg);
    }
}
