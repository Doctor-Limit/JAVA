package Work1.Day01;

class XiyoujiRen{
    float height,weight;
    String head,ear;
    void speak(String s){
        head="歪着头";
        System.out.println(s);
    }
}

public class Example4_3 {
    public static void main(String[] args) {
        XiyoujiRen zhubajie,sunwukong;
        zhubajie=new XiyoujiRen();
        sunwukong=new XiyoujiRen();
        zhubajie.height=1.80f;
        zhubajie.head="大头";
        sunwukong.height=1.62f;
        sunwukong.weight=1000f;
        sunwukong.head="秀发飘飘";
        System.out.println("zhubajie的身高："+zhubajie.height);
        System.out.println("zhubajie的头："+zhubajie.head);
        System.out.println("sunwukong的重量："+sunwukong.weight);
        System.out.println("俺老猪我想娶媳妇");
        System.out.println("zhubajie现在的头："+zhubajie.head);
        sunwukong.speak("老孙我重1000斤，我想骗八戒背我");
        System.out.println("sunwukong现在的头："+sunwukong.head);
    }




}
