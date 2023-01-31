package leetcode.p2164;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public int[] sortEvenOdd(int[] nums) {
        List<Integer> l1 = new ArrayList<>(nums.length);
        List<Integer> l2 = new ArrayList<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 1) {
                l1.add(nums[i]);
            } else {
                l2.add(nums[i]);
            }
        }
        l1.sort((o1, o2) -> Integer.compare(o2, o1));
        l2.sort(Integer::compare);

        int ind = 0;
        for (int i = 0; i < l2.size(); i++) {
            nums[ind++] = l2.get(i);
            if (i < l1.size()) {
                nums[ind++] = l1.get(i);
            }
        }
        return nums;
    }
}
