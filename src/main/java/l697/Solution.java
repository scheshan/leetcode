package l697;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/18
 */
public class Solution {

    public int findShortestSubArray(int[] nums) {
        int[][] count = new int[50000][3];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (count[n][0] == 0) {
                count[n][1] = i;
                count[n][2] = i;
            } else {
                count[n][2] = i;
            }
            count[n][0]++;
            max = Math.max(max, count[n][0]);
        }

        int min = Integer.MAX_VALUE;
        for (int[] c : count) {
            if (c[0] == max) {
                min = Math.min(min, c[2] - c[1] + 1);
            }
        }
        return min;
    }
}
