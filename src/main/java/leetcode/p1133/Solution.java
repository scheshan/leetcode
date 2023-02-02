package leetcode.p1133;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public int largestUniqueNumber(int[] nums) {
        int[] count = new int[1001];
        for (int num : nums) {
            count[num]++;
        }

        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] == 1) {
                return i;
            }
        }
        return -1;
    }
}
