package leetcode.p2678;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/10/23
 */
public class Solution {

    public int countSeniors(String[] details) {
        int res = 0;

        for (String detail : details) {
            int age = (detail.charAt(11) - '0') * 10 + detail.charAt(12) - '0';
            if (age > 60) {
                res++;
            }
        }

        return res;
    }
}
