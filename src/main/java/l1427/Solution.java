package l1427;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/8
 */
public class Solution {

    public String stringShift(String s, int[][] shift) {
        int direction = shift[0][0];
        int amount = shift[0][1];
        for (int i = 1; i < shift.length; i++) {
            int[] item = shift[i];
            if (item[0] == direction) {
                amount += item[1];
            } else {
                if (amount < item[1]) {
                    direction = item[0];
                    amount = item[1] - amount;
                } else {
                    amount = amount - item[1];
                }
            }
        }

        amount = amount % s.length();
        if (amount == 0) {
            return s;
        }

        if (direction == 0) {
            return s.substring(amount) + s.substring(0, amount);
        } else {
            return s.substring(s.length() - amount) + s.substring(0, s.length() - amount);
        }
    }
}
