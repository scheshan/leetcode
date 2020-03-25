package l1309;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/25
 */
public class Solution {

    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            int n = s.charAt(i) - '0';
            if (i < s.length() - 2 && s.charAt(i + 2) == '#') {
                n = n * 10 + (s.charAt(i + 1) - '0');
                i += 3;
            } else {
                i++;
            }

            sb.append((char) (n - 1 + 'a'));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        new Solution().freqAlphabets("10#11#12");
    }
}
