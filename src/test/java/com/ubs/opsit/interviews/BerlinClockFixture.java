package com.ubs.opsit.interviews;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;

import static com.ubs.opsit.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Acceptance test class that uses the JBehave (Gerkin) syntax for writing stories.  You need to
 * edit this class to complete the exercise.
 */
public class BerlinClockFixture {

    private String currentTime;
    BerlinClock berlinClock = new BerlinClock();

    @Test
    public void berlinClockAcceptanceTests() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("berlin-clock.story")
                .run();
    }

    @When("time is $time")
    public void setWhenTime(@Named("time") String time){
        currentTime = time;
    }

    @Then("clock should display following $")
    public void clockShouldDisplayThis(String resultTimeString) {
        assertThat(berlinClock.convertTime(currentTime), is(equalTo(resultTimeString)));
    }


}
