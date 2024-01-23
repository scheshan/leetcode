package leetcode.p67;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/23
 */
public class Solution {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder(Math.max(a.length(), b.length()) + 1);

        int l = a.length() - 1, r = b.length() - 1;
        boolean flag = false;
        while (l >= 0 || r >= 0) {
            int n = 0;
            if (l >= 0) {
                n += a.charAt(l--) - '0';
            }
            if (r >= 0) {
                n += b.charAt(r--) - '0';
            }

            if (flag) {
                n++;
                flag = false;
            }

            if (n >= 2) {
                n -= 2;
                flag = true;
            }

            sb.append(String.valueOf(n));
        }

        if (flag) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }
}
