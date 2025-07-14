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
📁 Project Structure
java-lottery-card-game/
├── Main.java          # Main game logic and user interface
├── Stack.java         # Custom Stack implementation
├── Queue.java         # Custom Queue implementation
└── README.md          # Project documentation
🛠️ Technologies Used

Language: Java
Data Structures: Custom Stack and Queue implementations
I/O: File reading/writing for high score table
Concepts: OOP, Random algorithms, Game logic

🎯 Learning Objectives
This project demonstrates:

Custom data structure implementation
Stack and Queue operations
File I/O operations
Game development logic
Object-oriented programming principles

👨‍💻 Author
İrem TEKİN
Computer Engineering Student - Dokuz Eylül University
📧 [iremtekin1107@gmail.com]
🔗 [https://www.linkedin.com/in/irem-tekin11/]
This project was created for educational purposes as part of CME1212 Algorithms and Programming II course.

⭐ Don't forget to star this repository if you found it helpful!
