package leetcode.p39;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        perm(candidates, 0, deque, target, res);
        return res;
    }

    private void perm(int[] candidates, int ind, Deque<Integer> deque, int target, List<List<Integer>> res) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(deque));
            }
            return;
        }

        for (int i = ind; i < candidates.length; i++) {
            deque.addLast(candidates[i]);
            perm(candidates, i, deque, target - candidates[i], res);
            deque.removeLast();
        }
    }
}
