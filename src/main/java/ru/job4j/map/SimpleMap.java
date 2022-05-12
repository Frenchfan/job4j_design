package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;
    private int capacity;
    private int count;
    private int modCount;
    private MapEntry<K, V>[] table;

    public SimpleMap() {
        this.capacity = 8;
        this.count = 0;
        this.modCount = 0;
        this.table = new MapEntry[capacity];
    }

    @Override
    public boolean put(K key, V value) {
        if (get(key) != null) {
            return false;
        }
        int i = indexOf(key);
        table[i] = new MapEntry<>(key, value);
        float load = (float) count / capacity;
        if (Float.compare(load, LOAD_FACTOR) >= 0) {
            expand();
        }
        modCount++;
        count++;
        return true;
    }

    private int hash(int hashCode) {
        return Math.abs(hashCode ^ (hashCode >>> 16));
    }

    private int indexFor(int hash) {
        return hash % capacity;
    }

    private int indexOf(K key) {
        int h = key == null ? 0 : hash(key.hashCode());
        return indexFor(h);
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                int newIndex = indexOf(table[i].key);
                newTable[newIndex] = table[i];
            }
        }
        table = newTable;
    }

    @Override
    public V get(K key) {
        int i = indexOf(key);
        return table[i] == null
                || !key.equals(table[i].key)
                ? null : table[i].value;
    }

    @Override
    public boolean remove(K key) {
        int i = indexOf(key);
        boolean rsl = table[i] != null && key.equals(table[i].key);
        if (rsl) {
            table[i] = null;
            modCount++;
            count--;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new ElIterator();
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    class ElIterator implements Iterator<K> {

        private int position;
        private int expectedModCount;

        public ElIterator() {
            position = 0;
            expectedModCount = modCount;
        }

        @Override
        public boolean hasNext() {
            while (position < capacity && table[position] == null) {
                position++;
            }
            return position < capacity && table[position] != null;
        }

        @Override
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return table[position++].key;
        }
    }

}