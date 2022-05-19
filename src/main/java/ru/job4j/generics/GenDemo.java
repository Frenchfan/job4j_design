package ru.job4j.generics;

public class GenDemo {
    public static void main(String[] args) {
        Gen<Integer> iOb;
        //Обрати внимание на автоупаковку для инкапсуляции значения
        iOb = new Gen<>(88);
        iOb.showType();
        int v = iOb.getOb();
        System.out.println("Значение: " + v);
        System.out.println();
        Gen<String> strOb = new Gen<>("Тест обобщений");
        strOb.showType();
        String str = strOb.getOb();
        System.out.println("Значение: " + str);
    }
}
