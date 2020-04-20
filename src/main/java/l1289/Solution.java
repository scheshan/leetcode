package l1289;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/20
 */
public class Solution {

    public int minFallingPathSum(int[][] arr) {
        int cols = arr[0].length;
        int[] dp1 = null;
        int[] dp2 = new int[cols];
        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, mi = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i].length - 1; j >= 0; j--) {
                if (i == 0) {
                    dp2[j] = arr[i][j];
                } else {
                    if (mi != j) {
                        dp2[j] = arr[i][j] + m1;
                    } else {
                        dp2[j] = arr[i][j] + m2;
                    }
                }
            }

            m1 = Integer.MAX_VALUE;
            m2 = Integer.MAX_VALUE;
            mi = -1;

            for (int j = 0; j < dp2.length; j++) {
                if (dp2[j] < m1) {
                    m2 = m1;
                    m1 = dp2[j];
                    mi = j;
                } else if (dp2[j] < m2) {
                    m2 = dp2[j];
                }
            }
            dp1 = dp2;
            dp2 = new int[cols];
        }

        return m1;
    }

    public static void main(String[] args) {
        int res = new Solution().minFallingPathSum(new int[][]{
                new int[]{-73, 61, 43, -48, -36},
                new int[]{3, 30, 27, 57, 10},
                new int[]{96, -76, 84, 59, -15},
                new int[]{5, -49, 76, 31, -7},
                new int[]{97, 91, 61, -46, 67}
        });
        System.out.println(res);
    }
}
