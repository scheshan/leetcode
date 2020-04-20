package l30;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/20
 */
public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0) {
            return new ArrayList<>();
        }

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int length = words[0].length();
        int n = words.length;
        List<Integer> res = new LinkedList<>();

        Map<String, Integer> found = new HashMap<>();
        for (int i = 0; i <= s.length() - n * length; i++) {
            found.clear();

            int j = 0;
            for (; j < n; j++) {
                String str = s.substring(i + j * length, i + (j + 1) * length);
                if (map.containsKey(str)) {
                    found.put(str, found.getOrDefault(str, 0) + 1);
                    if (found.get(str) > map.get(str)) {
                        break;
                    }
                } else {
                    break;
                }
            }

            if (j == n) {
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = new Solution().findSubstring(
                "wordgoodgoodgoodbestword",
                new String[]{"word", "good", "best", "good"}
        );
        System.out.println(res);
    }
}
