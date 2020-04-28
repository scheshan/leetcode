package l1033;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/27
 */
public class Solution {

    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);

        int min = 0;
        int max = 0;

        if (arr[1] - arr[0] <= 2 || arr[2] - arr[1] <= 2) {
            min = 1;
        } else {
            min = 2;
        }

        max += arr[1] - arr[0] - 1;
        max += arr[2] - arr[1] - 1;
        min = Math.min(min, max);

        return new int[]{min, max};
    }

    public static void main(String[] args) {
        int[] res = new Solution().numMovesStones(4, 3, 2);
        System.out.println(Arrays.toString(res));
    }
}
