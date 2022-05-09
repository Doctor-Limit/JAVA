package Work1.Day04.Example5_4;

/**
 * ********概述：
 */
public class Example5_4 {
    public static void main(String[] args) {
        double math=62,english=76.5,chinese=67;
        ImportantUniversity univer=new ImportantUniversity();
        univer.enterRule(math,english,chinese);
        math=91;
        english=82;
        english=86;
        univer.enterRule(math,english,chinese);
    }
}
