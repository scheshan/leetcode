package leetcode.p2526;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * DataStream
 *
 * @author heshan
 * @date 2023/2/1
 */
public class DataStream {

    private Queue<Integer> queue;

    private int value;

    private int k;

    private int cnt;

    public DataStream(int value, int k) {
        queue = new ArrayDeque<>(k + 1);
        this.value = value;
        this.k = k;
    }

    public boolean consec(int num) {
        queue.add(num);
        if (num == value) {
            cnt++;
        }

        if (queue.size() > k) {
            int n = queue.remove();
            if (n == value) {
                cnt--;
            }
        }

        return queue.size() == k && cnt == k;
    }
}
