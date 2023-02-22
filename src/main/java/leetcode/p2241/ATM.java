package leetcode.p2241;

import java.util.Arrays;

/**
 * ATM
 *
 * @author heshan
 * @date 2023/2/22
 */
public class ATM {

    private long[] count;

    private int[] amount = new int[]{20, 50, 100, 200, 500};

    public ATM() {
        count = new long[amount.length];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++) {
            count[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] res = new int[5];
        for (int i = 4; i >= 0; i--) {
            res[i] = amount / this.amount[i];
            if (res[i] > this.count[i]) {
                res[i] = (int) this.count[i];
            }
            amount -= res[i] * this.amount[i];
        }

        if (amount == 0) {
            for (int i = 0; i < res.length; i++) {
                this.count[i] -= res[i];
            }
            return res;
        } else {
            return new int[]{-1};
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.deposit(new int[]{0, 0, 1, 2, 1});
        System.out.println(Arrays.toString(atm.withdraw(600)));
        atm.deposit(new int[]{0, 1, 0, 1, 1});
        System.out.println(Arrays.toString(atm.withdraw(600)));
        System.out.println(Arrays.toString(atm.withdraw(550)));
    }
}
