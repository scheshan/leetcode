package l709;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public String toLowerCase(String str) {
        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch - 'A' + 'a');
                arr[i] = ch;
            }
        }

        return new String(arr);
    }
}
