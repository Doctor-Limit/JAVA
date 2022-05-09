package Work1.Day08.Example7_1;

/**
 * ********概述：
 */
public class RedCowFarm {
    static String farmName;
    RedCow cow;
    RedCowFarm() {
    }
    RedCowFarm(String s) {
        cow = new RedCow(150,112,5000);
        farmName = s;
    }
    public void showComMess() {
        cow.speak();
    }
    class RedCow {
        String cowName = "红牛";
        int height, weight, price;
        RedCow(int h, int w, int p) {
            height = h;
            weight = w;
            price = p;
        }
        void speak() {
            System.out.println("偶是" + cowName + "，身高:" + height +
                    ",体重:" + weight + "kg,生活在" + farmName);
        }
    }

}

