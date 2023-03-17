package leetcode.p1352;

import java.util.ArrayList;
import java.util.List;

/**
 * ProductOfNumbers
 *
 * @author heshan
 * @date 2023/3/16
 */
public class ProductOfNumbers {

    private List<Integer> numbers;

    private int cur;

    public ProductOfNumbers() {
        numbers = new ArrayList<>();
        cur = 1;
        numbers.add(cur);
    }

    public void add(int num) {
        if (num == 0) {
            numbers.clear();
            cur = 1;
            numbers.add(cur);
        } else {
            cur *= num;
            numbers.add(cur);
        }
    }

    public int getProduct(int k) {
        if (numbers.size() <= k) {
            return 0;
        }

        return numbers.get(numbers.size() - 1) / numbers.get(numbers.size() - 1 - k);
    }
}
