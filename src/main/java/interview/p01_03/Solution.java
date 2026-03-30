package interview.p01_03;

public class Solution {

    public String replaceSpaces(String S, int length) {
        char[] arr = S.toCharArray();
        int l = length - 1;
        int r = S.length() - 1;

        while (l >= 0) {
            if (arr[l] == ' ') {
                arr[r--] = '0';
                arr[r--] = '2';
                arr[r--] = '%';
                l--;
            } else {
                arr[r--] = arr[l--];
            }
        }

        return new String(arr, r + 1, S.length() - r - 1);
    }
}
