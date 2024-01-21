package leetcode.p39;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/21
 */
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();

        backtrack(candidates, 0, res, path, target);

        return res;
    }

    private void backtrack(int[] candidates, int ind, List<List<Integer>> res, Deque<Integer> path, int target) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        if (ind == candidates.length) {
            return;
        }

        for (int i = ind; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            backtrack(candidates, i, res, path, target - candidates[i]);
            path.removeLast();
        }
    }
}
