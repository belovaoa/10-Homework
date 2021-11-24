package com.github.belovaoa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleTest {

    @Test
    void simpleTest() {
        Assertions.assertTrue(2 > 1);
    }

    @Test
    void secondTest() {
        Assertions.assertTrue(false);
    }
}
