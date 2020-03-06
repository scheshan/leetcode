package m57_02;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/6
 */
public class Solution {

    public int[][] findContinuousSequence(int target) {
        int l = 1, r = l;

        int sum = 0;

        List<int[]> list = new LinkedList<>();

        while (l <= target / 2) {
            if (sum < target) {
                sum += r++;
            } else if (sum > target) {
                sum -= l++;
            } else {
                int[] arr = new int[r - l];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = l + i;
                }
                list.add(arr);

                sum -= l++;
            }
        }

        int[][] result = new int[list.size()][];
        int i = 0;
        for (int[] item : list) {
            result[i++] = item;
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().findContinuousSequence(9);
    }
}
