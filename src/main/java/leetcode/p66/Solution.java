package leetcode.p66;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public int[] plusOne(int[] digits) {
        int ind = digits.length - 1;
        boolean flag = true;
        while (ind >= 0) {
            if (flag) {
                digits[ind]++;
                flag = false;
            }
            if (digits[ind] >= 10) {
                digits[ind] -= 10;
                flag = true;
            }
            ind--;
        }

        if (!flag) {
            return digits;
        }

        int[] res = new int[digits.length + 1];
        res[0] = 1;
        for (int i = 0; i < digits.length; i++) {
            res[i + 1] = digits[i];
        }
        return res;
    }
}
