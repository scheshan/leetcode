package l1015;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/15
 */
public class Solution {

    public int smallestRepunitDivByK(int K) {
        int n = 1;
        int length = 1;
        int mod = 0;
        boolean[] visited = new boolean[K];

        while (true) {
            mod = n % K;

            if (mod == 0) {
                return length;
            }
            if (visited[mod]) {
                return -1;
            }
            visited[mod] = true;

            n = (n * 10 + 1) % K;
            length++;
        }
    }
}
