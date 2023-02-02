package leetcode.p1002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public List<String> commonChars(String[] words) {
        int[] arr = new int[26];
        Arrays.fill(arr, Integer.MAX_VALUE);
        int[] cnt = new int[26];

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                cnt[word.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                arr[i] = Math.min(arr[i], cnt[i]);
                cnt[i] = 0;
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < arr[i]; j++) {
                res.add(String.valueOf((char) ('a' + i)));
            }
        }
        return res;
    }
}
