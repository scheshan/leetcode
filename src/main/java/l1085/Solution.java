package l1085;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
 */
public class Solution {

    public int sumOfDigits(int[] A) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            min = Math.min(A[i], min);
        }

        int n = 0;
        while (min > 0) {
            n += min % 10;
            min /= 10;
        }

        return (n & 1) == 1 ? 0 : 1;
    }
}
