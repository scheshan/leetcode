package leetcode.p2283;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public boolean digitCount(String num) {
        int[] count = new int[11];
        for (int i = 0; i < num.length(); i++) {
            count[num.charAt(i) - '0']++;
        }

        for (int i = 0; i < num.length(); i++) {
            if (count[i] != num.charAt(i) - '0') {
                return false;
            }
        }
        return true;
    }
}
