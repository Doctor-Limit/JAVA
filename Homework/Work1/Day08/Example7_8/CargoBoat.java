package Work1.Day08.Example7_8;

/**
 * ********概述：
 */
public class CargoBoat {
    int realContent;
    int maxContent;
    public void setMaxContent(int c) {
        maxContent = c;
    }
    public void loading(int m) throws DangerException {
        realContent += m;
        if (realContent > maxContent) {
            throw new DangerException();
        }
    }
}
