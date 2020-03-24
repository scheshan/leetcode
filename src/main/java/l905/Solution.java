package l905;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/24
 */
public class Solution {

    public int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length - 1;

        while (left < right) {
            while ((A[left] & 1) == 0 && left < right) {
                left++;
            }
            while ((A[right] & 1) == 1 && left < right) {
                right--;
            }

            if (left < right) {
                int t = A[left];
                A[left] = A[right];
                A[right] = t;
                left++;
                right--;
            }
        }

        return A;
    }
}
