package offer.p46;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    public int translateNum(int num) {
        int cur = 1;
        int preCount = -1;
        int preNumber = -1;
        while (num > 0) {
            int n = num % 10;

            int tmp = cur;
            if (preNumber >= 0 && preCount > 0 && n > 0 && (n < 2 || (n == 2 && preNumber < 6))) {
                tmp += preCount;
            }

            num /= 10;
            preCount = cur;
            cur = tmp;
            preNumber = n;
        }

        return cur;
    }

    public static void main(String[] args) {
        new Solution().translateNum(220);
    }
}
