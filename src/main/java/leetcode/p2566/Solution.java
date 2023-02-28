package leetcode.p2566;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/28
 */
public class Solution {

    public int minMaxDifference(int num) {
        char[] arr = String.valueOf(num).toCharArray();

        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (arr[i] == arr[0]) {
                ch = '0';
            }
            min = min * 10 + (ch - '0');
        }

        int max = 0;
        int ind = 0;
        while (ind < arr.length && arr[ind] == '9') {
            ind++;
        }
        if (ind >= arr.length) {
            for (int i = 0; i < arr.length; i++) {
                max = max * 10 + 9;
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == arr[ind]) {
                    max = max * 10 + 9;
                } else {
                    max = max * 10 + (arr[i] - '0');
                }
            }
        }

        return max - min;
    }
}
