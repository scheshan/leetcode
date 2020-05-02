package l5384;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/3
 */
public class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>(candies.length);

        int max = candies[0];
        for (int i = 1; i < candies.length; i++) {
            max = Math.max(candies[i], max);
        }

        for (int i = 0; i < candies.length; i++) {
            res.add(max - candies[i] <= extraCandies);
        }
        return res;
    }
}
