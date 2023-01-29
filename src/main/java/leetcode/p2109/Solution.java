package leetcode.p2109;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public String addSpaces(String s, int[] spaces) {
        char[] arr = new char[s.length() + spaces.length];
        int ind = 0;

        Arrays.sort(spaces);
        int l = 0;
        int r = 0;
        while (l < s.length() || r < spaces.length) {
            if (r < spaces.length && l == spaces[r]) {
                r++;
                arr[ind++] = ' ';
            } else {
                arr[ind++] = s.charAt(l);
                l++;
            }
        }
        return new String(arr);
    }
}
