package leetcode.p451;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public String frequencySort(String s) {
        Map<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int cnt = 1;

            if (count.containsKey(ch)) {
                cnt = count.get(ch) + 1;
            }
            count.put(ch, cnt);
        }

        List<Character> list = new ArrayList<>(count.keySet());
        list.sort((c1, c2) -> {
            return count.get(c2) - count.get(c1);
        });

        char[] arr = new char[s.length()];
        int ind = 0;
        for (char ch : list) {
            for (int i = 0; i < count.get(ch); i++) {
                arr[ind++] = ch;
            }
        }
        return new String(arr);
    }
}
