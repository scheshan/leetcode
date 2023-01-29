package leetcode.p284;

import java.util.Iterator;

/**
 * PeekingIterator
 *
 * @author heshan
 * @date 2023/1/29
 */
public class PeekingIterator implements Iterator<Integer> {

    private Integer peek;

    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peek != null) {
            return peek;
        }
        peek = iterator.next();
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res = null;
        if (peek != null) {
            res = peek;
            peek = null;
        } else {
            res = iterator.next();
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        return peek != null || iterator.hasNext();
    }
}
