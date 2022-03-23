package ru.job4j.collection;

import ru.job4j.list.List;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size = 0;

    private int modCount = 0;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        checkSize();
        container[size] = value;
        size++;
        modCount++;
    }

    private void checkSize() {
        if (size == 0) {
            container = (T[]) new Object[1];
        } else if (size == container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size);
        T oldContainer = container[index];
        container[index] = newValue;
        modCount++;
        return oldContainer;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T oldContainer = container[index];
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        container[size - 1] = null;
        modCount++;
        size--;
        return oldContainer;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return position >= 0 && position < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[position++];
            }

        };
    }
}