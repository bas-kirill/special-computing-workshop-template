package ru.spbu.apcyb.svp.tasks;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.Nullable;

/**
 * Двусвязный линейный список.
 */
public class MyList implements List<Object> {

    private Node head;

    private static class Node {
        Object data;
        Node left;
        Node right;

        Node(Object obj) {
            data = obj;
            left = null;
            right = null;
        }
    }

    public MyList() {
        this.head = null;
    }

    /**
     * Конструктор добавляющий звенья их "с".
     *
     * @param c - коллекция объектов.
     */
    public MyList(Collection<?> c) {
        this.head = null;
        this.addAll(c);
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        } else {
            int count;
            Node current = head;
            for (count = 0; current != null; count++) {
                current = current.right;
            }
            return count;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        Node current = head;
        boolean contain = false;
        while (!contain && current != null) {
            if (current.data.equals(o)) {
                contain = true;
            }
            current = current.right;
        }
        return contain;
    }

    @Override
    public Iterator<Object> iterator() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("iterator() is unsupported operation");
    }

    @Override
    public Object[] toArray() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("toArray() is unsupported operation");
    }

    @Override
    public <T> T[] toArray(@Nullable T[] a) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("toArray() is unsupported operation");
    }

    /**
     * Внутренняя функция для добавления элемента в непустой список по корректному индексу.
     *
     * @param index   - уже проверенный на корректность индекс.
     * @param element - объект для добавления.
     */
    public void addToNotNullList(int index, Object element) {
        Node added = new Node(element);
        Node current = head;
        if (index == size()) {
            for (int i = 0; i < index - 1; i++) {
                current = current.right;
            }
            current.right = added;
            added.left = current;
        } else {
            for (int i = 0; i < index; i++) {
                current = current.right;
            }
            added.left = current.left;
            added.right = current;
            current.left = added;
            if (index != 0) {
                added.left.right = added;
            } else {
                head = added;
            }
        }
    }

    @Override
    public boolean add(Object obj) {
        Node added = new Node(obj);
        if (head != null) {
            Node current = head;
            while (current.right != null) {
                current = current.right;
            }
            current.right = added;
            added.left = current;
        } else {
            head = added;
        }
        return true;
    }

    @Override
    public void add(int index, Object element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        } else {
            Node added = new Node(element);
            if (size() == 0) {
                head = added;
            } else {
                addToNotNullList(index, element);
            }
        }
    }

    @Override
    public Object remove(int index) {
        int i;
        Node current = head;
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            if (index == 0) {
                head = head.right;
                head.left = null;
            } else {
                for (i = 0; i < index; i++) {
                    current = current.right;
                }
                if (index != size() - 1) {
                    current.right.left = current.left;
                }
                current.left.right = current.right;
            }
        }
        return current.data;
    }

    @Override
    public boolean addAll(Collection<?> c) {
        for (Object it : c) {
            this.add(it);
        }
        return true;
    }

    @Override
    public Object get(int index) {
        int i;
        Node current = head;
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            for (i = 0; i < index; i++) {
                current = current.right;
            }
        }
        return current.data;
    }

    @Override
    public boolean remove(Object o) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("remove() is unsupported operation");
    }

    @Override
    public boolean containsAll(@Nullable Collection<?> c) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("containsAll() is unsupported operation");
    }

    @Override
    public boolean addAll(int index, @Nullable Collection<?> c) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("addAll() is unsupported operation");
    }

    @Override
    public boolean removeAll(@Nullable Collection<?> c) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("removeAll() is unsupported operation");
    }

    @Override
    public boolean retainAll(@Nullable Collection<?> c) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("retainAll() is unsupported operation");
    }

    @Override
    public void clear() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("clear() is unsupported operation");
    }

    @Override
    public Object set(int index, Object element) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("set() is unsupported operation");
    }

    @Override
    public int indexOf(Object o) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("indexOf() is unsupported operation");
    }

    @Override
    public int lastIndexOf(Object o) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("lastIndexOf() is unsupported operation");
    }

    @Override
    public ListIterator<Object> listIterator() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("listIterator() is unsupported operation");
    }

    @Override
    public ListIterator<Object> listIterator(int index) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("listIterator() is unsupported operation");
    }

    @Override
    public List<Object> subList(int fromIndex, int toIndex) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("subList() is unsupported operation");
    }
}