package leetcode.p1426;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public int countElements(int[] arr) {
        int[] count = new int[1001];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int res = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i - 1] > 0 && count[i] > 0) {
                res += count[i - 1];
            }
        }
        return res;
    }
}
