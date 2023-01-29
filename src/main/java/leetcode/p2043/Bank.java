package leetcode.p2043;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Bank {

    long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!valid(account1) || !valid(account2)) {
            return false;
        }
        if (withdraw(account1, money)) {
            deposit(account2, money);
            return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if (!valid(account)) {
            return false;
        }
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!valid(account)) {
            return false;
        }
        if (balance[account - 1] < money) {
            return false;
        }
        balance[account - 1] -= money;
        return true;
    }

    private boolean valid(int account) {
        if (account < 1 || account - 1 >= balance.length) {
            return false;
        }
        return true;
    }
}
