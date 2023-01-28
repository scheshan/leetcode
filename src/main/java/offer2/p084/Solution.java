package offer2.p084;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new boolean[nums.length], new int[nums.length], res);
        return res;
    }

    private void backtrack(int[] nums, int ind, boolean[] used, int[] path, List<List<Integer>> res) {
        if (ind == nums.length) {
            List<Integer> list = new ArrayList<>(path.length);
            for (int num : path) {
                list.add(num);
            }
            res.add(list);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (used[i]) {
                continue;
            }

            used[i] = true;
            path[ind] = nums[i];
            backtrack(nums, ind + 1, used, path, res);
            used[i] = false;
        }
    }
}
