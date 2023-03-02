package leetcode.p869;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/2
 */
public class Solution {

    public boolean reorderedPowerOf2(int n) {
        char[] arr1 = String.valueOf(n).toCharArray();
        Arrays.sort(arr1);

        int number = 1;
        for (int i = 0; i < 32; i++) {
            String s = String.valueOf(number);
            if (s.length() == arr1.length && valid(arr1, s.toCharArray())) {
                return true;
            } else if (s.length() > arr1.length) {
                break;
            }
            number <<= 1;
        }
        return false;
    }

    private boolean valid(char[] arr1, char[] arr2) {
        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
