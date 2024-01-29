package leetcode.p49;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        int[] cnt = new int[26];

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            Arrays.fill(cnt, 0);
            for (int i = 0; i < str.length(); i++) {
                cnt[str.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] > 0) {
                    sb.append((char) ('a' + i));
                    sb.append(cnt[i]);
                }
            }

            String key = sb.toString();
            map.compute(key, (k, v) -> {
                if (v == null) {
                    v = new ArrayList<>();
                }
                v.add(str);
                return v;
            });
        }

        List<List<String>> res = new ArrayList<>(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }
}
