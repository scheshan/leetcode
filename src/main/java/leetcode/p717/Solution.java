package leetcode.p717;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public boolean isOneBitCharacter(int[] bits) {
        int ind = 0;
        while (ind < bits.length) {
            if (ind == bits.length - 1) {
                return true;
            }

            if (bits[ind] == 0) {
                ind++;
            } else {
                ind += 2;
            }
        }
        return false;
    }
}
