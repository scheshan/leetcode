package l186;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
 */
public class Solution {

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);

        int start = -1;
        for (int i = 0; i < s.length; i++) {
            if (start == -1) {
                start = i;
            } else if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = -1;
            }
        }
        reverse(s, start, s.length - 1);
    }

    private void reverse(char[] s, int left, int right) {
        while (left < right) {
            swap(s, left++, right--);
        }
    }

    private void swap(char[] s, int i, int j) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
}
