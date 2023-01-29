package leetcode.p2089;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public List<Integer> targetIndices(int[] nums, int target) {
        int n1 = 0;
        int n2 = 0;

        for (int num : nums) {
            if (num < target) {
                n1++;
            } else if (num == target) {
                n2++;
            }
        }

        List<Integer> res = new ArrayList<>(n2);
        if (n2 == 0) {
            return res;
        }

        for (int i = n1; i < n1 + n2; i++) {
            res.add(i);
        }
        return res;
    }
}
