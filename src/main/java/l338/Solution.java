package l338;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/14
 */
public class Solution {

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = -1;
        }

        for (int i = 1; i <= num; i++) {
            if (result[i] >= 0) {
                continue;
            }

            int c = count(i);
            for (int j = i; j <= num; j = j << 1) {
                result[j] = c;
            }
        }

        return result;
    }

    private int count(int n) {
        int result = 0;
        while (n > 0) {
            n = n & (n - 1);
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
        new Solution().countBits(2);
    }
}
