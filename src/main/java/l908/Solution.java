package l908;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/8
 */
public class Solution {

    public int smallestRangeI(int[] A, int K) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : A) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return Math.max(max - min - 2 * K, 0);
    }
}
