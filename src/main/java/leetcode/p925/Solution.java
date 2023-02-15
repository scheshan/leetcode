package leetcode.p925;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/15
 */
public class Solution {

    public boolean isLongPressedName(String name, String typed) {
        int l = 0;
        int r = 0;

        while (l < name.length() && r < typed.length()) {
            char c1 = name.charAt(l);
            int cnt = 0;
            while (l < name.length() && name.charAt(l) == c1) {
                l++;
                cnt++;
            }

            char c2 = typed.charAt(r);
            if (c2 != c1) {
                return false;
            }
            while (r < typed.length() && typed.charAt(r) == c2) {
                r++;
                cnt--;
            }

            if (cnt > 0) {
                return false;
            }
        }
        return l == name.length() && r == typed.length();
    }
}
