package l507;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/15
 */
public class Solution {

    public boolean checkPerfectNumber(int num) {
        if (num == 0) {
            return false;
        }

        int n = 0;
        int max = num;
        for (int i = 1; i < max; i++) {
            if (num % i == 0) {
                n += i;

                int j = num / i;
                if (j > i && j != num) {
                    n += j;
                }
            }
            max = num / i;
        }

        return n == num;
    }

    public static void main(String[] args) {
        boolean res = new Solution().checkPerfectNumber(6);
        System.out.println(res);
    }
}
