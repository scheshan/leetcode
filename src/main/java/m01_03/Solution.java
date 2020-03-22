package m01_03;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder(S.length());

        for (int i = 0; i < length; i++) {
            char ch = S.charAt(i);

            if (ch == ' ') {
                sb.append("%20");
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
