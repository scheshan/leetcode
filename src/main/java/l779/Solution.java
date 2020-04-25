package l779;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/25
 */
public class Solution {

    public int kthGrammar(int N, int K) {
        if (N == 1) {
            return 0;
        }

        int n = kthGrammar(N - 1, (K + 1) / 2);
        if ((K & 1) == 0) {
            return 1 - n;
        } else {
            return n;
        }
    }
}
