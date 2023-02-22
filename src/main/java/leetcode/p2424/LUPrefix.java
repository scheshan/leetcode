package leetcode.p2424;

import java.util.HashSet;
import java.util.Set;

/**
 * LUPrefix
 *
 * @author heshan
 * @date 2023/2/22
 */
public class LUPrefix {

    private int cur;

    private Set<Integer> set;

    public LUPrefix(int n) {
        cur = 0;
        set = new HashSet<>();
    }

    public void upload(int video) {
        if (video == cur + 1) {
            cur++;
            prune();
        } else {
            set.add(video);
        }
    }

    public int longest() {
        return cur;
    }

    private void prune() {
        while (set.contains(cur + 1)) {
            cur++;
            set.remove(cur);
        }
    }
}
