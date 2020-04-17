package m16_21;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/17
 */
public class Solution {

    public int[] findSwapValues(int[] array1, int[] array2) {
        int t1 = 0;
        for (int num : array1) {
            t1 += num;
        }

        int t2 = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : array2) {
            t2 += num;
            set.add(num);
        }

        if (((t2 - t1) & 1) == 1) {
            return new int[0];
        }

        for (int num : array1) {
            int n = (t2 - t1 + 2 * num) / 2;
            if (set.contains(n)) {
                return new int[]{num, n};
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        new Solution().findSwapValues(
                new int[]{519, 886, 282, 382, 662, 4718, 258, 719, 494, 795},
                new int[]{52, 20, 78, 50, 38, 96, 81, 20}
        );
    }
}
