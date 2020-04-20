package l90;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/20
 */
public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> res = new HashSet<>();
        perm(res, new LinkedList<>(), nums, -1);

        return new ArrayList<>(res);
    }

    private void perm(Set<List<Integer>> res, LinkedList<Integer> path, int[] nums, int i) {
        if (i == nums.length) {
            return;
        }

        if (i != -1) {
            path.addLast(nums[i]);
        }
        res.add(new ArrayList<>(path));

        for (int j = i + 1; j < nums.length; j++) {
            perm(res, path, nums, j);
        }

        if (i != -1) {
            path.removeLast();
        }
    }
}
