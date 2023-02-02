package leetcode.p341;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * NestedIterator
 *
 * @author heshan
 * @date 2023/2/2
 */
public class NestedIterator implements Iterator<Integer> {

    private Deque<NestedInteger> deque;

    public NestedIterator(List<NestedInteger> nestedList) {
        deque = new ArrayDeque<>();
        addList(nestedList);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }

        while (!deque.isEmpty() && !deque.peekLast().isInteger()) {
            List<NestedInteger> list = deque.removeLast().getList();
            addList(list);
        }

        return deque.removeLast().getInteger();
    }

    private void addList(List<NestedInteger> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            deque.addLast(list.get(i));
        }
    }

    @Override
    public boolean hasNext() {
        while (!deque.isEmpty() && !deque.peekLast().isInteger()) {
            List<NestedInteger> list = deque.removeLast().getList();
            addList(list);
        }

        return !deque.isEmpty();
    }
}
