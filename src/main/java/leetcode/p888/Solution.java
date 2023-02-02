package leetcode.p888;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int s1 = 0;
        int s2 = 0;
        for (int num : aliceSizes) {
            s1 += num;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < bobSizes.length; i++) {
            map.put(bobSizes[i], i);
            s2 += bobSizes[i];
        }
        int delta = (s1 - s2) >> 1;

        for (int num : aliceSizes) {
            if (map.containsKey(num - delta)) {
                return new int[]{num, num - delta};
            }
        }
        return null;
    }
}
