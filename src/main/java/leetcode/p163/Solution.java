package leetcode.p163;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/10
 */
public class Solution {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();

        if (nums.length == 0) {
            append(res, lower, upper);
            return res;
        }

        int last = lower - 1;
        for (int num : nums) {
            if (num > last + 1) {
                append(res, last + 1, num - 1);
            }
            last = num;
        }

        if (upper > last) {
            append(res, last + 1, upper);
        }
        return res;
    }

    private void append(List<String> list, int start, int end) {
        if (start < end) {
            list.add(String.format("%s->%s", start, end));
        } else {
            list.add(String.valueOf(start));
        }
    }
}
