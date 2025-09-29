
// CS108 HW1 -- String static methods

import java.util.Stack;

public class StringCode {

    /**
     * Given a string, returns the length of the largest run.
     * A a run is a series of adajcent chars that are the same.
     *
     * @param str chuoi dau vao
     * @return max run length
     */
    public static int maxRun(String str) {
        if (str.length() < 1) {
            return str.length();
        }
        char[] c = str.toCharArray();
        int curLen = 1, maxLen = 1;
        char curChar = c[0];
        for (int i = 1; i < c.length; i++) {
            if (c[i]==curChar) {
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = 1;
                curChar = c[i];
            }
        }
        return Math.max(maxLen, curLen);
    }


    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following. So the string "a3tx2z" yields "attttxzzz".
     *
     * @param str chuoi dau vao
     * @return blown up string
     */
    public static String blowup(String str) {
        if(str.length() > 0) {
            StringBuilder result = new StringBuilder();
            char[] c = str.toCharArray();
            for (int i = 0; i < c.length - 1; i++) {
                if (!Character.isDigit(c[i])) {
                    result.append(c[i]);
                } else if (Character.isDigit(c[i])) {
                    int p = (int) (c[i] - '0');
                    while (p!=0) {
                        result.append(c[i + 1]);
                        p--;
                    }
                }
            }
            if (!Character.isDigit(c[c.length - 1])) {
                result.append(c[c.length - 1]);
            }
            return result.toString();
        }
        return str;// YOUR CODE HERE
    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */
    public static boolean stringIntersect(String a, String b, int len) {
        if (len > a.length() || len > b.length()) {
            return false;
        }
        a = 'x' + a;
        b = 'x' + b;
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        int[][] cnt = new int[s1.length][s2.length];
        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s2.length; j++) {
                cnt[i][j] = 0;
            }
        }
        for (int i = 1; i < s1.length; i++) {
            for (int j = 1; j < s2.length; j++) {
                if (s1[i]==s2[j]) {
                    cnt[i][j] = cnt[i - 1][j - 1] + 1;
                } else {
                    cnt[i][j] = Math.max(cnt[i - 1][j], cnt[i][j - 1]);
                }
                if (cnt[i][j]==len) {
                    return true;
                }
            }
        }
        return false; // YOUR CODE HERE
    }
}
