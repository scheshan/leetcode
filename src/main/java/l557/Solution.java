package l557;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public String reverseWords(String s) {
        char[] arr = new char[s.length()];
        int ind = 0;

        int l = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                for (int j = i - 1; j >= l; j--) {
                    arr[ind++] = s.charAt(j);
                }
                arr[ind++] = ' ';
                l = -1;
            } else if (l < 0) {
                l = i;
            }
        }

        if (ind < arr.length) {
            for (int j = s.length() - 1; j >= l; j--) {
                arr[ind++] = s.charAt(j);
            }
        }

        return new String(arr);
    }
}
