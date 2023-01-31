package leetcode.p394;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/1
 */
public class Solution {

    private int ind;

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();

        while (ind < s.length() && s.charAt(ind) != ']') {
            if (s.charAt(ind) >= '0' && s.charAt(ind) <= '9') {
                sb.append(readNumber(s));
            } else {
                sb.append(s.charAt(ind++));
            }
        }
        return sb.toString();
    }

    private String readNumber(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (ind < s.length() && s.charAt(ind) != '[') {
            count = count * 10 + s.charAt(ind++) - '0';
        }
        ind++;
        String innerStr = decodeString(s);
        for (int i = 0; i < count; i++) {
            sb.append(innerStr);
        }
        ind++;
        return sb.toString();
    }
}
