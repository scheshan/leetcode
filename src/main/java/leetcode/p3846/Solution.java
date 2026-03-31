package leetcode.p3846;

public class Solution {

    public int totalDistance(String s) {
        char[][] keys = new char[][]{
                new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
                new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
                new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'},
        };

        int[][] map = new int[26][2];

        for (int i = 0; i < keys.length; i++) {
            for (int j = 0; j < keys[i].length; j++) {
                map[keys[i][j] - 'a'][0] = i;
                map[keys[i][j] - 'a'][1] = j;
            }
        }

        int[] pre = map[0];
        int res = 0;
        for (char ch : s.toCharArray()) {
            int[] cur = map[ch - 'a'];
            res += Math.abs(cur[0] - pre[0]) + Math.abs(cur[1] - pre[1]);
            pre = cur;
        }

        return res;
    }
}
