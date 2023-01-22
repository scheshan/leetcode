package leetcode.p217;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> exist = new HashSet<>();
        for (int num : nums) {
            if (exist.contains(num)) {
                return true;
            }
            exist.add(num);
        }
        return false;
    }
}
