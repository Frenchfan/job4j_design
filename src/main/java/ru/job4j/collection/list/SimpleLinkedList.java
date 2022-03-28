package ru.job4j.collection.list;

import java.util.*;

public class SimpleLinkedList<E> implements List<E> {

    private int size;

    private int modCount;

    private Node<E> first;

    private Node<E> last;


    public SimpleLinkedList() {
        size = 0;
        modCount = 0;
        first = null;
        last = null;
    }

    @Override
    public void add(E value) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null) {
            first = last;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        int currentIndex = 0;
        Node<E> rsl = first;
        while (currentIndex != index) {
            rsl = rsl.next;
            currentIndex++;
        }

        return rsl.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private final int expectedModCount = modCount;
            Node<E> value = first;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return value != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E rsl = value.item;
                value = value.next;
                return rsl;
            }
        };
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.item = element;
            this.next = next;
        }
    }
}