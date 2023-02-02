package leetcode.p1491;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public double average(int[] salary) {
        Integer min = Integer.MAX_VALUE;
        Integer max = Integer.MIN_VALUE;

        int total = 0;
        for (int num : salary) {
            total += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return (total - min - max) * 1.0 / (salary.length - 2);
    }
}
