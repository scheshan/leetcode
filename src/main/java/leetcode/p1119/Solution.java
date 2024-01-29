package leetcode.p1119;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public String removeVowels(String s) {
        char[] arr = new char[s.length()];
        int ind = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                continue;
            }
            arr[ind++] = ch;
        }
        return new String(arr, 0, ind);
    }
}
