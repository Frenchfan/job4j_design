package ru.job4j.generics;

public class Gen<T> {
    T ob;

    /**
     * Demosntrating generics
     * @param ob
     */
    public Gen(T ob) {
        this.ob = ob;
    }

    public T getOb() {
        return ob;
    }

    void showType() {
        System.out.println("Типом T является " + ob.getClass().getName());
    }
}
