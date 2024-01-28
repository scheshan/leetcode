package leetcode.p443;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public int compress(char[] chars) {
        int slow = 0, fast = 0;
        while (fast < chars.length) {
            char ch = chars[fast++];
            int cnt = 1;
            while (fast < chars.length && chars[fast] == chars[fast - 1]) {
                cnt++;
                fast++;
            }

            chars[slow++] = ch;
            if (cnt > 0) {
                String str = String.valueOf(cnt);
                for (int i = 0; i < str.length(); i++) {
                    chars[slow++] = str.charAt(i);
                }
            }
        }

        return slow;
    }
}
