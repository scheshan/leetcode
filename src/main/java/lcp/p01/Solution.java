package lcp.p01;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int game(int[] guess, int[] answer) {
        int res = 0;
        for (int i = 0; i < guess.length; i++) {
            if (answer[i] == guess[i]) {
                res++;
            }
        }
        return res;
    }
}
