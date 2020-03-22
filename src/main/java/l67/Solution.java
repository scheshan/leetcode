package l67;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder(Math.max(a.length(), b.length()) + 1);

        int l = a.length() - 1;
        int r = b.length() - 1;
        boolean flag = false;

        while (l >= 0 && r >= 0) {
            int c1 = a.charAt(l) - '0';
            int c2 = b.charAt(r) - '0';

            int sum = c1 + c2;
            if (flag) {
                sum++;
            }

            sb.append(sum % 2);
            flag = sum >= 2;

            l--;
            r--;
        }
        while (l >= 0) {
            int c = a.charAt(l) - '0';
            if (flag) {
                c++;
            }

            sb.append(c % 2);
            flag = c >= 2;

            l--;
        }
        while (r >= 0) {
            int c = b.charAt(r) - '0';
            if (flag) {
                c++;
            }

            sb.append(c % 2);
            flag = c >= 2;

            r--;
        }

        if (flag) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }
}
