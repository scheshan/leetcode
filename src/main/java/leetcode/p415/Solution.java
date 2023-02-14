package leetcode.p415;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public String addStrings(String num1, String num2) {
        char[] arr = new char[Math.max(num1.length(), num2.length()) + 1];

        boolean promotion = false;
        int l = num1.length() - 1;
        int r = num2.length() - 1;
        for (int i = arr.length - 1; i >= 1; i--) {
            int n = 0;
            if (promotion) {
                n++;
                promotion = false;
            }
            if (l >= 0) {
                n += num1.charAt(l--) - '0';
            }
            if (r >= 0) {
                n += num2.charAt(r--) - '0';
            }

            if (n >= 10) {
                n -= 10;
                promotion = true;
            }
            arr[i] = (char) ('0' + n);
        }

        if (promotion) {
            arr[0] = '1';
            return new String(arr);
        } else {
            return new String(arr, 1, arr.length - 1);
        }
    }
}
