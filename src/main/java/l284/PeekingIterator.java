package l284;

import java.util.Iterator;

/**
 * PeekingIterator
 *
 * @author heshan
 * @date 2020/3/24
 */
public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;

    private Integer next;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;

        if (this.iterator.hasNext()) {
            next = this.iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasNext()) {
            return null;
        }

        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }

        Integer res = next;
        if (iterator.hasNext()) {
            next = iterator.next();
        } else {
            next = null;
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
