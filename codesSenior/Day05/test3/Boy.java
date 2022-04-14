package Day05.test3;

/**
 * ********概述：
 */
public class Boy {
    private Girl girl;

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }
    public Boy(){
    }
    public Boy(Girl girl){
        this.girl=girl;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }

}
