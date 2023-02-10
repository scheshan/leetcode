package leetcode.p2442;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/10
 */
public class Solution {

    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            set.add(reverse(num));
        }
        return set.size();
    }

    private int reverse(int num) {
        int res = 0;
        while (num > 0) {
            res = res * 10 + (num % 10);
            num /= 10;
        }
        return res;
    }
}
