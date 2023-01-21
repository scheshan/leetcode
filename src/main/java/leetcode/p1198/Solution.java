package leetcode.p1198;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public int smallestCommonElement(int[][] mat) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int col = 0; col < mat[0].length; col++) {
            for (int row = 0; row < mat.length; row++) {
                int num = mat[row][col];
                int cnt = 1;
                if (count.containsKey(num)) {
                    cnt = count.get(num) + 1;
                }
                if (cnt == mat.length) {
                    return num;
                }
                count.put(num, cnt);
            }
        }
        return -1;
    }
}
