package l575;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int num : candies) {
            set.add(num);
        }

        if (set.size() > candies.length / 2) {
            return candies.length / 2;
        } else {
            return set.size();
        }
    }
}
