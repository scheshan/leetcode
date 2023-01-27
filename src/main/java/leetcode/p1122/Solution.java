package leetcode.p1122;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for (int num : arr1) {
            cnt[num]++;
        }

        int[] res = new int[arr1.length];
        int ind = 0;
        for (int num : arr2) {
            for (int i = 0; i < cnt[num]; i++) {
                res[ind++] = num;
            }
            cnt[num] = 0;
        }
        for (int j = 0; j < cnt.length; j++) {
            int num = j;
            for (int i = 0; i < cnt[num]; i++) {
                res[ind++] = num;
            }
        }
        return res;
    }
}
