package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>();

    /**
     * Adds non-duplicate elements to the set
     * @param value any element to add
     * @return boolean, if the adding is successful
     */
    @Override
    public boolean add(T value) {
        boolean rsl = false;
        if (!this.contains(value)) {
            this.set.add(value);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Checks if the set contains the value to avoid duplicates
     *
     * @param value any value of the same type as the set
     * @return boolean
     */
    @Override
    public boolean contains(T value) {
        boolean rsl = false;
        for (T t : set) {
            rsl = Objects.equals(value, t);
            if (rsl) {
                break;
            }
        }
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return this.set.iterator();
    }
}