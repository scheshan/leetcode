package l1087;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/25
 */
public class Solution {

    public String[] expand(String S) {
        Set<String> res = new TreeSet<>();
        perm(res, new StringBuilder(), S, 0);

        String[] result = new String[res.size()];
        int i = 0;
        for (String str : res) {
            result[i++] = str;
        }
        return result;
    }

    private void perm(Set<String> res, StringBuilder sb, String S, int i) {
        if (i == S.length()) {
            res.add(sb.toString());
            return;
        }

        List<Character> chs = new LinkedList<>();
        int j = i;
        if (S.charAt(i) == '{') {
            while (S.charAt(j) != '}') {
                chs.add(S.charAt(j + 1));
                j += 2;
            }
        } else {
            chs.add(S.charAt(i));
        }

        for (char ch : chs) {
            sb.append(ch);
            perm(res, sb, S, j + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String[] res = new Solution().expand("{a,b}c{d,e}f");
        System.out.println(Arrays.toString(res));
    }
}
