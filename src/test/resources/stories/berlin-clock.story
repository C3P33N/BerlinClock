Story: The Berlin Clock

Meta:
@scope interview

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase the number of ways that I can read the time

Scenario: Current time is 00:00:00
When time is 00:00:00
Then clock should display following
Y
OOOO
OOOO
OOOOOOOOOOO
OOOO
Scenario: Current time is 13:17:01
When time is 13:17:01
Then clock should display following
O
RROO
RRRO
YYROOOOOOOO
YYOO
Scenario: Current time is 23:59:59
When time is 23:59:59
Then clock should display following
O
RRRR
RRRO
YYRYYRYYRYY
YYYY
Scenario: Current time is 24:00:00
When time is 24:00:00
Then clock should display following
Y
RRRR
RRRR
OOOOOOOOOOO
OOOO