package m58_i;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/19
 */
public class Solution {

    public String reverseWords(String s) {
        char[] arr = new char[s.length()];
        int ind = 0;

        boolean space = false;
        int right = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                space = true;
                if (right >= 0) {
                    for (int j = i + 1; j <= right; j++) {
                        arr[ind++] = s.charAt(j);
                    }
                    right = -1;
                }
            } else {
                if (space) {
                    if (ind > 0) {
                        arr[ind++] = ' ';
                    }
                    space = false;
                }
                if (right < 0) {
                    right = i;
                }
            }
        }

        if (right >= 0) {
            for (int j = 0; j <= right; j++) {
                arr[ind++] = s.charAt(j);
            }
        }

        return new String(arr, 0, ind);
    }
}
