package leetcode.p2483;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/12
 */
public class Solution {

    public int bestClosingTime(String customers) {
        int n1 = 0, n2 = 0;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                n2++;
            }
        }

        int min = n2;
        int res = 0;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'N') {
                n1++;
            } else {
                n2--;
            }

            int d = n1 + n2;
            if (d < min) {
                res = i + 1;
                min = d;
            }
        }
        return res;
    }
}
