package l819;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/19
 */
public class Solution {

    Set<String> ban = new HashSet<>();

    private int max;

    private String res;

    private Map<String, Integer> map = new HashMap<>();

    public String mostCommonWord(String paragraph, String[] banned) {
        for (String b : banned) {
            ban.add(b);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paragraph.length(); i++) {
            char ch = paragraph.charAt(i);

            if (ch >= 'a' && ch <= 'z' || (ch >= 'A' && ch <= 'Z')) {
                sb.append(Character.toLowerCase(ch));
            } else {
                if (sb.length() > 0) {
                    String str = sb.toString();
                    addWord(str);
                }
                sb.delete(0, sb.length());
            }
        }

        if (sb.length() > 0) {
            addWord(sb.toString());
        }

        return res;
    }

    private void addWord(String str) {
        if (ban.contains(str)) {
            return;
        }
        int c = map.compute(str, (k, v) -> {
            if (v == null) {
                v = 0;
            }
            return ++v;
        });
        if (c > max) {
            max = c;
            res = str;
        }
    }

    public static void main(String[] args) {
        String res = new Solution().mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
        System.out.println(res);
    }
}
