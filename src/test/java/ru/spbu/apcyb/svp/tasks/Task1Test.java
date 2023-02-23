package ru.spbu.apcyb.svp.tasks;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Тесты для задания 1.
 */
class Task1Test {

    @Test
    void strToLongArray_ints() {
        Long[] exp = new Long[] {34L, 2L, 1L};
        assertEquals(Arrays.asList(exp), Arrays.asList(Task1Util.strToLongArray("1 34 2")));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 34 -2", "2 a 3", "", "1 34,1 2"})
    void strToLongArray_error(String str) {
        assertThrows(
                Exception.class,
                () -> Task1Util.strToLongArray(str)
        );
    }

    @Test
    void variants_right() {
        Long[] notes = new Long[] {100L, 50L, 20L};
        assertEquals(6, Task1.combinations(notes, 200, notes[0], ""));
    }

    @Test
    void variants_noChange() {
        Long[] notes = new Long[] {100L};
        assertEquals(0, Task1.combinations(notes, 110, notes[0], ""));
    }

    @Test
    void variants_test1() {
        Long[] notes = new Long[] {3L, 2L};
        assertEquals(1, Task1.combinations(notes, 5, notes[0], ""));
    }

    @Test
    void variants_test2() {
        Long[] notes = new Long[] {2L, 1L};
        assertEquals(3, Task1.combinations(notes, 4, notes[0], ""));
    }

    @Test
    void strToLong_int() {
        assertEquals(15, Task1Util.strToSum("15"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "some txt", "1,5"})
    void strToSum_illegal_argument(String str) {
        assertThrows(
                IllegalArgumentException.class,
                () -> Task1Util.strToSum(str)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"-300"})
    void strToSum_incorrect_value(String str) {
        assertThrows(
                ArithmeticException.class,
                () -> Task1Util.strToSum(str)
        );
    }
}