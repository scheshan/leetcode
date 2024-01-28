package leetcode.p38;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        String s = "1";

        for (int i = 2; i <= n; i++) {
            int ind = 0;
            while (ind < s.length()) {
                int start = ind;
                while (ind < s.length() - 1 && s.charAt(ind + 1) == s.charAt(ind)) {
                    ind++;
                }
                ind++;
                sb.append(ind - start);
                sb.append(s.charAt(start));
            }
            s = sb.toString();
            sb.delete(0, sb.length());
        }

        return s;
    }
}
