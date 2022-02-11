package ru.job4j.generics;

import java.util.*;

public class GenericUsage {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        for (int i = 0; i < list.size(); i++) {
            String s = (String) list.get(i);
            System.out.println("Текущий элемент: " + s);
        }
        List<Integer> l = List.of(1, 2, 3, 4, 5);
        new GenericUsage().printRsl(l);

        List<Person> per = List.of(new Person("name", 21, new Date(913716000000L)));
        new GenericUsage().printInfo(per);

        List<Programmer> pro = List.of(new Programmer("name123", 23, new Date(913716000000L)));
        new GenericUsage().printInfo(pro);

        List<?super Integer> list2 = new ArrayList<>();
        new GenericUsage().addAll(list2);
    }

    /**
     * demonstration of the wild card approach - <?> corresponds to any type
     * @param col any collection
     */
    public void printRsl(Collection<?> col) {
        for (Iterator<?> it = col.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент: " + next);
        }
    }
    /**
     * Bounded Wildcard, <? extends Person> means that can be used any type, which extends Person
     * Также называется ограничением типа сверху
     * @param col collection of Person or any type that extends it
     */
    public void printInfo(Collection<? extends Person> col) {
        for (Iterator<? extends Person> it = col.iterator(); it.hasNext();) {
            Person next = it.next();
            System.out.println(next);
        }
    }

    /**
     * Lower bounded wildcard - limits the use of the wildcard (<?>) by using the super word and the low type
     * @param list collection of Person or any type that extends it
     */
    public void addAll(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        for (Object o : list) {
            System.out.println("Текущий элемент: " + o);
        }
    }
}