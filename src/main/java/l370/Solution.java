package l370;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
 */
public class Solution {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];

        for (int[] update : updates) {
            res[update[0]] += update[2];
            if (update[1] < length - 1) {
                res[update[1] + 1] -= update[2];
            }
        }

        int n = 0;
        for (int i = 0; i < res.length; i++) {
            n += res[i];
            res[i] = n;
        }
        return res;
    }
}
