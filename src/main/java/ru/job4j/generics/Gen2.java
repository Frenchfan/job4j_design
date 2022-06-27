package ru.job4j.generics;

public class Gen2<T> extends Gen<T> {
    Gen2(T o) {
        super(o);
    }
}
class HierDemo3 {

    public static void main(String[] args) {
        Gen<Integer> iOb = new Gen<>(88);
        Gen2<Integer> iOb2 = new Gen2<>(99);
        Gen2<String> strOb2 = new Gen2<>("Testing generics");
        if (iOb2 instanceof Gen2<?>) {
            System.out.println("The object iOb2 belongs to the class Gen2");
        }
        if (iOb2 instanceof Gen<?>) {
            System.out.println("The object iOb2 belongs to the class Gen");
        }
        System.out.println();
        if (strOb2 instanceof Gen2<?>) {
            System.out.println("The object strOb2 belongs to the class Gen2");
        }
        if (strOb2 instanceof Gen<?>) {
            System.out.println("The object strOb2 belongs to the class Gen");
        }
        System.out.println();
        if (iOb instanceof Gen2<?>) {
            System.out.println("The object iOb belongs to the class Gen2");
        }
        if (iOb instanceof Gen<?>) {
            System.out.println("The object iOb belongs to the class Gen");
        }

    }
}
