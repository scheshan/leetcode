package leetcode.p2241;

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
}
