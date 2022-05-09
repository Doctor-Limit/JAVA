package Work1.Day08.Example7_2;

/**
 * ********概述：
 */
public abstract class Bank {
    int money;
    public Bank() {
        money = 100;
    }
    public Bank(int money) {
        this.money = money;
    }
    public abstract void output();
}
