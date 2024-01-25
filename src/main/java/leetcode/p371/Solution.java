package leetcode.p371;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/24
 */
public class Solution {

    public int getSum(int a, int b) {
        int res = 0;
        boolean flag = false;

        for (int i = 0; i < 32; i++) {
            int n = 1 << i;

            int n1 = a & n;
            int n2 = b & n;

            if ((n1 & n2) != 0) {
                if (flag) {
                    res |= 1 << i;
                }
                flag = true;
            } else if ((n1 | n2) != 0) {
                if (!flag) {
                    res |= 1 << i;
                }
            } else {
                if (flag) {
                    res |= 1 << i;
                }
                flag = false;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().getSum(2, 3);
    }
}
