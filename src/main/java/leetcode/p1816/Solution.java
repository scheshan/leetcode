package leetcode.p1816;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public String truncateSentence(String s, int k) {
        char[] arr = s.toCharArray();
        int i = 0;
        for (; i < arr.length && k > 0; i++) {
            if (arr[i] == ' ') {
                k--;
            }
        }
        if (k == 0) {
            i--;
        }
        return new String(arr, 0, i);
    }
}
