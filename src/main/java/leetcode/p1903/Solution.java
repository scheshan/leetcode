package leetcode.p1903;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/16
 */
public class Solution {

    public String largestOddNumber(String num) {
        int r = num.length() - 1;
        while (r >= 0) {
            int n = num.charAt(r) - '0';
            if ((n & 1) == 1) {
                break;
            }
            r--;
        }

        if (r < 0) {
            return "";
        }
        return num.substring(0, r + 1);
    }
}
