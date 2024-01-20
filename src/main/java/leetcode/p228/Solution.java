package leetcode.p228;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/20
 */
public class Solution {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        if (nums.length == 0) {
            return res;
        }

        int start = nums[0];
        int end = start;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num == end + 1) {
                end = num;
            } else {
                if (start == end) {
                    res.add(String.valueOf(start));
                } else {
                    res.add(start + "->" + end);
                }

                start = num;
                end = num;
            }
        }

        if (start == end) {
            res.add(String.valueOf(start));
        } else {
            res.add(start + "->" + end);
        }

        return res;
    }
}
