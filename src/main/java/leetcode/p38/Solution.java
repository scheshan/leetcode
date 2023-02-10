package leetcode.p38;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/9
 */
public class Solution {

    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();

            int ind = 0;
            while (ind < str.length()) {
                char ch = str.charAt(ind);
                int pre = ind;
                ind++;
                while (ind < str.length() && str.charAt(ind) == ch) {
                    ind++;
                }
                int cnt = ind - pre;
                sb.append(cnt);
                sb.append(ch);
            }

            str = sb.toString();
        }

        return str;
    }
}
