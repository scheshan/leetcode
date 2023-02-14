package leetcode.p2264;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public String largestGoodInteger(String num) {
        String res = "";

        for (int i = 2; i < num.length(); i++) {
            if (num.charAt(i - 2) == num.charAt(i - 1) && num.charAt(i - 1) == num.charAt(i)) {
                if (res.length() == 0 || res.charAt(0) < num.charAt(i - 2)) {
                    res = num.substring(i - 2, i + 1);
                }
            }
        }

        return res;
    }
}
