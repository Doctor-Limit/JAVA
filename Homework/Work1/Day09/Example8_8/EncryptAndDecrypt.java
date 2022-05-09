package Work1.Day09.Example8_8;

/**
 * ********概述：
 */
public class EncryptAndDecrypt {
    String encrypt(String sourceString, String password) {
        char[] p =password.toCharArray();
        int n = p.length;
        char[] c =sourceString.toCharArray();
        int m = c.length;
        for (int k = 0; k < m; k++) {
            int mima = c[k] + p[k % n];
            c[k] = (char) mima;
        }
        return new String(c);
    }

    String decrypt(String sourceString, String password) {
        char[] p = password.toCharArray();
        int n = p.length;
        char[] c =sourceString.toCharArray();
        int m = c.length;
        for (int k = 0; k < m; k++) {
            int mima = c[k] - c[k % n];
            c[k] = (char) mima;
        }
        return new String(c);
    }

}
