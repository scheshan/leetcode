package m01_06;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/16
 */
public class Solution {

    public String compressString(String S) {
        StringBuilder sb = new StringBuilder();

        int slow = 0;
        while(slow < S.length()) {
            int fast = slow + 1;
            while(fast < S.length() && S.charAt(fast) == S.charAt(slow)) {
                fast++;
            }

            sb.append(S.charAt(slow));
            sb.append(fast - slow);

            slow = fast;
        }

        return sb.length() >= S.length() ? S : sb.toString();
    }

    public static void main(String[] args) {
        new Solution().compressString("bb");
    }
}
