package leetcode.p1656;

import java.util.ArrayList;
import java.util.List;

/**
 * OrderedStream
 *
 * @author heshan
 * @date 2023/2/4
 */
public class OrderedStream {

    private String[] arr;

    private int ptr;

    public OrderedStream(int n) {
        arr = new String[n + 1];
        ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        arr[idKey] = value;
        List<String> res = new ArrayList<>();
        while (ptr < arr.length && arr[ptr] != null) {
            res.add(arr[ptr]);
            ptr++;
        }
        return res;
    }
}
