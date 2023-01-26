package leetcode.p1389;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/26
 */
public class Solution {

    public int[] createTargetArray(int[] nums, int[] index) {
        int[] res = new int[nums.length];
        int r = 0;

        for (int i = 0; i < index.length; i++) {
            int ind = index[i];
            if (ind < r) {
                for (int j = r; j > ind; j--) {
                    res[j] = res[j - 1];
                }
            }
            res[ind] = nums[i];
            r++;
        }
        return res;
    }
}
