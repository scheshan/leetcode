package leetcode.p824;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public String toGoatLatin(String sentence) {
        StringBuilder sb = new StringBuilder();

        int cnt = 1;
        int l = 0;
        int r = 0;
        while (r < sentence.length()) {
            while (r < sentence.length() && sentence.charAt(r) != ' ') {
                r++;
            }
            if (isVowel(sentence.charAt(l))) {
                sb.append(sentence, l, r);
            } else {
                sb.append(sentence, l + 1, r);
                sb.append(sentence.charAt(l));
            }
            sb.append("ma");
            for (int i = 0; i < cnt; i++) {
                sb.append('a');
            }

            r++;
            cnt++;
            if (r < sentence.length()) {
                sb.append(' ');
            }
            l = r;
        }
        return sb.toString();
    }

    private boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;
        }
        return false;
    }
}
