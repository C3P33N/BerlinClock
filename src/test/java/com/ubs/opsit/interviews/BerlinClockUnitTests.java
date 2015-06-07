package com.ubs.opsit.interviews;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


/**
 * Created by krzysztofduda on 05.06.15.
 * Test Cases correspond in this particular case to acceptance tests done in jBehave.
 */
public class BerlinClockUnitTests {
//    private BerlinClock clock;
    BerlinClock clock = new BerlinClock();
    @Test
    public void test_00_00_00() {
        assertEquals("Y\n" +
                "OOOO\n" +
                "OOOO\n" +
                "OOOOOOOOOOO\n" +
                "OOOO", clock.convertTime("00:00:00"));
    }

    @Test
    public void test_13_17_01() {
        assertEquals("O\n" +
                "RROO\n" +
                "RRRO\n" +
                "YYROOOOOOOO\n" +
                "YYOO", clock.convertTime("13:17:01"));
    }

    @Test
    public void test_23_59_59() {
        assertEquals("O\n" +
                "RRRR\n" +
                "RRRO\n" +
                "YYRYYRYYRYY\n" +
                "YYYY", clock.convertTime("23:59:59"));
    }

    @Test
    public void test_24_00_00() {
        assertEquals("Y\n" +
                "RRRR\n" +
                "RRRR\n" +
                "OOOOOOOOOOO\n" +
                "OOOO", clock.convertTime("24:00:00"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_wrong_input_string(){
        clock.convertTime("hh:mm:ss");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_wrong_input_string_without_colon(){
        clock.convertTime("wrongStringFormatWasProvided");
    }
}



