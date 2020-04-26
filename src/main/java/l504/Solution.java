package l504;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/26
 */
public class Solution {

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        boolean negative = num < 0;
        if (negative) {
            num = -num;
        }
        while (num != 0) {
            int n = num % 7;
            sb.append(n);
            num /= 7;
        }
        if (negative) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
