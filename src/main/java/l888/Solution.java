package l888;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/7
 */
public class Solution {

    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        for (int num : A) {
            sumA += num;
        }

        int sumB = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : B) {
            sumB += num;
            set.add(num);
        }

        for (int x : A) {
            int y = x - (sumA - sumB) / 2;
            if (set.contains(y)) {
                return new int[]{x, y};
            }
        }
        return null;
    }
}
