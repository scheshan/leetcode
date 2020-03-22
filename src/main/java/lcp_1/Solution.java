package lcp_1;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
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
