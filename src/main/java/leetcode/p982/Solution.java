package leetcode.p982;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/4
 */
public class Solution {

    public int countTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n1 : nums) {
            for (int n2 : nums) {
                int cnt = map.getOrDefault(n1 & n2, 0);
                map.put(n1 & n2, cnt + 1);
            }
        }

        int res = 0;
        for (int num : nums) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if ((num & entry.getKey()) == 0) {
                    res += entry.getValue();
                }
            }
        }

        return res;
    }
}
