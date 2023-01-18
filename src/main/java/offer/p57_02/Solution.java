package offer.p57_02;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();

        int l = 1;
        int r = 1;
        while (l <= target >> 1) {
            int n = (l + r) * (r - l + 1) >> 1;
            while (n < target) {
                r++;
                n = (l + r) * (r - l + 1) >> 1;
            }

            while (n >= target) {
                if (n == target) {
                    int[] arr = new int[r - l + 1];
                    for (int i = l; i <= r; i++) {
                        arr[i - l] = i;
                    }
                    res.add(arr);
                }

                l++;
                n = (l + r) * (r - l + 1) >> 1;
            }
        }

        int[][] arr = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        new Solution().findContinuousSequence(9);
    }
}
