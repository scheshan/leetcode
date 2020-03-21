package l860;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    public boolean lemonadeChange(int[] bills) {
        int[] coins = new int[2];

        for (int bill : bills) {
            if (bill == 5) {
                coins[0]++;
            } else if (bill == 10) {
                if (coins[0] == 0) {
                    return false;
                }

                coins[1]++;
                coins[0]--;
            } else {
                int d = 15;
                if (coins[1] > 0) {
                    d -= 10;
                    coins[1]--;
                }

                int n = d / 5;
                if (coins[0] < n) {
                    return false;
                }
                coins[0] -= n;
            }
        }

        return true;
    }
}
