package leetcode.p398;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    private Map<Integer, List<Integer>> map;

    private Random rnd;

    public Solution(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int ind = i;
            int num = nums[i];
            map.compute(num, (k, v) -> {
                if (v == null) {
                    v = new ArrayList<>();
                }
                v.add(ind);
                return v;
            });
        }
        rnd = new Random();
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        if (list == null) {
            return -1;
        }

        int ind = rnd.nextInt(list.size());
        return list.get(ind);
    }
}
