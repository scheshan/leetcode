package l1217;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/18
 */
public class Solution {

    public int minCostToMoveChips(int[] chips) {
        int n1 = 0, n2 = 0;

        for (int num : chips) {
            if ((num & 1) == 1) {
                n1++;
            } else {
                n2++;
            }
        }
        return Math.min(n1, n2);
    }
}
