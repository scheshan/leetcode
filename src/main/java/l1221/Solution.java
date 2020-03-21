package l1221;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    public int balancedStringSplit(String s) {
        int result = 0;
        int l = 0;
        int r = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'L') {
                l++;
            } else {
                r++;
            }

            if (l == r) {
                result++;
                l = 0;
                r = 0;
            }
        }

        return result;
    }
}
