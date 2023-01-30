package leetcode.p2032;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] map = new int[101];
        for (int num : nums1) {
            map[num] |= 1;
        }
        for (int num : nums2) {
            map[num] |= 2;
        }
        for (int num : nums3) {
            map[num] |= 4;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            int num = map[i];
            if ((num & (num - 1)) != 0) {
                res.add(i);
            }
        }
        return res;
    }
}
