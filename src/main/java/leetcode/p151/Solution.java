package leetcode.p151;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/12
 */
public class Solution {

    public String reverseWords(String s) {
        char[] arr = new char[s.length()];
        int ind = 0;

        int r = s.length() - 1;
        while (r >= 0) {
            while (r >= 0 && s.charAt(r) == ' ') {
                r--;
            }
            int pre = r;
            while (r >= 0 && s.charAt(r) != ' ') {
                r--;
            }

            if (r < pre) {
                if (ind > 0) {
                    arr[ind++] = ' ';
                }
                for (int j = r + 1; j <= pre; j++) {
                    arr[ind++] = s.charAt(j);
                }
            }
        }
        return new String(arr, 0, ind);
    }
}
