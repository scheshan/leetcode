package interview.p08_04;

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

    public List<List<Integer>> subsets(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>(nums.length);
        List<List<Integer>> res = new ArrayList<>();
        perm(nums, 0, deque, res);
        return res;
    }

    private void perm(int[] nums, int ind, Deque<Integer> deque, List<List<Integer>> res) {
        res.add(new ArrayList<>(deque));

        for (int i = ind; i < nums.length; i++) {
            deque.addLast(nums[i]);
            perm(nums, i + 1, deque, res);
            deque.removeLast();
        }
    }
}
