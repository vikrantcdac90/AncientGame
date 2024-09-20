# Bowling Game

This project implements a bowling game inspired by an ancient game with specific rules. Players throw a piece of wood towards 15 pins over 5 frames, with the aim of knocking down as many pins as possible. 

## Features

- Support for up to 5 frames.
- Handles strikes, spares, and regular throws.
- Calculates the score according to the following rules:
  - A spare counts as 15 plus the pins from the next two deliveries.
  - A strike counts as 15 plus the pins from the next three deliveries.
- Interactive Command Line Interface (CLI) for user input.

## Rules Overview

- Each frame consists of 3 throws.
- The maximum number of pins is 15.
- If all pins are knocked down with the first throw, it is considered a strike.
- If all pins are knocked down after the second or third throw, it is considered a spare.
- The maximum perfect score is 300.

## Getting Started

### Prerequisites

- Java 21 
- An IDE or a text editor for editing the code

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/vikrantcdac90/AncientGame.git
   cd AncientGame
   run the BowlingGameCLI file
  

### Usage
  - Start the application: Run the BowlingGameCLI class.
  - Input pins knocked down: Enter the number of pins knocked down (0-15) for each throw.
  - Finish the game: Type exit to end the game and see the final score.
