package com.targetindia.tests;

import com.targetindia.utils.DateUtils;
import com.targetindia.utils.exceptions.InvalidMonthException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class DateUtilsMaxDaysTests {

    DateUtils dateUtils = new DateUtils();

    public static Stream<Arguments> invalidMonthInputs() {
        return Stream.of(
                Arguments.of(13),
                Arguments.of(-5),
                Arguments.of(17),
                Arguments.of(-200),
                Arguments.of(0)
                );
    }

    @ParameterizedTest
    @ValueSource(ints = {1992,1996,2000,2004,2020,2024})
    @DisplayName("Maximum Days for leap year february")
    public void testMaxDaysForLeapYearFebruary(Integer year) throws Exception {
        Integer actual = dateUtils.maxDays(2,year);
        Assertions.assertEquals(29,actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {2021, 2022, 2023, 2025, 2026, 2027})
    @DisplayName("Maximum Days for Non-leap year february")
    public void testMaxDaysForNonLeapYearFebruary(Integer year) throws Exception {
        Integer actual = dateUtils.maxDays(2,year);
        Assertions.assertEquals(28,actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"test-inputs.csv"})
    @DisplayName("Maximum days for shorter months")
    public void testMaxDaysForShorterMonths(Integer month, Integer year) throws Exception {
        Integer expected = 30;
        Integer actual = dateUtils.maxDays(month, year);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2023", "1, 2024", "3, 2000", "5, 1999", "8, 1990"})
    @DisplayName("Maximum days for longer months")
    public void testMaxDaysForLongerMonths(Integer month, Integer year) throws Exception {
        Integer expected = 31;
        Integer actual = dateUtils.maxDays(month, year);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource(value = {"invalidMonthInputs"})
    @DisplayName("Invalid month supplied")
    public void testInvalidMonth(Integer month) throws Exception {
        try {
            dateUtils.maxDays(month, 2024);
            Assertions.fail("expected InvalidMonthException, but didn't get one");
        } catch (InvalidMonthException e) {
            throw new InvalidMonthException("Invalid");
        }
    }
}
