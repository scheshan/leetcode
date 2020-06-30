package l1491;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/6/30
 */
public class Solution {

    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int total = 0;
        for (int n : salary) {
            total += n;
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        total -= min;
        total -= max;

        return total * 1.0 / (salary.length - 2);
    }
}
