package m16_07;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/9
 */
public class Solution {

    public int maximum(int a, int b) {
        long x = a;
        long y = b;

        int[] arr = new int[]{a, b};
        long z = x - y;
        int i = (int) (z >>> 63);

        return arr[i];
    }

    public static void main(String[] args) {
        new Solution().maximum(-73383683, -2537);
    }
}
