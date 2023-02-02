package leetcode.p1624;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public int maxLengthBetweenEqualCharacters(String s) {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        int res = -1;

        for (int i = 0; i < s.length(); i++) {
            int ind = s.charAt(i) - 'a';
            if (arr[ind] >= 0) {
                res = Math.max(i - arr[ind] - 1, res);
            } else {
                arr[ind] = i;
            }
        }
        return res;
    }
}
