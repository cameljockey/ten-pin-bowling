
## Ten Pin Bowling Problem Description

Create a program, which, given a valid sequence of rolls for one line of American Ten-Pin Bowling, produces the total score for the game.

The following video is a good overview if you are not familiar with American Ten-Pin Bowling: https://www.youtube.com/watch?v=E2d8PizMe-8.

Try to complete coding in Timeboxed 4 hours.

Include unit tests for your implementation.

Code should be clean, maintainable, correct, and extensible.

American Ten-Pin Bowling Scoring Rules

```
The game consists of 10 frames.
In each frame the player has two opportunities to knock down 10 pins. The score for the frame is the total 
number of pins knocked down, plus bonuses for strikes and spares.
A spare is when the player knocks down all 10 pins in two tries. The bonus for that frame is the number of pins 
knocked down by the next roll. So in frame 3 above, the score is 10 (the total number knocked down) plus a bonus 
of 5 (the number of pins knocked down on the next roll.)
A strike is when the player knocks down all 10 pins on his first try. The bonus for that frame is the value of 
the next two balls rolled.
In the tenth frame a player who rolls a spare or strike is allowed to roll the extra balls to complete the frame. 
However no more than three balls can be rolled in tenth frame.
```
More info on the rules at: [http://www.topendsports.com/sport/tenpin/scoring.htm](http://www.topendsports.com/sport/tenpin/scoring.htm)

## Out of scope

Here are some things that the program will not do:

```
We will not check for valid rolls
We will not check for correct number of rolls and frames
We will not provide scores for intermediate frames
Due to Timebox nature, have not yet added the logging
Due to timebox nature, have not yet added Exception Handling
```
## Solution Design

```
The Design patterns used in this assignment are Strategy and Mediator
To make the Solution extensible and maintainable SOLID design principle and DRY approach is tried to be followed 
as much as possible.
SOLID - [S=Single Responsibility, O=Open-Closed Principle, L=LisKov Substitution Principle, I=Interface 
Segregation Principle, D=Dependency Injection]
DRY - Do Not Repeat Yourself
Have used interfaces between class interactions, so that we can change implementations (or we can call strategies) 
whenever we want in future. Like suppose if we want to create multiPlayer Game. We can simply create new Class 
MultiPlayerGame implementing Game interface and supply it in BowlingContext Object downstream. Or suppose we want 
to create a funky game with >10 Rounds Or >2 Roll per Round Or some different kind of Roll. We can add it without 
disturbing the application too much.
During coding, first the whole Application Design Skeleton was created and then TDD was followed to create the 
Application by first creating the Unit Tests and then did the coding in the classes. The Unit Tests are
available in src/test folder
To help the User a Swing UI has been provided to recieve input and display output Score and Messages.
```
## Running the Application

```
You can run the Application by creating a runnable jar from project code with command [mvn clean package] and then 
running it with command [java -jar <JarName>].

To save the hassles mentioned above, I have already created the runnable jar and added a batch file to run it
in the run folder. Just simply copy both the ten-pin-bowling-1.0-SNAPSHOT-spring-boot.jar and run.bat file into 
any single folder and double click on run.bat. You will see the Swing UI Pop-up. Just simple input the Roll 
String and then click on Calculate Button to display the output. 
