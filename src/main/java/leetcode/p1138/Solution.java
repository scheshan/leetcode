package leetcode.p1138;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/12
 */
public class Solution {

    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        char pre = 'a';
        for (int i = 0; i < target.length(); i++) {
            find(pre, target.charAt(i), sb);
            pre = target.charAt(i);
        }
        return sb.toString();
    }

    private void find(char x, char y, StringBuilder sb) {
        int row1 = (x - 'a') / 5;
        int col1 = (x - 'a') % 5;

        int row2 = (y - 'a') / 5;
        int col2 = (y - 'a') % 5;

        if (row1 == 5 && row1 != row2) {
            sb.append('U');
            row1--;
        }

        for (int i = Math.min(col1, col2); i < Math.max(col1, col2); i++) {
            sb.append(col1 > col2 ? 'L' : 'R');
        }
        for (int i = Math.min(row1, row2); i < Math.max(row1, row2); i++) {
            sb.append(row1 > row2 ? 'U' : 'D');
        }
        sb.append('!');
    }
}
