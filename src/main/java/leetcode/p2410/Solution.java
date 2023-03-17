package leetcode.p2410;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/17
 */
public class Solution {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int res = 0, l = 0, r = 0;
        while (l < players.length && r < trainers.length) {
            if (players[l] <= trainers[r]) {
                res++;
                l++;
                r++;
            } else {
                r++;
            }
        }

        return res;
    }
}
