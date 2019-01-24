# Tennis Match Scoring System
This project uses Java8 which is developed to build a minimalistic tennis scoring system.

# Requirements:
1. Java 8
2. Need to have jdk 8 installed and java set in your class path to use following commands.
3. Need to have Gradle installed to build the project and to run tests.

# TEST
gradle test

# Overview
1. I have used Enum to consolidated all the logic of getting next score
2. Code Implementation can be found under src\main\java
3. Unit tests are located in \src\main\test

# API Reference
pointWonBy(Player): will calculate points of the respective player
score(): Will return current state of the score.
