package Work1.Day01;

class XiyoujiRen{
    float height,weight;
    String head,ear;
    void speak(String s){
        head="����ͷ";
        System.out.println(s);
    }
}

public class Example4_3 {
    public static void main(String[] args) {
        XiyoujiRen zhubajie,sunwukong;
        zhubajie=new XiyoujiRen();
        sunwukong=new XiyoujiRen();
        zhubajie.height=1.80f;
        zhubajie.head="��ͷ";
        sunwukong.height=1.62f;
        sunwukong.weight=1000f;
        sunwukong.head="�㷢ƮƮ";
        System.out.println("zhubajie����ߣ�"+zhubajie.height);
        System.out.println("zhubajie��ͷ��"+zhubajie.head);
        System.out.println("sunwukong��������"+sunwukong.weight);
        System.out.println("����������Ȣϱ��");
        System.out.println("zhubajie���ڵ�ͷ��"+zhubajie.head);
        sunwukong.speak("��������1000�����ƭ�˽䱳��");
        System.out.println("sunwukong���ڵ�ͷ��"+sunwukong.head);
    }




}
