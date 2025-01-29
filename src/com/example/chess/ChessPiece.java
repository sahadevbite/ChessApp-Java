package com.example.chess;

import java.util.List;

/**
 * ChessPiece is a simple interface describing the contract for our pieces.
 */
public interface ChessPiece {
    /**
     * Given a position on the board (e.g. "D5"),
     * returns a list of all possible valid moves for that piece.
     */
    List<String> getPossibleMoves(String currentPosition);
}
