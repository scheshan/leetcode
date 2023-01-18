package leetcode.p345;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() - 1;

        char[] arr = s.toCharArray();

        while (l < r) {
            while (l < r && !isVowel(arr[l])) {
                l++;
            }
            while (l < r && !isVowel(arr[r])) {
                r--;
            }

            if (l != r) {
                char tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
            }
            l++;
            r--;
        }

        return new String(arr);
    }

    private boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;
        }
        return false;
    }
}
