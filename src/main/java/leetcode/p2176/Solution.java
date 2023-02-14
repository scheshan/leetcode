package leetcode.p2176;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.get(nums[i]);
            if (list == null) {
                list = new ArrayList<>();
                map.put(nums[i], list);
            }

            for (int pre : list) {
                if ((pre * i) % k == 0) {
                    res++;
                }
            }
            list.add(i);
        }

        return res;
    }
}
