package l39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/24
 */
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new LinkedList<>();

        perm(res, new LinkedList<>(), candidates, 0, target);

        return res;
    }

    private void perm(List<List<Integer>> res, LinkedList<Integer> list, int[] nums, int cur, int target) {
        for (int num : nums) {
            if (!list.isEmpty() && num < list.getLast()) {
                continue;
            }

            list.add(num);
            if (cur + num == target) {
                res.add(new ArrayList<>(list));
                list.removeLast();
                break;
            } else if (cur + num < target) {
                perm(res, list, nums, cur + num, target);
            }
            list.removeLast();
        }
    }
}
