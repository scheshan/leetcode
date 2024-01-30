package leetcode.p1427;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public String stringShift(String s, int[][] shift) {
        int n = 0;
        for (int[] arr : shift) {
            if (arr[0] == 1) {
                n += arr[1];
            } else {
                n -= arr[1];
            }
        }

        n %= s.length();
        if (n < 0) {
            n += s.length();
        }

        char[] res = s.toCharArray();
        reverse(res, 0, res.length - 1);
        reverse(res, 0, n - 1);
        reverse(res, n, res.length - 1);
        return new String(res);
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char ch = arr[l];
            arr[l] = arr[r];
            arr[r] = ch;
            l++;
            r--;
        }
    }
}
