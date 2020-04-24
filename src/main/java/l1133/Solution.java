package l1133;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
 */
public class Solution {

    public int largestUniqueNumber(int[] A) {
        int[] count = new int[1001];
        for (int n : A) {
            count[n]++;
        }

        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] == 1) {
                return i;
            }
        }
        return -1;
    }
}
