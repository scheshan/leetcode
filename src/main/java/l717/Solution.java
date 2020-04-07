package l717;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/7
 */
public class Solution {

    public boolean isOneBitCharacter(int[] bits) {
        boolean prev = false;
        int i = 0;
        while (i < bits.length) {
            if (bits[i] == 1) {
                i += 2;
                prev = false;
            } else {
                i += 1;
                prev = true;
            }
        }

        return prev;
    }
}
