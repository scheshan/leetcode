package l66;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int[] plusOne(int[] digits) {
        boolean flag = true;
        int j = digits.length - 1;
        while (flag && j >= 0) {
            digits[j]++;
            if (digits[j] > 9) {
                digits[j] = 0;
            } else {
                flag = false;
            }
            j--;
        }

        if (!flag) {
            return digits;
        } else {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            int i = 1;

            for (int num : digits) {
                res[i++] = num;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        new Solution().plusOne(new int[]{9});
    }
}
