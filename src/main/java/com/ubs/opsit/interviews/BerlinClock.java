package com.ubs.opsit.interviews;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * BerlinClock class is implementation of contextual clock display. It uses TimeConverter interface, provided by client.
 * @author Krzysztof Duda
 */
public class BerlinClock implements TimeConverter {
    private static final String FOUR_OFF = "OOOO";
    private static final String ELEVEN_OFF = "OOOOOOOOOOO";
    private static final String RED_SQUARE = "R";
    private static final String YELLOW_SQUARE = "Y";
    private static final String YELLOW_CIRCLE = "Y";
    private static final String EMPTY_CIRCLE = "O";

    /**
     * convertTime is a public method which converts time from sting representation to Berlin Clock representation.
     * @param aTime string which contains time in following format HH:MM:SS,
     * @return String containing converted time with newline characters,
     */
    @Override
    public String convertTime(String aTime) {
        //First we need to check if given time was in correct format
        Pattern timeFormat = Pattern.compile("([01]{1}[0-9]|2[0-4]):[0-5]\\d:[0-5]\\d");
        Matcher providedTime = timeFormat.matcher(aTime);

        if (!providedTime.matches()){
            throw new IllegalArgumentException("Time was provided in wrong format.");
        }

        StringBuilder resultTime = new StringBuilder();
        // prepare each of time elements
        String[] timeParts = aTime.split(":");
        // conversion to int will help manipulating time
        int hour = Integer.parseInt(timeParts[0]);
        int minute = Integer.parseInt(timeParts[1]);
        int second = Integer.parseInt(timeParts[2]);

        return resultTime.append(getSecondsLights(second)).append(getHourLights(hour)).append(getMinuteLights(minute)).toString();
    }

    private String getSecondsLights(int second) {
        if (second % 2 == 0) {
            return YELLOW_CIRCLE.concat("\n");
        } else {
            return EMPTY_CIRCLE.concat("\n");
        }

    }

    private String getHourLights(int hour) {
        StringBuilder firstHourRow = new StringBuilder(FOUR_OFF);
        StringBuilder secondHourRow = new StringBuilder(FOUR_OFF);

        int numberOfHoursBy5 = hour / 5;
        int numberOfReimaningHours = hour % 5;

        for (int i = 0; i < numberOfHoursBy5; i++) {
            firstHourRow.replace(i, i + 1, RED_SQUARE);
        }
        for (int i = 0; i < numberOfReimaningHours; i++) {
            secondHourRow.replace(i, i + 1, RED_SQUARE);
        }
        return firstHourRow.append("\n").append(secondHourRow).append("\n").toString();
    }

    private String getMinuteLights(int minute) {
        StringBuilder firstMinuteRow = new StringBuilder(ELEVEN_OFF);
        StringBuilder secondMinuteRow = new StringBuilder(FOUR_OFF);

        int numberOfMinutesBy5 = minute / 5;
        int numberOfRemainingMinutes = minute % 5;

        for (int m = 0; m < numberOfMinutesBy5; m++) {
            if ((m + 1) % 3 == 0) {
                firstMinuteRow.replace(m, m + 1, RED_SQUARE);
            } else {
                firstMinuteRow.replace(m, m + 1, YELLOW_SQUARE);
            }

        }

        for (int m = 0; m < numberOfRemainingMinutes; m++) {
            secondMinuteRow.replace(m, m + 1, YELLOW_SQUARE);
        }
        return firstMinuteRow.append("\n").append(secondMinuteRow).toString();
    }

}
