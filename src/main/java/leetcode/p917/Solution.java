package leetcode.p917;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();

        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            if (!isAlpha(arr[l])) {
                l++;
            } else if (!isAlpha(arr[r])) {
                r--;
            } else {
                char tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                l++;
                r--;
            }
        }
        return new String(arr);
    }

    private boolean isAlpha(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
}
