package l345;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public String reverseVowels(String s) {
        char[] arr = new char[s.length()];
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            if (match(l) && match(r)) {
                arr[left++] = r;
                arr[right--] = l;
            } else if (match(l)) {
                arr[right--] = r;
            } else {
                arr[left++] = l;
            }
        }

        return new String(arr);
    }

    private boolean match(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
