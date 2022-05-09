package Work1.Day08.Example7_6;

/**
 * ********概述：
 */
public class BankException extends Exception{
    String message;
    public BankException(int m, int n) {
        message = "入账资金" + m + "负债支出" + n + "是正数，不符合系统要求";
    }
    public String warnMess() {
        return message;
    }
}
