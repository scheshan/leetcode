package leetcode.p709;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/23
 */
public class Solution {

    public String toLowerCase(String s) {
        char[] res = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                res[i] = (char) (ch - 'A' + 'a');
            } else {
                res[i] = ch;
            }
        }
        return new String(res);
    }
}
