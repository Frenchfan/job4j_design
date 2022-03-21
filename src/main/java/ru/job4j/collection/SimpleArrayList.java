package ru.job4j.collection;

import ru.job4j.list.List;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int modCount = 0;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (modCount == container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
        container[modCount] = value;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, modCount);
        T oldContainer = container[index];
        container[index] = newValue;
        return oldContainer;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, modCount);
        T oldContainer = container[index];
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        container[modCount - 1] = null;
        modCount--;
        return oldContainer;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, modCount);
        return container[index];
    }

    @Override
    public int size() {
        return modCount;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private  int position = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return position >= 0 && position < modCount;
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