package leetcode.p2455;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public int averageValue(int[] nums) {
        int total = 0;
        int cnt = 0;
        for (int num : nums) {
            if (num % 3 == 0 && (num & 1) == 0) {
                cnt++;
                total += num;
            }
        }
        if (cnt == 0) {
            return 0;
        }
        return total / cnt;
    }
}
