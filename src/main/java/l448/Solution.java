package l448;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int n : nums) {
            n = Math.abs(n);

            if (nums[n - 1] > 0) {
                nums[n - 1] *= -1;
            }
        }

        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }
}
