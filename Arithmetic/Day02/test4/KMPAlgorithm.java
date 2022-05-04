package Day02.test4;

import java.util.Arrays;

/**
 * ********概述：kmp算法
 */
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int[] next = kmpNext(str2);
        int index = kmpSearch(str1, str2, next);
        System.out.println(index);

    }

    // 写出kmp搜索算法
    /**
     *
     * @param str1   原字符串
     * @param str2   需要查找的子串
     * @param next   子串对应的部分匹配表
     * @return        返回第一个匹配到的位置，没有则返回-1
     */
    public static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            // 需要处理不相等的情况
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];// 将部分匹配表的第一个与大字符串不匹配的字符的匹配值赋给j，让j移动到该位置
            }
            if(str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    // 获取到子串的部分匹配值表: 前缀与后缀中相同子串的最大长度的值就是其匹配值
    public static int[] kmpNext(String dest) {
        // 创建next数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0;// 若字符串长度为1则1匹配值必定为0
        for (int i = 1, j = 0; i < dest.length(); i++) {
            // 当两者不等时，需要从next[j-1]获取到新的j，直到二者相等时才退出
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            // 当条件成立时，部分匹配值就加1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;// 最大相同子串的长度即为该匹配值
        }
        return next;
    }

}
