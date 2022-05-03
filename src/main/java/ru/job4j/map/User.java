package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
    @Override
    public int hashCode() {
        int result;
        result = name.hashCode() * children + birthday.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && name.equals(user.name) && birthday.equals(user.birthday);
    }


    public static void main(String[] args) {
        User test1 = new User("First", 2, new GregorianCalendar(1990, 0, 5));
        User test2 = new User("First", 2, new GregorianCalendar(1990, 0, 5));
        Map<User, Object> myMap = new HashMap<>();
        myMap.put(test1, new Object());
        myMap.put(test2, new Object());
        myMap.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
