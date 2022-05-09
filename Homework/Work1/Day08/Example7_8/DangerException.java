package Work1.Day08.Example7_8;


/**
 * ********概述：
 */
public class DangerException extends Exception {
    final String message = "超重";
    public String warnMess() {
        return message;
    }
}
