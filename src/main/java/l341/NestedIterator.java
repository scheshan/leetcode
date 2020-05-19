package l341;

import java.util.*;

/**
 * NestedIterator
 *
 * @author heshan
 * @date 2020/5/19
 */
public class NestedIterator implements Iterator<Integer> {

    private Queue<Integer> queue;

    public NestedIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();
        for (NestedInteger i : nestedList) {
            add(i);
        }
    }

    private void add(NestedInteger i) {
        if (i.isInteger()) {
            queue.add(i.getInteger());
        }

        for (NestedInteger child : i.getList()) {
            add(child);
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return queue.remove();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
