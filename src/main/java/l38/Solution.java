package l38;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/31
 */
public class Solution {

    public String countAndSay(int n) {
        String res = null;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                res = "1";
            } else {
                res = countAndSay(res);
            }
        }

        return res;
    }

    private String countAndSay(String str) {
        StringBuilder sb = new StringBuilder();

        char ch = ' ';
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ch) {
                if (count > 0) {
                    sb.append(count);
                    sb.append(ch);
                }

                ch = str.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }

        sb.append(count);
        sb.append(ch);

        return sb.toString();
    }
}
