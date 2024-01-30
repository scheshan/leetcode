package leetcode.p2300;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int[] res = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];

            int l = 0, r = potions.length - 1;
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                if ((long) spell * potions[mid] < success) {
                    l = mid + 1;
                } else {
                    res[i] = potions.length - mid;
                    r = mid - 1;
                }
            }
        }

        return res;
    }
}
