package leetcode.p1940;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        int[] count = new int[101];
        for (int[] arr : arrays) {
            for (int num : arr) {
                count[num]++;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == arrays.length) {
                res.add(i);
            }
        }
        return res;
    }
}
