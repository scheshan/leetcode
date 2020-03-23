package l442;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/23
 */
public class Solution {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new LinkedList<>();

        for (int num : nums) {
            int ind = Math.abs(num) - 1;
            if (nums[ind] < 0) {
                res.add(ind + 1);
            }
            nums[ind] *= -1;
        }

        return res;
    }
}
