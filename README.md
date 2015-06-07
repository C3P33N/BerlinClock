# The Berlin Clock

The Berlin Uhr (Clock) is a rather strange way to show the time. On the top of the clock there is a yellow lamp that
blinks on/off every two seconds. The time is calculated by adding rectangular lamps.
 
The top two rows of lamps are red. These indicate the hours of a day. In the top row there are 4 red lamps. Every lamp
represents 5 hours. In the lower row of red lamps every lamp represents 1 hour. So if two lamps of the first row and
three of the second row are switched on that indicates 5+5+3=13h or 1 pm.
 
The two rows of lamps at the bottom count the minutes. The first of these rows has 11 lamps, the second 4. In the
first row every lamp represents 5 minutes. In this first row the 3rd, 6th and 9th lamp are red and indicate the first
quarter, half and last quarter of an hour. The other lamps are yellow. In the last row with 4 lamps every lamp
represents 1 minute.

One can be seen [here](http://uniqueclocks.co.uk/media/berlin~clock.jpg~1.gif)

## Examples

At 00:00:00 clock should look like
Y
OOOO
OOOO
OOOOOOOOOOO
OOOO

At 13:17:01 clock should look like
O
RROO
RRRO
YYROOOOOOOO
YYOO

At 23:59:59 clock should look like
O
RRRR
RRRO
YYRYYRYYRYY
YYYY

At 24:00:00 clock should look like
Y
RRRR
RRRR
OOOOOOOOOOO
OOOO

## Your Task

For each example implement one scenario in JBehave. These will be your acceptance tests.
Then your task is to proceed with implementation in TDD style - providing unit tests and production code.

Additionally, please make sure your solution is accompanied by comments in any form that describe a step-by-step refactorings, so we can understand the way you were thinking.

## Some hints
If you are new to Gradle, it may be worth spending 10 minutes reading a high level summary.  We are using the Gradle
Wrapper so `gradlew` from the command line should download everything you need.  Most modern IDEs support Gradle projects.

Please ensure that you are familiar with our values in the instructions project.  They are important to us.