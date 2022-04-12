package Day04.test6;

import java.io.Serializable;

/**
 * ********概述：
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("呼吸");
    }

    public void eat(){
        System.out.println("干饭");
    }

}
