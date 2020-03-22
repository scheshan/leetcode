package l917;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (!isLetter(arr[left])) {
                left++;
                continue;
            }
            if (!isLetter(arr[right])) {
                right--;
                continue;
            }

            char t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;
            left++;
            right--;
        }

        return new String(arr);
    }

    private boolean isLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
}
