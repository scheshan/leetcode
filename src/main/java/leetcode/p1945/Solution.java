package leetcode.p1945;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/1
 */
public class Solution {

    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(String.valueOf(s.charAt(i) - 'a' + 1));
        }

        String str = sb.toString();
        int res = 0;
        for (int i = 0; i < k; i++) {
            if (str.length() == 1) {
                return str.charAt(0) - '0';
            }

            res = sum(str);
            str = String.valueOf(res);
        }
        return res;
    }

    private int sum(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            res += str.charAt(i) - '0';
        }
        return res;
    }
}
