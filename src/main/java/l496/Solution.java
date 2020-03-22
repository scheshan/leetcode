package l496;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];

            int ind = -1;
            for (int j = map.get(num); j < nums2.length; j++) {
                if (nums2[j] > num) {
                    ind = nums2[j];
                    break;
                }
            }

            res[i] = ind;
        }

        return res;
    }
}
