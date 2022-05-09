package Work1.Day01.Example4_9;

public class Example4_9 {
    public static void main(String[] args) {
        STM simOne=new STM(13889776509l);
        MobileTelephone mobile=new MobileTelephone();
        mobile.setSim(simOne);
        System.out.println("手机号码："+mobile.lookNumber());
        STM simTwo=new STM(15967563567l);
        mobile.setSim(simTwo);
        System.out.println("手机号码："+mobile.lookNumber());
    }
}
