package leetcode.p1663;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/26
 */
public class Solution {

    public String getSmallestString(int n, int k) {
        char[] arr = new char[n];
        for (int i = arr.length - 1; i >= 0; i--) {
            int ch;
            if (k > 26 + i) {
                ch = 26;
            } else {
                ch = k - i;
            }
            k -= ch;
            arr[i] = (char) ('a' + ch - 1);
        }
        return new String(arr);
    }
}
