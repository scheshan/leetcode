package m08_05;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/24
 */
public class Solution {

    public int multiply(int A, int B) {
        int res = 0;
        for (int i = 0; i < Math.min(A, B); i++) {
            res += Math.max(A, B);
        }
        return res;
    }
}
