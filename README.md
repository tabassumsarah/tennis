# Tennis Match Scoring System
This project uses Java8 which is developed to build a minimalistic tennis scoring system.
More information on tennis scoring can be found here https://en.wikipedia.org/wiki/Tennis_scoring_system

# Requitement Analysis

- Match:
  - A match has one set

- Game:

  - Winning: 
      - Player1 - points 4
      - Difference between player1 and player2 = > 2
    
  - Deuce
    -	At least 3 points by both players 
    - Scores should be equal
  
  -	Advantage
    - At least 3 points won by both player.
    - One player has one point more than other

  - Set
    - Can have many games
   
     - Winning a set:
      - Wins ATLEAST 6 games
      - Difference between player1 and player2 games is >=2

- Tie Break:
  - Condition:
    -	Player1= 6 games
    -	Player2= 5 games

  - Plays another game :
      -	If player1 wins: Match is won by 7-5
      -	If player2 wins:  Tie break is played
    - Both player continues until one of the player scored 7 points by margin of 2 or more points


# Project:
1. Java 8
2. Need to have jdk 8 installed and java set in your class path to use following commands.
3. Need to have Gradle installed to build the project and to run tests.

# Overview
1. I have used Enum to consolidated all the logic of getting next score
2. Code Implementation can be found under *src\main\java*
3. Unit tests are located in *\src\main\test*

# API Reference
- pointWonBy(Player): will calculate points of the respective player
- score(): Will return current state of the score.

# Design Choice and Code Implementation
- I have tried to seperate out gaming point logic to java enum class following a strategy design pattern. The concrete implementation of the strategy(point calculation) is done in the definition of each enum constant. 

```
    Zero("0") {},
    Fifteen("15") {},
    Thirty("30") {...},
    Advantage("advantage") {...},
    Down("down") {},
    Deuce("deuce") {...} ,
    Forty("40") {..},
    Winner("Winner") {...},
    Loser("Looser") {...};
  abstract List<Score> getNextPoint(Score other);

```
# Limitation or Could have done better
- Tie break logic could have been simplified. Could not follow proper TDD when implementing tie break
- Tie break logic is not tested properly (Only one test)
- Scoring translation could be of a seperate service.
- Winning TIE break is not implemented properly.


