package leetcode.p46;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        Deque<Integer> path = new ArrayDeque<>(nums.length);
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        backtracking(nums, res, path, used);

        return res;
    }

    private void backtracking(int[] nums, List<List<Integer>> res, Deque<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            path.add(nums[i]);
            backtracking(nums, res, path, used);
            used[i] = false;
            path.removeLast();
        }
    }
}
