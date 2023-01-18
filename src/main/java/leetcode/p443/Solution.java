package leetcode.p443;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int compress(char[] chars) {
        int l = 0;
        int r = 0;

        while (r < chars.length) {
            int fast = r + 1;
            while (fast < chars.length && chars[fast] == chars[r]) {
                fast++;
            }

            chars[l++] = chars[r];

            if (fast - r > 1) {
                String cnt = String.valueOf(fast - r);
                for (int i = 0; i < cnt.length(); i++) {
                    chars[l++] = cnt.charAt(i);
                }
            }
            r = fast;
        }
        return l;
    }
}
