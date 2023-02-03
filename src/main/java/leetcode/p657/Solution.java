package leetcode.p657;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/3
 */
public class Solution {

    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
            }
        }
        return x == 0 && y == 0;
    }
}
