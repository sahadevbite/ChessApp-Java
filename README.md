# Chess Moves Simulation - README

## Overview

This is a simple Java console application that:

- Accepts two arguments from the command line:
  1. The chess piece type (`Pawn`, `King`, or `Queen`).
  2. The current position of that piece on an 8×8 chessboard (e.g., `G1`, `D5`, etc.).
- Prints out all the valid moves that piece can make from the specified position.
- The application assumes an **empty chessboard**.

---

## Chess Pieces Implemented

- **Pawn** → Moves **1 step forward** along the board (i.e., row + 1).
- **King** → Moves **1 step** in any of the **8 directions**.
- **Queen** → Moves **in any of the 8 directions** across the board until the edge.

---

### Examples

1. **King, D5**  
- **Input**: `King, D5`  
- **Output**:  
  ```
  C4, C5, C6, D4, D6, E4, E5, E6
  ```
- **Explanation**: The King can move one step in any direction from D5.

2. **Queen, E4**  
- **Input**: `Queen, E4`  
- **Output**:  
  ```
  A4, B4, C4, D4, F4, G4, H4, E1, E2, E3, E5, E6, E7, E8, A8, B7, C6, D5, F3, G2, H1, B1, C2, D3, F5, G6, H7
  ```
- **Explanation**: The Queen can move in any direction (vertical, horizontal, diagonal), any number of steps until the edge of the board.

3. **Pawn, G1**  
- **Input**: `Pawn, G1`  
- **Output**:  
  ```
  G2
  ```
- **Explanation**: The Pawn can only move one step forward from G1 (which is G2).

---

## Implementation (Java)

This project is a simple **Java console application** that demonstrates how to compute the possible moves for **Pawn**, **King**, and **Queen** on an 8×8 empty chessboard. 

### Requirements

- **Java 8** (or higher)
- **JUnit 4**

- ### Build & Run Instructions

1. **Clone or download** this repository.

2. **Compile** the Java files (example using the `javac` compiler):
   ```bash
   cd path/to/src
   javac com/example/chess/*.java
   java com.example.chess.ChessApp Pawn G1
   java com.example.chess.ChessApp King D5
   java com.example.chess.ChessApp Queen E4


## Notes and Assumptions
 ### Pawn Movement:

 #### Assumes a single-step move forward (from row n to n+1).
 No double moves, no captures (diagonal) are considered in this simplified scenario.
 “Forward” is always increasing row numbers.
 ### Empty Board:

No blocking pieces, so the Queen can move until it hits the boundary of the board.
Invalid Inputs:

If the piece type is unknown or the position is out of range, the application will print an error message or return an empty list of moves.
Output Format:

The positions are returned as a comma-separated list (with a space after the comma).



