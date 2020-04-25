package l293;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/25
 */
public class Solution {

    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new LinkedList<>();
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] && arr[i] == '+') {
                change(arr, i);
                change(arr, i - 1);

                res.add(new String(arr));

                change(arr, i);
                change(arr, i - 1);
            }
        }
        return res;
    }

    private void change(char[] arr, int i) {
        if (arr[i] == '-') {
            arr[i] = '+';
        } else {
            arr[i] = '-';
        }
    }
}
