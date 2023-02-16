package leetcode.p1957;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/16
 */
public class Solution {

    public String makeFancyString(String s) {
        char[] arr = new char[s.length()];
        int ind = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i >= 2 && s.charAt(i) == s.charAt(i - 2) && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            arr[ind++] = s.charAt(i);
        }

        return new String(arr, 0, ind);
    }
}
