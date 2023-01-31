package leetcode.p784;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s.toCharArray(), 0, res);
        return res;
    }

    private void backtrack(char[] arr, int ind, List<String> res) {
        if (ind == arr.length) {
            res.add(new String(arr));
            return;
        }

        char ch = arr[ind];
        if (ch >= 'a' && ch <= 'z') {
            arr[ind] -= 32;
            backtrack(arr, ind + 1, res);
            arr[ind] += 32;
        } else if (ch >= 'A' && ch <= 'Z') {
            arr[ind] += 32;
            backtrack(arr, ind + 1, res);
            arr[ind] -= 32;
        }
        backtrack(arr, ind+1, res);
    }
}
