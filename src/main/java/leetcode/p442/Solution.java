package leetcode.p442;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);

        for (int num : nums) {
            int ind = Math.abs(num) - 1;
            if (nums[ind] < 0) {
                res.add(Math.abs(num));
            } else {
                nums[ind] *= -1;
            }
        }
        return res;
    }
}
