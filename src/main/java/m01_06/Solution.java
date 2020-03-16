package m01_06;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/16
 */
public class Solution {

    public String compressString(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }

        StringBuilder sb = new StringBuilder();
        char prev = S.charAt(0);
        int count = 1;

        for (int i = 1; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == prev) {
                count++;
            } else {
                sb.append(prev);
                sb.append(count);

                prev = ch;
                count = 1;
            }
        }

        sb.append(prev);
        sb.append(count);

        return sb.length() >= S.length() ? S : sb.toString();
    }

    public static void main(String[] args) {
        new Solution().compressString("bb");
    }
}
