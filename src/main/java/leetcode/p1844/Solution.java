package leetcode.p1844;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/23
 */
public class Solution {

    public String replaceDigits(String s) {
        char[] res = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[i] = s.charAt(i);

            if (i + 1 < s.length()) {
                res[i + 1] = (char) (s.charAt(i) + s.charAt(i + 1) - '0');
                i++;
            }
        }
        return new String(res);
    }
}
