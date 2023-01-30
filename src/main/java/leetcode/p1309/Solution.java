package leetcode.p1309;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public String freqAlphabets(String s) {
        char[] arr = new char[s.length()];
        int ind = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                arr[ind++] = (char) (s.charAt(i) - '1' + 'a');
            } else {
                ind -= 2;
                int num = (arr[ind] - 'a' + 1) * 10 + arr[ind + 1] - 'a' + 1;
                char ch = (char) (num - 10 + 'j');
                arr[ind++] = ch;
            }
        }
        return new String(arr, 0, ind);
    }
}
