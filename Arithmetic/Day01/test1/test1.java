package Day01.test1;

/**
 * ********概述：
 */
public class test1 {
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() == 0) {
            return true;
        }
        String sub = " ";
        for(int i = 0,j = i + s1.length();j < s2.length();i++,j++) {
            sub = s2.substring(i, j);
            int x = 0, y = 0;
            for(x = 0, y = x + 1;y <= s1.length();x++, y++) {
                if (sub.contains(s1.substring(x,y))) {
                    sub = sub.replaceFirst(s1.substring(x,y)," ");
                }else break;
            }
            if (y == s1.length()+1) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(checkInclusion(s1, s2));
    }
}
