package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public boolean revert() {
        if (isEmpty() || head.next == null) {
            return false;
        }
        Node<T> current = head.next;
        head.next = null;
        while (current != null) {
            Node<T> next = current.next;
            current.next = head;
            head = current;
            current = next;
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T node = head.value;
        Node<T> tmp = head.next;
        head.value = null;
        head.next = null;
        head = tmp;
        return node;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(T value) {
        head = new Node<T>(value, head);
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}