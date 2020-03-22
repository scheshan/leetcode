package l1287;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int findSpecialInteger(int[] arr) {
        int window = arr.length / 4;
        if (arr.length % 4 > 0) {
            window++;
        }

        int left = 0;
        int right = left + window;

        while (right < arr.length) {
            if (arr[left] == arr[right]) {
                return arr[left];
            }

            left++;
            right++;
        }

        return arr[left];
    }

    public static void main(String[] args) {
        new Solution().findSpecialInteger(new int[]{1});
    }
}
