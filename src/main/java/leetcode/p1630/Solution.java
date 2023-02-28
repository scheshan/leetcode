package leetcode.p1630;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/28
 */
public class Solution {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>(l.length);

        for (int i = 0; i < l.length; i++) {
            int[] arr = new int[r[i] - l[i] + 1];
            System.arraycopy(nums, l[i], arr, 0, arr.length);
            Arrays.sort(arr);
            boolean valid = true;
            for (int j = 2; j < arr.length; j++) {
                if (arr[j] - arr[j - 1] != arr[1] - arr[0]) {
                    valid = false;
                    break;
                }
            }
            res.add(valid);
        }
        return res;
    }
}
