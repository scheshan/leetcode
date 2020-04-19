package l1262;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/19
 */
public class Solution {

    public int maxSumDivThree(int[] nums) {
        int total = 0;
        int n1 = 20000;
        int n2 = 20000;
        int n3 = 20000;
        int n4 = 20000;

        for (int n : nums) {
            total += n;

            if (n % 3 == 1) {
                if (n < n1) {
                    n2 = n1;
                    n1 = n;
                } else if (n < n2) {
                    n2 = n;
                }
            } else if (n % 3 == 2) {
                if (n < n3) {
                    n4 = n3;
                    n3 = n;
                } else if (n < n4) {
                    n4 = n;
                }
            }
        }

        if (total % 3 == 0) {
            return total;
        } else if (total % 3 == 1) {
            int min = Math.min(n1, n3 + n4);
            return Math.max(0, total - min);
        } else {
            int min = Math.min(n3, n1 + n2);
            return Math.max(0, total - min);
        }
    }

    public static void main(String[] args) {
        int res = new Solution().maxSumDivThree(new int[]{2, 6, 2, 2, 7});
        System.out.println(res);
    }
}
