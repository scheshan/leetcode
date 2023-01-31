package leetcode.p1544;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public String makeGood(String s) {
        char[] arr = new char[s.length()];
        int ind = 0;
        for (int i = 0; i < s.length(); i++) {
            if (ind > 0 && Math.abs(arr[ind - 1] - s.charAt(i)) == 32) {
                ind--;
            } else {
                arr[ind++] = s.charAt(i);
            }
        }
        return new String(arr, 0, ind);
    }
}
