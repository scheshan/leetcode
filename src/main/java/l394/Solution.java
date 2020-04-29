package l394;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/25
 */
public class Solution {

    int index = 0;

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        while (index < s.length()) {
            if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                sb.append(multi(s));
            } else {
                sb.append(s.charAt(index++));
            }
        }
        return sb.toString();
    }

    private String multi(String s) {
        int n = 0;
        while (s.charAt(index) != '[') {
            n = n * 10 + s.charAt(index++) - '0';
        }
        index++;

        StringBuilder sb = new StringBuilder();
        while (s.charAt(index) != ']') {
            if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                sb.append(multi(s));
            } else {
                sb.append(s.charAt(index++));
            }
        }
        index++;

        StringBuilder res = new StringBuilder(n * sb.length());
        for (int i = 0; i < n; i++) {
            res.append(sb);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String res = new Solution().decodeString("3[a]2[b4[F]c]");
        System.out.println(res);
    }
}
