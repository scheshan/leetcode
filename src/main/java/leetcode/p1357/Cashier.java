package leetcode.p1357;

import java.util.HashMap;
import java.util.Map;

/**
 * Cashier
 *
 * @author heshan
 * @date 2023/2/1
 */
public class Cashier {

    private int n;

    private int discount;

    Map<Integer, Integer> prices = new HashMap<>();

    private int cur;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        for (int i = 0; i < products.length; i++) {
            this.prices.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        cur++;

        double total = 0;
        for (int i = 0; i < product.length; i++) {
            total += amount[i] * prices.get(product[i]);
        }

        if (cur == n) {
            cur = 0;
            return total - total * discount * 1.0 / 100;
        }
        return total;
    }
}
