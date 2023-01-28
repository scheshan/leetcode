package offer2.p119;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int length = 1;
                while (set.contains(num + 1)) {
                    length++;
                    num++;
                }
                res = Math.max(res, length);
            }
        }
        return res;
    }
}
