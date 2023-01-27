package leetcode.p67;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public String addBinary(String a, String b) {
        char[] arr = new char[Math.max(a.length(), b.length()) + 1];
        arr[0] = '0';

        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            char ch = '0';
            if (flag) {
                ch++;
                flag = false;
            }
            if (i < a.length()) {
                ch += a.charAt(a.length() - i - 1) - '0';
            }
            if (i < b.length()) {
                ch += b.charAt(b.length() - i - 1) - '0';
            }
            if (ch >= '2') {
                ch -= 2;
                flag = true;
            }
            arr[arr.length - i - 1] = ch;
        }

        if (arr[0] == '0') {
            return new String(arr, 1, arr.length - 1);
        }
        return new String(arr);
    }
}
