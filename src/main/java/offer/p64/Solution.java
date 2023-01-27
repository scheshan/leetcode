package offer.p64;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    private int sum;

    public int sumNums(int n) {
        dfs(n);
        return sum;
    }

    private boolean dfs(int n) {
        sum += n;
        return n > 0 && dfs(n - 1);
    }
}
