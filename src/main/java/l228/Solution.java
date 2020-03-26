package l228;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/26
 */
public class Solution {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if (nums.length == 0) {
            return res;
        }

        int start = nums[0];
        int cur = start;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur + 1) {
                cur = nums[i];
            } else {
                add(res, start, cur);
                start = nums[i];
                cur = nums[i];
            }
        }
        add(res, start, cur);

        return res;
    }

    private void add(List<String> res, int start, int cur) {
        if (start == cur) {
            res.add(String.valueOf(start));
        } else {
            res.add(start + "->" + cur);
        }
    }
}
