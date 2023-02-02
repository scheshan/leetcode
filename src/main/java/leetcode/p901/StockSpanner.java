package leetcode.p901;

/**
 * StockSpanner
 *
 * @author heshan
 * @date 2023/2/2
 */
public class StockSpanner {

    private int[][] arr;

    private int ind;

    private int day;

    public StockSpanner() {
        arr = new int[10001][2];
    }

    public int next(int price) {
        while (ind > 0 && arr[ind - 1][1] <= price) {
            ind--;
        }

        day++;
        int res;
        if (ind > 0) {
            res = day - arr[ind - 1][0];
        } else {
            res = day;
        }
        arr[ind][0] = day;
        arr[ind][1] = price;
        ind++;
        return res;
    }
}
