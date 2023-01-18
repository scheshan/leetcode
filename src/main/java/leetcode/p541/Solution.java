package leetcode.p541;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public String reverseStr(String s, int k) {
        StringBuilder res = new StringBuilder(s.length());

        for (int i = 0; i < s.length(); ) {
            int end = i + k;
            if (end >= s.length()) {
                end = s.length();
            }

            for (int j = end - 1; j >= i; j--) {
                res.append(s.charAt(j));
            }

            i = end;
            end = i + k;

            for (int j = i; j < s.length() && j < end; j++) {
                res.append(s.charAt(j));
            }
            i = end;
        }
        return res.toString();
    }
}
