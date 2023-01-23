package leetcode.p1134;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/23
 */
public class Solution {

    public boolean isArmstrong(int n) {
        int cnt = 0;
        int num = n;
        while (num > 0) {
            cnt++;
            num /= 10;
        }

        int sum = 0;
        num = n;
        while (num > 0) {
            sum += Math.pow(num % 10, cnt);
            num /= 10;
        }
        return sum == n;
    }
}
