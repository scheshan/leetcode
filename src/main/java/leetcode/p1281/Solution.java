package leetcode.p1281;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public int subtractProductAndSum(int n) {
        int multiple = 1;
        int sum = 0;

        while (n > 0) {
            int num = n % 10;
            multiple *= num;
            sum += num;
            n /= 10;
        }

        return multiple - sum;
    }
}
