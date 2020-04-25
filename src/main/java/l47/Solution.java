package l47;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/25
 */
public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        perm(res, new LinkedList<>(), nums, 0);

        return new ArrayList<>(res);
    }

    private void perm(Set<List<Integer>> res, LinkedList<Integer> path, int[] nums, int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            path.addLast(nums[i]);

            perm(res, path, nums, i + 1);

            swap(nums, i, j);
            path.removeLast();
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
