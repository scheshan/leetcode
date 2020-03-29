package l1317;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/29
 */
public class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            if (!hasZero(i) && !hasZero(n - i)) {
                return new int[]{i, n - i};
            }
        }

        return null;
    }

    private boolean hasZero(int num) {
        if (num == 0) {
            return true;
        }

        while (num > 0) {
            if (num % 10 == 0) {
                return true;
            }
            num /= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        new Solution().getNoZeroIntegers(11);
    }
}
