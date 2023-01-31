package leetcode.p1576;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public String modifyString(String s) {
        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                char ch = 'a';
                while ((i > 0 && ch == arr[i - 1]) || (i < s.length() - 1 && ch == s.charAt(i + 1))) {
                    ch++;
                    if (ch > 'z') {
                        ch = 'a';
                    }
                }
                arr[i] = ch;
            } else {
                arr[i] = s.charAt(i);
            }
        }
        return new String(arr);
    }
}
