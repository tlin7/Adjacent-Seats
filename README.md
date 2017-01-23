# AdjacentSeats

Thomas Lin, Jonathan Quang, Noah Tang.

## Description
This is a two player military sim coded in Java. Players will take turns issuing commands to their infantry or navy represented by ASCII characters to move or attack. The first  player to successfully eliminate the enemy units wins.

## Launch Instructions
This simulation is to be run in Terminal or equivalent. Everything preceded by a $ means it is to be typed into Terminal or equivalent without the $.

Step 1: Open Terminal, Git Bash, etc.

Step 2: $git clone git@github.com:tlin7/AdjacentSeats.git

Step 3: $javac Woo.java

Step 4: $java Woo

Step 5: You should now be in the main menu of the simulation. You can now choose to start playing, open the manual, or exit. You can choose what action to take by typing the corresponding number and pressing enter. 

## Game Manual

This is the instruction manual for our program. If you need to view it at any time during the game, just use the INFO command.
Basics:

This is a historically-themed wargame; If you've ever played Risk, Diplomacy, Advanced Squad Leader, or any of the Avalon Hill boardgames, you already have an idea of how this works.

The game is played on the army-fleet scale; you and your opponent are generals of opposing sides. You must play at the same computer. The objective is to destroy the enemy completely!

Structure:

When you and a friend play, you will take turns sending orders to the battlefield. The orders come in the form of simple commands. Examples are given below:

A7 NORTH

D4 attack D5

Specifics:

How to specify a particular unit: By letter and number. First comes the letter, which specifies ROW. (A-Z). Then comes number, which specifies column (0-80). All numbers are written vertically due to space issues. For example, the number 54 would be written above its respective column like this:

5

4

Infantry units are represented by a z. Navy units are represented by a y. Infantry units can only move on land, represented by a -. Navy units can only move on water, represented by |. Special scenarios have some other units, such as the weaker Navy unit, Sailship(%) and Artillery (#).

Player 1's units are blue. Player 2's are red.

To Attack: Type in <your attacking unit coordinates> ATTACK <unit you want to attack's coordinates>.

Example: A16 ATTACK A17

Infantry units can only attack enemies up to 2 tiles away from them. A navy unitor sailship can attack as far as 4 tiles away. Artillery can attack as far as 6 tiles away.If your attack is out of range it will still count as a turn taken.

Commands:

Direction: NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, NORTHWEST.

Attacking: ATTACK

MISC: SKIP, INFO
