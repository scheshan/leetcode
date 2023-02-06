package leetcode.p1860;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/6
 */
public class Solution {

    public int[] memLeak(int memory1, int memory2) {
        int mem = 0;
        int sec = 0;
        while (true) {
            sec++;
            mem++;

            if (memory1 < mem && memory2 < mem) {
                break;
            }

            if (memory1 >= memory2) {
                memory1 -= mem;
            } else {
                memory2 -= mem;
            }
        }
        return new int[]{sec, memory1, memory2};
    }
}
