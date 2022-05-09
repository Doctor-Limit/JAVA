package Work1.Day05;

/**
 * ********概述：
 */

abstract class GirlFriend {
    abstract void speak();
    abstract void cooking();
}

class ChinaGirlFriend extends GirlFriend {

    @Override
    void speak() {
        System.out.println("你好");
    }

    @Override
    void cooking() {
        System.out.println("水煮鱼");
    }
}

class AmericanGirlFriend extends GirlFriend {

    @Override
    void speak() {
        System.out.println("hello");
    }

    @Override
    void cooking() {
        System.out.println("roast beef");
    }
}

class Boy {
    GirlFriend friend;

    public void setFriend(GirlFriend friend) {
        this.friend = friend;
    }
    void showGirlFriend() {
        friend.speak();
        friend.cooking();
    }
}

public class Examples5_12 {
    public static void main(String[] args) {
        GirlFriend girl = new ChinaGirlFriend();
        Boy boy = new Boy();
        boy.setFriend(girl);
        boy.showGirlFriend();
        girl = new AmericanGirlFriend();
        boy.setFriend(girl);
        boy.showGirlFriend();

    }
}
