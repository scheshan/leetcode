package lcp.p17;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int calculate(String s) {
        int x = 1;
        int y = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                x = (x << 1) + y;
            } else {
                y = (y << 1) + x;
            }
        }

        return x + y;
    }
}
