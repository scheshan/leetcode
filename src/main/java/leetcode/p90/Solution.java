package leetcode.p90;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/24
 */
public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>(nums.length);
        List<List<Integer>> res = new ArrayList<>();

        backtracking(nums, 0, res, path);

        return res;
    }

    private void backtracking(int[] nums, int ind, List<List<Integer>> res, Deque<Integer> path) {
        res.add(new ArrayList<>(path));
        if (ind == nums.length) {
            return;
        }

        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i - 1]) {
                continue;
            }

            path.addLast(nums[i]);
            backtracking(nums, i + 1, res, path);
            path.removeLast();
        }
    }
}
