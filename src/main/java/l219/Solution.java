package l219;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (set.contains(nums[right])) {
                return true;
            }

            set.add(nums[right]);

            if (right - left == k) {
                set.remove(nums[left]);
                left++;
            }
            right++;
        }

        return false;
    }
}
