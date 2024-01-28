package leetcode.p345;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public String reverseVowels(String s) {
        char[] arr = new char[s.length()];

        int l = 0, r = s.length() - 1;
        while (l <= r) {
            while (l < r && !isVowel(s.charAt(l))) {
                arr[l] = s.charAt(l);
                l++;
            }
            while (l < r && !isVowel(s.charAt(r))) {
                arr[r] = s.charAt(r);
                r--;
            }
            if (l <= r) {
                arr[l] = s.charAt(r);
                arr[r] = s.charAt(l);
                l++;
                r--;
            }
        }

        return new String(arr);
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
