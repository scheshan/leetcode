package leetcode.p2390;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public String removeStars(String s) {
        char[] arr = s.toCharArray();
        int slow = 0, fast = 0;

        while (fast < arr.length) {
            if (arr[fast] == '*') {
                slow--;
                slow = Math.max(0, slow);
            } else {
                arr[slow++] = arr[fast];
            }
            fast++;
        }

        return new String(arr, 0, slow);
    }
}
