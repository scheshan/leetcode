package m08_04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/24
 */
public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        perm(res, new LinkedList<>(), nums, -1);

        return res;
    }

    private void perm(List<List<Integer>> res, LinkedList<Integer> list, int[] nums, int i) {
        if (i >= 0) {
            list.add(nums[i]);
        }

        res.add(new ArrayList<>(list));
        for (int j = i + 1; j < nums.length; j++) {
            perm(res, list, nums, j);
        }

        if (i >= 0) {
            list.removeLast();
        }
    }
}
