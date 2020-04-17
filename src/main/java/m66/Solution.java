package m66;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/17
 */
public class Solution {

    public int[] constructArr(int[] a) {
        int[] left = new int[a.length + 1];
        int[] right = new int[a.length + 1];
        left[0] = 1;
        right[right.length - 1] = 1;

        for (int i = 0; i < a.length; i++) {
            left[i + 1] = left[i] * a[i];
        }

        for (int i = a.length - 1; i >= 0; i--) {
            right[i] = right[i + 1] * a[i];
        }

        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = left[i] * right[i + 1];
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().constructArr(new int[]{1, 2, 3, 4, 5});
    }
}
