package Day12.test13;

import java.util.Scanner;


public class EcmDef {
    public static void main(String[] args) {
        try{
       int i=Integer.parseInt(args[0]);
       int j=Integer.parseInt(args[1]);

       int result=ecm(i,j);
        }catch (NumberFormatException e){
            System.out.println("数据类型不一致");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("缺少命令行参数");
        }catch (ArithmeticException e){
            System.out.println("分母为0");
        }
        catch (EcDef e){
            System.out.println(e.getMessage());
        }
    }
public static int ecm(int a,int b) throws EcDef{ //方法抛出自己的异常来处理异常
      if(a<0||b<0){throw new EcDef("分子或分母为负数");}//生成一个异常对象
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