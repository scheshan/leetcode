package lcp.p01;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/2
 */
public class Solution {

    public int game(int[] guess, int[] answer) {
        int res = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                res++;
            }
        }
        return res;
    }
}
