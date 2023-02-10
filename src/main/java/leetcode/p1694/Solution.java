package leetcode.p1694;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/3
 */
public class Solution {

    public String reformatNumber(String number) {
        int cnt = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) >= '0' && number.charAt(i) <= '9') {
                cnt++;
            }
        }
        int left = 0;
        int right = 0;
        if (cnt % 3 == 1) {
            right = 4;
        } else if (cnt % 3 == 2) {
            right = 2;
        } else {
            right = 0;
        }
        left = cnt - right;

        StringBuilder sb = new StringBuilder();
        int ind = 0;
        while (left > 0) {
            ind = readN(sb, number, ind, 3);
            left -= 3;
        }

        if (right == 4) {
            ind = readN(sb, number, ind, 2);
            readN(sb, number, ind, 2);
        } else if (right == 2) {
            readN(sb, number, ind, 2);
        }
        return sb.toString();
    }

    private int readN(StringBuilder sb, String number, int ind, int n) {
        if (sb.length() > 0) {
            sb.append("-");
        }
        for (int i = 0; i < n; i++) {
            while (number.charAt(ind) < '0' || number.charAt(ind) > '9') {
                ind++;
            }
            sb.append(number.charAt(ind++));
        }
        return ind;
    }
}
