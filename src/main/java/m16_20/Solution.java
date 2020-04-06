package m16_20;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/6
 */
public class Solution {

    public List<String> getValidT9Words(String num, String[] words) {
        List<String> res = new LinkedList<>();

        int[][] map = buildMap();

        for (String word : words) {
            word = word.toLowerCase();
            boolean valid = true;
            for (int i = 0; i < word.length(); i++) {
                if (map[num.charAt(i) - '0'][word.charAt(i) - 'a'] == 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                res.add(word);
            }
        }

        return res;
    }

    private int[][] buildMap() {
        int[][] map = new int[10][26];
        map[2][0] = 1;
        map[2][1] = 1;
        map[2][2] = 1;
        map[3][3] = 1;
        map[3][4] = 1;
        map[3][5] = 1;
        map[4][6] = 1;
        map[4][7] = 1;
        map[4][8] = 1;
        map[5][9] = 1;
        map[5][10] = 1;
        map[5][11] = 1;
        map[6][12] = 1;
        map[6][13] = 1;
        map[6][14] = 1;
        map[7][15] = 1;
        map[7][16] = 1;
        map[7][17] = 1;
        map[7][18] = 1;
        map[8][19] = 1;
        map[8][20] = 1;
        map[8][21] = 1;
        map[9][22] = 1;
        map[9][23] = 1;
        map[9][24] = 1;
        map[9][25] = 1;

        return map;
    }
}
