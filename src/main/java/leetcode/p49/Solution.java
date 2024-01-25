package leetcode.p49;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/25
 */
public class Solution {

    int[] cnt = new int[26];

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = sort(str);
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

    private String sort(String str) {
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                sb.append('a' + i);
                sb.append(cnt[i]);
            }
        }

        Arrays.fill(cnt, 0);

        return sb.toString();
    }
}
