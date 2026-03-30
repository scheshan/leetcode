package leetcode.p128;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        int cur = 0;
        for (int num : nums) {
            cur = 0;
            int n = num;
            while (set.contains(n)) {
                set.remove(n);
                n--;
                cur++;
            }
            n = num + 1;
            while (set.contains(n)) {
                set.remove(n);
                n++;
                cur++;
            }

            res = Math.max(res, cur);
        }

        return res;
    }
}
