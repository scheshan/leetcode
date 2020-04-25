package m38;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/25
 */
public class Solution {

    public String[] permutation(String S) {
        char[] arr = S.toCharArray();
        Set<String> res = new HashSet<>();

        perm(res, arr, 0);

        String[] result = new String[res.size()];
        int i = 0;
        for (String str : res) {
            result[i++] = str;
        }
        return result;
    }

    private void perm(Set<String> res, char[] arr, int i) {
        if (i == arr.length) {
            res.add(new String(arr));
        }

        for (int j = i; j < arr.length; j++) {
            swap(arr, i, j);

            perm(res, arr, i + 1);

            swap(arr, i, j);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
