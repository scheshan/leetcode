package m08_07;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/19
 */
public class Solution {

    public String[] permutation(String S) {
        char[] arr = S.toCharArray();
        LinkedList<String> list = new LinkedList<>();

        perm(arr, 0, list);

        String[] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.remove();
        }
        return result;
    }

    private void perm(char[] arr, int i, List<String> result) {
        if (i >= arr.length) {
            result.add(new String(arr));
            return;
        }

        for (int j = i; j < arr.length; j++) {
            swap(arr, i, j);

            perm(arr, i + 1, result);

            swap(arr, i, j);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        new Solution().permutation("qwe");
    }
}
