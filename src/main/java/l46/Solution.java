package l46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/19
 */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        perm(nums, 0, result);

        return result;
    }

    private void perm(int[] nums, int i, List<List<Integer>> result) {
        if (i >= nums.length) {
            List<Integer> item = new ArrayList<>(nums.length);
            for (int num : nums) {
                item.add(num);
            }
            result.add(item);
            return;
        }

        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);

            perm(nums, i + 1, result);

            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }

        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
