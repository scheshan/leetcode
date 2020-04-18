package l1356;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/18
 */
public class Solution {

    public int[] sortByBits(int[] arr) {
        int[] count = new int[10001];
        count[1] = 1;
        for (int i = 2; i <= 10000; i++) {
            int pre = i >> 1;
            count[i] = count[pre] + (i & 1);
        }

        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }

        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int d = count[o1] - count[o2];
                if (d != 0) {
                    return d;
                }
                return o1.compareTo(o2);
            }
        });

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        return res;
    }
}
