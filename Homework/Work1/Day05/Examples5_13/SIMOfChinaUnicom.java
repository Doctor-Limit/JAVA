package Work1.Day05.Examples5_13;

/**
 * ********概述：
 */
public class SIMOfChinaUnicom extends SIM{
    String number;
    @Override
    public void setNumber(String n) {
        number = n;
    }

    @Override
    public String giveNumber() {
        return number;
    }

    @Override
    public String giveCorpName() {
        return "中国联通";
    }
}
