package m08_01;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/5
 */
public class Solution {

    public int waysToStep(int n) {
        if (n == 0) {
            return 0;
        }

        long[] arr = new long[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;

        if (n <= 3) {
            return (int)arr[n - 1];
        }

        for (int i = 4; i <= n; i++) {
            long t = (arr[0] + arr[1] + arr[2]) % 1000000007;
            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = t;
        }

        return (int)arr[2];
    }
}
