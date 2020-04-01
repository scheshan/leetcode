package l441;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/1
 */
public class Solution {

    public int arrangeCoins(int n) {
        int row = 0;
        while (n >= row) {
            n -= ++row;
        }

        return n < 0 ? row - 1 : row;
    }
}
