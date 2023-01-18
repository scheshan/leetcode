package leetcode.p1346;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (i < arr.length - 1 && arr[i + 1] == 0) {
                    return true;
                }
                continue;
            }
            if (find(arr, arr[i] << 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean find(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return false;
    }
}
