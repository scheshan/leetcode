package leetcode.p448;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num : nums) {
            if (num < 0) {
                num = -num;
            }
            if (nums[num - 1] > 0) {
                nums[num - 1] = -nums[num - 1];
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
