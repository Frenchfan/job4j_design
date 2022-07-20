package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            String fileLine;
            while ((fileLine = read.readLine()) != null) {
                if (!fileLine.startsWith("#") && fileLine.length() > 1) {
                    String[] keyValue = fileLine.split("=", 2);
                    if (keyValue.length == 1 || keyValue[0].isBlank() || keyValue[0].isEmpty()
                            || keyValue[1].isBlank() || keyValue[1].isEmpty()) {
                        throw new IllegalArgumentException("The file is incorrect");
                    } else {
                        values.put(keyValue[0], keyValue[1]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }

}