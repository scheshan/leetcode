package leetcode.p284;

import java.util.Iterator;

/**
 * PeekingIterator
 *
 * @author heshan
 * @date 2024/1/24
 */
public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;

    private Integer n;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (n == null && iterator.hasNext()) {
            n = iterator.next();
        }
        return n;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res = null;
        if (n != null) {
            res = n;
            n = null;
        } else if (iterator.hasNext()) {
            res = iterator.next();
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        return n != null || iterator.hasNext();
    }
}
