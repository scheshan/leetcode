package leetcode.p1047;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/26
 */
public class Solution {

    public String removeDuplicates(String s) {
        char[] arr = new char[s.length()];
        int ind = -1;

        for (int i = 0; i < s.length(); i++) {
            if (ind >= 0 && arr[ind] == s.charAt(i)) {
                ind--;
            } else {
                arr[++ind] = s.charAt(i);
            }
        }
        return new String(arr, 0, ind + 1);
    }
}
