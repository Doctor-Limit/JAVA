package Day12.test13;

import java.util.Scanner;


public class EcmDef {
    public static void main(String[] args) {
        try{
       int i=Integer.parseInt(args[0]);
       int j=Integer.parseInt(args[1]);

       int result=ecm(i,j);
        }catch (NumberFormatException e){
            System.out.println("�������Ͳ�һ��");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ȱ�������в���");
        }catch (ArithmeticException e){
            System.out.println("��ĸΪ0");
        }
        catch (EcDef e){
            System.out.println(e.getMessage());
        }
    }
public static int ecm(int a,int b) throws EcDef{ //�����׳��Լ����쳣�������쳣
      if(a<0||b<0){throw new EcDef("���ӻ��ĸΪ����");}//����һ���쳣����
       return a/b;
}
}
class EcDef extends RuntimeException{
    static final long serialVersionUID = -70348971907466939L;
  public EcDef(){
  }
  public EcDef(String msg){
      super(msg);
  }
}