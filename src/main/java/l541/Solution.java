package l541;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public String reverseStr(String s, int k) {
        char[] arr = new char[s.length()];
        int ind = 0;

        for (int i = 0; i < s.length(); i += k * 2) {
            int mid = Math.min(s.length() - 1, i + k - 1);
            for (int j = mid; j >= i; j--) {
                arr[ind++] = s.charAt(j);
            }

            if (mid < s.length()) {
                int end = Math.min(s.length(), mid + k + 1);
                for (int j = mid + 1; j < end; j++) {
                    arr[ind++] = s.charAt(j);
                }
            }
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        new Solution().reverseStr("abcdefg", 2);
    }
}
