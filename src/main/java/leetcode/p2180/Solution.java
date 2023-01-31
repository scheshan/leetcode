package leetcode.p2180;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public int countEven(int num) {
        int res = 0;
        for (int i = 1; i <= num; i++) {
            if (isEven(i)) {
                res++;
            }
        }
        return res;
    }

    private boolean isEven(int num) {
        int total = 0;
        while (num > 0) {
            total += num % 10;
            num /= 10;
        }
        return (total & 1) == 0;
    }
}
