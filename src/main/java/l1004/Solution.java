package l1004;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/19
 */
public class Solution {

    public int longestOnes(int[] A, int K) {
        int result = 0;

        int zero = 0;
        int count = 0;

        int left = 0;
        int right = 0;

        while (right < A.length) {
            int num = A[right];
            if (num == 1) {
                count++;
                result = Math.max(count, result);
                right++;
            } else {
                if (zero < K) {
                    count++;
                    zero++;
                    result = Math.max(count, result);
                    right++;
                } else {
                    while (zero >= K) {
                        if (A[left] == 0) {
                            zero--;
                        }
                        count--;
                        left++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        new Solution().longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
    }
}
