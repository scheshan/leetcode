package offer2.p041;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class MovingAverage {

    private int maxSize;
    private int size;
    private int[] queue;
    private int start;
    private int end;
    private int sum;

    public MovingAverage(int size) {
        queue = new int[size];
        this.maxSize = size;
    }

    public double next(int val) {
        if (size == maxSize) {
            sum -= queue[start];
            start++;
            if (start == queue.length) {
                start = 0;
            }
            size--;
        }
        queue[end++] = val;
        sum += val;
        if (end == queue.length) {
            end = 0;
        }
        size++;
        return sum * 1.0 / size;
    }
}
