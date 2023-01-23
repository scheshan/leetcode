package leetcode.p293;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/23
 */
public class Solution {

    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> res = new ArrayList<>();

        char[] arr = new char[currentState.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = currentState.charAt(i);
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] && arr[i] == '+') {
                arr[i - 1] = '-';
                arr[i] = '-';
                res.add(new String(arr));
                arr[i - 1] = '+';
                arr[i] = '+';
            }
        }
        return res;
    }
}
