package leetcode.p383;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/20
 */
public class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        int[] cnt = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            cnt[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (cnt[ransomNote.charAt(i) - 'a'] <= 0) {
                return false;
            }
            cnt[ransomNote.charAt(i) - 'a']--;
        }
        return true;
    }
}
