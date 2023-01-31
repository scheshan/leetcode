package interview.p01_03;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public String replaceSpaces(String S, int length) {
        int[] arr = new int[S.length()];
        int ind = 0;
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' ') {
                arr[ind++] = '%';
                arr[ind++] = '2';
                arr[ind++] = '0';
            } else {
                arr[ind++] = S.charAt(i);
            }
        }
        return new String(arr, 0, ind);
    }
}
