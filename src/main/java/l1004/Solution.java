package l1004;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/19
 */
public class Solution {

    public int longestOnes(int[] A, int K) {
        int res = 0;

        int left = 0;
        int right = 0;
        int count = 0;

        while (right < A.length) {
            if (A[right] == 0) {
                count++;
            }

            while (count > K) {
                if (A[left++] == 0) {
                    count--;
                }
            }

            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
    }
}
