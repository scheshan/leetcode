package leetcode.p2390;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public String removeStars(String s) {
        char[] arr = new char[s.length()];
        int ind = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                arr[ind++] = s.charAt(i);
            } else {
                ind--;
            }
        }
        return new String(arr, 0, ind);
    }
}
