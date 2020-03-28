package m58_ii;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/28
 */
public class Solution {

    public String reverseLeftWords(String s, int n) {
        int mid = n;

        char[] arr = new char[s.length()];
        int ind = 0;
        for (int i = mid; i < s.length(); i++) {
            arr[ind++] = s.charAt(i);
        }
        for (int i = 0; i < mid; i++) {
            arr[ind++] = s.charAt(i);
        }

        return new String(arr);
    }
}
