# Java Lottery Card Game 🎲

A console-based two-player lottery card game implemented in Java using custom Stack and Queue data structures.

## 📋 Project Overview

This project simulates a lottery card game where two players compete by matching randomly selected values with cards from a deck. The game implements custom Stack and Queue classes and demonstrates fundamental data structure concepts.

## ✨ Features

- 🎯 Two-player tournament system
- 🃏 Random card distribution (7-10 cards per player)
- 📊 Real-time scoring system
- 🏆 High score table with file persistence
- 🔄 Play again functionality
- 🎲 Random lottery ball selection

## 🎮 How to Play

1. Enter number of cards (7-10)
2. Cards are randomly distributed to both players
3. Lottery balls are drawn randomly from bag1 to bag2
4. Players score points for matching cards:
   - **+10 points** for matching a card
   - **-5 points** for missing a card
   - **+30 points** for completing first tournament (4 cards removed)
   - **+50 points** for emptying all cards

## 🚀 How to Run

```bash
# Compile all Java files
javac *.java

# Run the game
java Main
