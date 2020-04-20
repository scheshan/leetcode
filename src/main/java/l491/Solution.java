package l491;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/20
 */
public class Solution {

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            dfs(res, new LinkedList<>(), new HashSet<>(), nums, i);
        }

        return new ArrayList<>(res);
    }

    private void dfs(Set<List<Integer>> res, LinkedList<Integer> path, Set<String> visited, int[] nums, int i) {
        if (i >= nums.length) {
            return;
        }

        path.addLast(nums[i]);
        String str = path.toString();

        if (!visited.contains(str)) {
            visited.add(str);

            if (path.size() > 1) {
                res.add(new ArrayList<>(path));
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] >= nums[i]) {
                    dfs(res, path, visited, nums, j);
                }
            }
        }

        path.removeLast();
    }
}
