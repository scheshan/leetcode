package leetcode.p791;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/12
 */
public class Solution {

    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        char[] arr = new char[s.length()];
        int ind = 0;
        for (int i = 0; i < order.length(); i++) {
            for (int j = 0; j < count[order.charAt(i) - 'a']; j++) {
                arr[ind++] = order.charAt(i);
            }
            count[order.charAt(i) - 'a'] = 0;
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[ind++] = (char) ('a' + i);
            }
        }

        return new String(arr);
    }
}
