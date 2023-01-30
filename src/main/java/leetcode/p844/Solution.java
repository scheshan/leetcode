package leetcode.p844;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public boolean backspaceCompare(String s, String t) {
        return replace(s).equals(replace(t));
    }

    private String replace(String s) {
        char[] arr = new char[s.length()];
        int ind = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                arr[ind++] = s.charAt(i);
            } else if (ind > 0) {
                ind--;
            }
        }
        return new String(arr, 0, ind);
    }
}
