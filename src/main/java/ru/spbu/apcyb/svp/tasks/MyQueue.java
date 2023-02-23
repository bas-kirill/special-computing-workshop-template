package ru.spbu.apcyb.svp.tasks;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import javax.annotation.Nullable;

/**
 * Очередь на основе списка.
 */
public class MyQueue implements Queue<Object> {

    private final MyList head;

    public MyQueue() {
        this.head = new MyList();
    }

    @Override
    public boolean add(Object o) {
        this.head.add(o);
        return true;
    }

    @Override
    public Object peek() {
        Object result = null;
        if (!this.isEmpty()) {
            result = this.head.get(0);
        }
        return result;
    }

    @Override
    public int size() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("size() is unsupported operation");
    }

    @Override
    public boolean isEmpty() {
        return this.head.isEmpty();
    }

    @Override
    public boolean contains(Object o) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("contains() is unsupported exception");
    }

    @Override
    public Iterator<Object> iterator() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("iterator() is unsupported exception");
    }

    @Override
    public Object[] toArray() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("toArray() is unsupported exception");
    }

    @Override
    public <T> T[] toArray(@Nullable T[] a) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("toArray() is unsupported exception");
    }

    @Override
    public boolean remove(Object o) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("remove() is unsupported exception");
    }

    @Override
    public Object remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("remove() is unsupported exception");
    }

    @Override
    public boolean containsAll(@Nullable Collection<?> c) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("containsAll() is unsupported exception");
    }

    @Override
    public boolean addAll(@Nullable Collection<?> c) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("addAll() is unsupported exception");
    }

    @Override
    public boolean removeAll(@Nullable Collection<?> c) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("removeAll() is unsupported exception");
    }

    @Override
    public boolean retainAll(@Nullable Collection<?> c) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("retainAll() is unsupported exception");
    }

    @Override
    public void clear() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("clear() is unsupported exception");
    }

    @Override
    public boolean offer(Object o) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("offer() is unsupported exception");
    }

    @Override
    public Object poll() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("poll() is unsupported exception");
    }

    @Override
    public Object element() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("element() is unsupported exception");
    }
}