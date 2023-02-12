package leetcode.p1324;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/12
 */
public class Solution {

    public List<String> printVertically(String s) {
        List<String> words = new ArrayList<>();

        int maxLength = 0;
        int ind = 0;
        while (ind < s.length()) {
            int pre = ind;
            while (ind < s.length() && s.charAt(ind) != ' ') {
                ind++;
            }
            words.add(s.substring(pre, ind));
            maxLength = Math.max(maxLength, ind - pre);
            ind++;
        }

        List<String> res = new ArrayList<>(maxLength);
        for (int i = 0; i < maxLength; i++) {
            char[] arr = new char[words.size()];
            for (int j = 0; j < words.size(); j++) {
                String word = words.get(j);
                if (i < word.length()) {
                    arr[j] = word.charAt(i);
                } else {
                    arr[j] = ' ';
                }
            }
            int r = arr.length - 1;
            while (r >= 0 && arr[r] == ' ') {
                r--;
            }
            res.add(new String(arr, 0, r + 1));
        }
        return res;
    }
}
