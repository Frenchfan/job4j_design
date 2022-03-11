package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    @Test
    public void whenAddAndFindThenRolenameIsAlex() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        Role result = store.findById("1");
        assertThat(result.getRolename(), is("Alex"));
    }

    @Test
    public void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        Role result = store.findById("5");
        assertNull(result);
    }

    @Test
    public void whenAddDuplicateAndFindRolenameIsAlex() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        store.add(new Role("1", "Andrew"));
        Role result = store.findById("1");
        assertThat(result.getRolename(), is("Alex"));
    }

    @Test
    public void whenReplaceThenRolenameIsAndrew() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        store.replace("1", new Role("1", "Andrew"));
        Role result = store.findById("1");
        assertThat(result.getRolename(), is("Andrew"));
    }

    @Test
    public void whenNoReplaceRoleThenNoChangeRolename() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        store.replace("10", new Role("10", "Andrew"));
        Role result = store.findById("1");
        assertThat(result.getRolename(), is("Alex"));
    }

    @Test
    public void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        store.delete("1");
        Role result = store.findById("1");
        assertNull(result);
    }

    @Test
    public void whenNoDeleteRoleThenRolenameIsAlex() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRolename(), is("Alex"));
    }
}