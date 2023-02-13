package leetcode.p228;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/13
 */
public class Solution {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        int pre = nums[0];
        int cur = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != cur + 1) {
                if (cur == pre) {
                    res.add(String.valueOf(cur));
                } else {
                    res.add(String.format("%s->%s", pre, cur));
                }
                pre = nums[i];
            }
            cur = nums[i];
        }

        if (cur == pre) {
            res.add(String.valueOf(cur));
        } else {
            res.add(String.format("%s->%s", pre, cur));
        }
        return res;
    }
}
