package l40;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/17
 */
public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        Set<String> visited = new HashSet<>();
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        for (int i = 0; i < candidates.length; i++) {
            perm(res, temp, candidates, i, target, visited);
        }

        return res;
    }

    private void perm(List<List<Integer>> res, LinkedList<Integer> temp, int[] candidates, int i, int target, Set<String> visited) {
        temp.addLast(candidates[i]);
        target -= candidates[i];
        if (target == 0) {
            String key = temp.toString();
            if (!visited.contains(key)) {
                res.add(new ArrayList<>(temp));
                visited.add(key);
            }
        } else {
            for (int j = i + 1; j < candidates.length && target >= candidates[j]; j++) {
                perm(res, temp, candidates, j, target, visited);
            }
        }

        temp.removeLast();
    }
}
