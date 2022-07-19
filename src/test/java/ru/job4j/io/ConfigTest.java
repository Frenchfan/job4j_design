package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr Arsentev"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithCommentEmptyLine() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Andey = Alexeev"));
        assertThat(config.value("born"), is("01.12.1984"));
        assertThat(config.value("surname"), is("Fedorov"));
        assertThat(config.value("find"), is("true"));
        assertThat(config.value("#place"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithCommentAndBrokenPattern() {
        String path = "./data/pair_with_comment_broken_pattern.properties";
        Config config = new Config(path);
        boolean thrown = false;
        try {
            config.load();
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
}
