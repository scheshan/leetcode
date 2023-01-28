package interview.p08_07;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public String[] permutation(String S) {
        List<String> list = new ArrayList<>();
        perm(S.toCharArray(), 0, list);

        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void perm(char[] arr, int ind, List<String> res) {
        if (ind == arr.length) {
            res.add(new String(arr));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            swap(arr, ind, i);
            perm(arr, ind + 1, res);
            swap(arr, ind, i);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
