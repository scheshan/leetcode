package m64;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/21
 */
public class Solution {

    int total;

    public int sumNums(int n) {
        sum(n);

        return total;
    }

    private int sum(int n) {
        total += n;

        boolean b = n > 0 && sum(n - 1) > 0;

        return n;
    }

    public static void main(String[] args) {
        int res = new Solution().sumNums(9);
        System.out.println(res);
    }
}
