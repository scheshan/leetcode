package l660;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/27
 */
public class Solution {

    public int newInteger(int n) {
        String res = "";

        int level = 1;
        while (n > 0) {
            res = (n % 9) + res;
            n /= 9;
        }
        return Integer.parseInt(res);
    }
}
