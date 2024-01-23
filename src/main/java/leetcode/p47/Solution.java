package leetcode.p47;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/24
 */
public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            path.addLast(nums[i]);

            backtracking(nums, res, path, used);

            used[i] = false;
            path.removeLast();
        }
    }
}
