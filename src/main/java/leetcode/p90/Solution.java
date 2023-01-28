package leetcode.p90;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayDeque<>(nums.length), res);
        return res;
    }

    private void backtrack(int[] nums, int ind, Deque<Integer> deque, List<List<Integer>> res) {
        res.add(new ArrayList<>(deque));
        if (ind == nums.length) {
            return;
        }

        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i - 1]) {
                continue;
            }

            deque.addLast(nums[i]);
            backtrack(nums, i + 1, deque, res);
            deque.removeLast();
        }
    }
}
