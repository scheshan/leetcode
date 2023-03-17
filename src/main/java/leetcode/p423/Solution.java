package leetcode.p423;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/17
 */
public class Solution {

    public String originalDigits(String s) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }

        int[] cnt = new int[10];
        cnt[8] = map['g' - 'a'];
        cnt[4] = map['u' - 'a'];
        cnt[2] = map['w' - 'a'];
        cnt[6] = map['x' - 'a'];
        cnt[0] = map['z' - 'a'];
        cnt[7] = map['s' - 'a'] - cnt[6];
        cnt[5] = map['f' - 'a'] - cnt[4];
        cnt[3] = map['h' - 'a'] - cnt[8];
        cnt[1] = map['o' - 'a'] - cnt[0] - cnt[2] - cnt[4];
        cnt[9] = map['i' - 'a'] - cnt[5] - cnt[6] - cnt[8];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                sb.append((char) ('0' + i));
            }
        }
        return sb.toString();
    }
}
