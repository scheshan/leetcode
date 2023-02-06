package leetcode.p1817;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/6
 */
public class Solution {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> userMap = new HashMap<>();
        for (int[] arr : logs) {
            Set<Integer> set = userMap.get(arr[0]);
            if (set == null) {
                set = new HashSet<>();
                userMap.put(arr[0], set);
            }
            set.add(arr[1]);
        }

        int[] res = new int[k];
        for (Map.Entry<Integer, Set<Integer>> entry : userMap.entrySet()) {
            res[entry.getValue().size() - 1]++;
        }
        return res;
    }
}
