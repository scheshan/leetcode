package offer.p58_01;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/24
 */
public class Solution {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int l = 0;
        int r = s.length() - 1;
        while (l <= r && s.charAt(l) == ' ') {
            l++;
        }
        while (r >= l && s.charAt(r) == ' ') {
            r--;
        }

        while (l <= r) {
            int start = r;
            while (l <= r && s.charAt(r) != ' ') {
                r--;
            }
            for (int i = r + 1; i <= start; i++) {
                sb.append(s.charAt(i));
            }

            if (l <= r) {
                sb.append(' ');
                while (l <= r && s.charAt(r) == ' ') {
                    r--;
                }
            }
        }
        return sb.toString();
    }
}
