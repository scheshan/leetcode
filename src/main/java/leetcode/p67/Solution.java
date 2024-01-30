package leetcode.p67;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public String addBinary(String a, String b) {
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        int l = a.length() - 1, r = b.length() - 1;

        while (l >= 0 || r >= 0 || flag) {
            int n = 0;
            if (flag) {
                n++;
                flag = false;
            }
            if (l >= 0) {
                n += a.charAt(l--) - '0';
            }
            if (r >= 0) {
                n += b.charAt(r--) - '0';
            }

            if (n >= 2) {
                n -= 2;
                flag = true;
            }

            sb.append(n);
        }

        return sb.reverse().toString();
    }
}
