package ru.job4j.map;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenPut1Person() {
        SimpleMap<Integer, String> users = new SimpleMap<>();
        boolean rsl = users.put(1702453448, "Сергеева");
        int a = 384;
        byte b = (byte) a;
        System.out.println(b);
        assertTrue(rsl);
    }

    @Test
    public void whenPut2Persons() {
        SimpleMap<Integer, String> users = new SimpleMap<>();
        boolean rsl = users.put(1702453448, "Сергеева");
        boolean rsl2 = users.put(1803456729, "Максимов");
        assertTrue(rsl && rsl2);
    }

    @Test
    public void whenGet1Person() {
        SimpleMap<Integer, String> users = new SimpleMap<>();
        users.put(1702453448, "Сергеева");
        assertEquals("Сергеева", users.get(1702453448));
    }

    @Test
    public void whenGet2Persons() {
        SimpleMap<Integer, String> users = new SimpleMap<>();
        users.put(1702453448, "Сергеева");
        users.put(1803456729, "Максимов");
        assertEquals("Сергеева", users.get(1702453448));
        assertEquals("Максимов", users.get(1803456729));
    }

    @Test
    public void whenRemove1Person() {
        SimpleMap<Integer, String> users = new SimpleMap<>();
        users.put(1702453448, "Сергеева");
        assertTrue(users.remove(1702453448)
                && (users.get(1702453448) == null));
    }

    @Test
    public void whenRemovefromEmptyMap() {
        SimpleMap<Integer, String> users = new SimpleMap<>();
        assertFalse(users.remove(1803456729));
    }
}