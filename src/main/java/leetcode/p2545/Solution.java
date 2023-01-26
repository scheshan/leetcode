package leetcode.p2545;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/26
 */
public class Solution {

    public int[][] sortTheStudents(int[][] score, int k) {
        int[] ks = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            ks[i] = score[i][k];
        }
        Arrays.sort(ks);

        int[][] res = new int[score.length][];
        for (int i = 0; i < score.length; i++) {
            int s = score[i][k];
            int ind = score.length - findIndex(ks, s) - 1;
            res[ind] = score[i];
        }
        return res;
    }

    private int findIndex(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return -1;
    }
}
