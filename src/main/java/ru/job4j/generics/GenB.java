package ru.job4j.generics;

public class GenB<T> {
    T ob;

    GenB(T o) {
        ob = o;
    }

    T getOb() {
        System.out.println("Method getOb() from the class GenB: ");
        return ob;
    }
}
class GenB2<T> extends GenB<T> {

    GenB2(T o) {
        super(o);
    }

    @Override
    T getOb() {
        System.out.println("Method getOb() from the class GenB2: ");
        return ob;
        //test
    }
}
class OverrideDemo {
    public static void main(String[] args) {
        GenB<Integer> iOb = new GenB<>(88);
        GenB2<Integer> iOb2 = new GenB2<>(99);
        GenB2<String> strOb2 = new GenB2<>("Testing generics");
        System.out.println(iOb.getOb());
        System.out.println(iOb2.getOb());
        System.out.println(strOb2.getOb());
        GenB<?>[] gens = new GenB<?>[10];
    }
}
