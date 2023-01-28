package leetcode.p1079;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        Arrays.sort(arr);
        return backtrack(arr, new boolean[tiles.length()], 0) - 1;
    }

    private int backtrack(char[] arr, boolean[] used, int ind) {
        if (ind == arr.length) {
            return 1;
        }

        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) {
                continue;
            }
            if (used[i]) {
                continue;
            }
            used[i] = true;
            res += backtrack(arr, used, ind + 1);
            used[i] = false;
        }
        return res;
    }
}
