package offer2.p082;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        perm(candidates, 0, new ArrayDeque<>(candidates.length), target, res);
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
            if (i > ind && candidates[i] == candidates[i - 1]) {
                continue;
            }

            deque.addLast(candidates[i]);
            perm(candidates, i + 1, deque, target - candidates[i], res);
            deque.removeLast();
        }
    }
}
