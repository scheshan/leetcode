package l1304;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int[] sumZero(int n) {
        int[] res = new int[n];

        int i = 0;
        int left = -1;
        int right = 1;

        if ((n & 1) == 1) {
            res[0] = 0;
            i++;
        }

        for (; i < n; i += 2) {
            res[i] = left--;
            res[i + 1] = right++;
        }

        return res;
    }
}
