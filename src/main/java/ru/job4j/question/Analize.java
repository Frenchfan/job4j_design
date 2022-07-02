package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0, changed = 0, deleted = 0;

        Map<Integer, String> testMap = previous.stream()
                .collect(Collectors.toMap(User::getId, User::getName));

        for (User user: current) {
            String value;
            value = testMap.putIfAbsent(user.getId(), user.getName());
            if (value == null) {
                added++;
            } else if (!value.equals(user.getName())) {
                changed++;
            }
            testMap.remove(user.getId());
        }
        deleted = testMap.size();
       return new Info(added, changed, deleted);
    }
}