package l1550;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/9/30
 */
public class Solution {

    public boolean threeConsecutiveOdds(int[] arr) {
        int cur = 0;

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & 1) == 1) {
                cur++;
            } else {
                cur = 0;
            }

            if(cur >= 3) {
                return true;
            }
        }

        return false;
    }
}
