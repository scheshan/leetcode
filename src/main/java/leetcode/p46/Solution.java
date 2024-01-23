package leetcode.p46;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/24
 */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        Deque<Integer> path = new ArrayDeque<>(nums.length);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtracking(nums, res, path, used);

        return res;
    }

    private void backtracking(int[] nums, List<List<Integer>> res, Deque<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.addLast(nums[i]);

                backtracking(nums, res, path, used);

                used[i] = false;
                path.removeLast();
            }
        }
    }
}
