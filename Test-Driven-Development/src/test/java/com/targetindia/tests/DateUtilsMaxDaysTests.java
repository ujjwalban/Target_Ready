package com.targetindia.tests;

import com.targetindia.utils.DateUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DateUtilsMaxDaysTests {
    @Test
    @DisplayName("Maximum Days for leap year february")
    public void testMaxDaysForLeapYearFebruary() throws Exception {
        DateUtils dateUtils = new DateUtils();
        Integer expected = 29;
        Integer year = 2000;
        Integer actual = dateUtils.maxDays(2,year);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Maximum Days for Non-leap year february")
    public void testMaxDaysForNonLeapYearFebruary() throws Exception {
        DateUtils dateUtils = new DateUtils();
        Integer expected = 28;
        Integer year = 2100;
        Integer actual = dateUtils.maxDays(2,year);
        Assertions.assertEquals(expected,actual);
    }
}
