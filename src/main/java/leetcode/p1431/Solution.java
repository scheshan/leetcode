package leetcode.p1431;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>(candies.length);
        int max = 0;
        for (int num : candies) {
            max = Math.max(max, num);
        }

        for (int num : candies) {
            res.add(num + extraCandies >= max);
        }
        return res;
    }
}
