package leetcode.p2169;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/23
 */
public class Solution {

    public int countOperations(int num1, int num2) {
        int res = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                res += num1 / num2;
                num1 = num1 % num2;
            } else {
                res += num2 / num1;
                num2 = num2 % num1;
            }
        }
        return res;
    }
}
