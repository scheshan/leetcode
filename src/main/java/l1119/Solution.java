package l1119;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
 */
public class Solution {

    public String removeVowels(String S) {
        char[] arr = S.toCharArray();

        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            char ch = arr[j];
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                continue;
            }

            arr[i++] = ch;
        }

        return new String(arr, 0, i);
    }
}
