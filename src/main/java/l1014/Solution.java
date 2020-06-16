package l1014;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/6/17
 */
public class Solution {

    public int maxScoreSightseeingPair(int[] A) {
        int res = 0;
        int mx = A[0];

        int t1;
        int t2;

        for (int i = 1; i < A.length; i++) {
            t1 = mx + A[i] - i;
            if (t1 > res) {
                res = t1;
            }

            t2 = A[i] + i;
            if (t2 > mx) {
                mx = t2;
            }
        }

        return res;
    }
}
