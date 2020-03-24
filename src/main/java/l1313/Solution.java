package l1313;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/24
 */
public class Solution {

    public int[] decompressRLElist(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i += 2) {
            total += nums[i];
        }

        int[] res = new int[total];
        int ind = 0;
        for (int i = 0; i < nums.length; i += 2) {
            int n = nums[i + 1];

            for (int j = 0; j < nums[i]; j++) {
                res[ind++] = n;
            }
        }

        return res;
    }
}
