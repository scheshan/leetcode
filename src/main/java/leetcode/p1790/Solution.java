package leetcode.p1790;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/9
 */
public class Solution {

    public boolean areAlmostEqual(String s1, String s2) {
        int i1 = -1, i2 = -1;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (i1 < 0) {
                    i1 = i;
                } else if (i2 < 0) {
                    i2 = i;
                } else {
                    return false;
                }
            }
        }

        return i1 < 0 || (i2 >= 0 && s1.charAt(i1) == s2.charAt(i2) && s1.charAt(i2) == s2.charAt(i1));
    }
}
