package l415;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/28
 */
public class Solution {

    private boolean flag = false;

    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder(Math.max(num1.length(), num2.length()) + 1);

        int l = num1.length() - 1;
        int r = num2.length() - 1;
        while (l >= 0 && r >= 0) {
            int n = (num1.charAt(l) - '0') + (num2.charAt(r) - '0');
            append(res, n);

            r--;
            l--;
        }

        while (l >= 0) {
            int n = (num1.charAt(l) - '0');
            append(res, n);
            l--;
        }
        while (r >= 0) {
            int n = (num2.charAt(r) - '0');
            append(res, n);
            r--;
        }
        if (flag) {
            append(res, 0);
        }

        return res.reverse().toString();
    }

    private void append(StringBuilder res, int n) {
        if (flag) {
            n++;
            flag = false;
        }

        if (n >= 10) {
            n -= 10;
            flag = true;
        }

        res.append((char) (n + '0'));
    }

    public static void main(String[] args) {
        new Solution().addStrings("1", "9");
    }
}
