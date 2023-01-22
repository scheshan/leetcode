package leetcode.p1832;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public boolean checkIfPangram(String sentence) {
        int total = 0;
        boolean[] exist = new boolean[26];
        for (int i = 0; i < sentence.length(); i++) {
            int ind = sentence.charAt(i) - 'a';
            if (!exist[ind]) {
                exist[ind] = true;
                total++;
            }
        }
        return total == 26;
    }
}
