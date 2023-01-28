package offer.p38;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public String[] permutation(String S) {
        List<String> list = new ArrayList<>();
        char[] arr = S.toCharArray();
        Arrays.sort(arr);
        perm(arr, 0, new boolean[S.length()], new char[S.length()], list);

        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void perm(char[] arr, int ind, boolean[] used, char[] path, List<String> res) {
        if (ind == arr.length) {
            res.add(new String(path));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                path[ind] = arr[i];
                perm(arr, ind + 1, used, path, res);
                used[i] = false;
            }
        }
    }
}
