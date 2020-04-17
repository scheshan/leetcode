package l1051;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/18
 */
public class Solution {

    public int heightChecker(int[] heights) {
        int[] nums = heights.clone();
        Arrays.sort(nums);

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != nums[i]) {
                res++;
            }
        }

        return res;
    }
}
