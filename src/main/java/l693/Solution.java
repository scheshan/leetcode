package l693;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/23
 */
public class Solution {

    public boolean hasAlternatingBits(int n) {
        int pre = -1;
        while (n != 0) {
            if (pre < 0) {
                pre = n & 1;
            } else {
                if (pre == (n & 1)) {
                    return false;
                }
                pre = n & 1;
            }
            n >>= 1;
        }

        return true;
    }

    public static void main(String[] args) {
        new Solution().hasAlternatingBits(5);
    }
}
