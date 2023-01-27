package leetcode.p575;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int num : candyType) {
            set.add(num);
        }

        return Math.min(set.size(), candyType.length >> 1);
    }
}
