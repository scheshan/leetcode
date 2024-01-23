package leetcode.p151;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/23
 */
public class Solution {

    public String reverseWords(String s) {
        char[] arr = new char[s.length()];
        int ind = 0;

        int end = s.length() - 1, start = 0;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        while (start < s.length() && s.charAt(start) == ' ') {
            start++;
        }

        int r = end;

        while (r >= start) {
            if (r >= start && s.charAt(r) == ' ') {
                while (r >= 0 && s.charAt(r) == ' ') {
                    r--;
                }
                arr[ind++] = ' ';
            }

            if (r >= start && s.charAt(r) != ' ') {
                int e = r;
                while (r >= 0 && s.charAt(r) != ' ') {
                    r--;
                }

                for (int i = r + 1; i <= e; i++) {
                    arr[ind++] = s.charAt(i);
                }
            }
        }

        return new String(arr, 0, ind);
    }
}
