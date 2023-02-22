package leetcode.p1146;

import java.util.ArrayList;
import java.util.List;

/**
 * SnapshotArray
 *
 * @author heshan
 * @date 2023/2/22
 */
public class SnapshotArray {

    private class Item {
        int version;
        int value;

        public Item(int version, int value) {
            this.version = version;
            this.value = value;
        }
    }

    private int version;

    private List<Item>[] data;

    public SnapshotArray(int length) {
        data = new List[length];
    }

    public void set(int index, int val) {
        List<Item> list = data[index];
        if (list == null) {
            list = new ArrayList<>();
            data[index] = list;
        }

        if (list.size() > 0 && list.get(list.size() - 1).version == version) {
            list.get(list.size() - 1).value = val;
        } else {
            list.add(new Item(version, val));
        }
    }

    public int snap() {
        return version++;
    }

    public int get(int index, int snap_id) {
        List<Item> list = data[index];
        int res = 0;
        if (list == null) {
            return res;
        }
        int l = 0;
        int r = list.size();
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            Item item = list.get(mid);
            if (item.version == snap_id) {
                res = item.value;
                break;
            } else if (item.version < snap_id) {
                res = item.value;
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return res;
    }
}
