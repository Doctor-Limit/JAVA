package Day12.test5;
/*

*******************模板方法的设计
抽象不确定方法并在子类中具体重写

 */

public class TemplateTest {
    public static void main(String[] args) {
        Template t=new SubTemplate();
        t.spendTime();
    }

}
abstract class Template{
    public void spendTime(){
        long start=System.currentTimeMillis();
        code();//不确定部分
        long end=System.currentTimeMillis();

        System.out.println("花费时间为："+(end-start));
    }
    public abstract void code();
}
class SubTemplate extends Template{
    @Override
    public void code() {
        for(int i=2;i<1000;i++){
            boolean isFlag=true;
            for(int j=2;j<Math.sqrt(i);j++){
                if(i%j==0) {
                    isFlag = false;
                    break;
                }
            }
            if(isFlag)System.out.println(i);
        }
    }
}
