package com.example.chess;

import java.util.ArrayList;
import java.util.List;

/**
 * Queen - can move in any of the 8 directions, any number of cells.
 * (Stops at board boundaries since it's an empty board scenario.)
 */
public class Queen implements ChessPiece {

    // The 8 directions for queen (row increment, col increment)
    private static final int[][] DIRECTIONS = {
        {-1, 0},  // up
        {1, 0},   // down
        {0, -1},  // left
        {0, 1},   // right
        {-1, -1}, // diagonal up-left
        {-1, 1},  // diagonal up-right
        {1, -1},  // diagonal down-left
        {1, 1}    // diagonal down-right
    };

    @Override
    public List<String> getPossibleMoves(String currentPosition) {
        List<String> possibleMoves = new ArrayList<>();
        int[] rowCol = ChessBoard.positionToRowCol(currentPosition);
        if (rowCol == null) {
            return possibleMoves;
        }

        int currentRow = rowCol[0];
        int currentCol = rowCol[1];

        // Collect moves in each direction until board boundary
        for (int[] dir : DIRECTIONS) {
            int dRow = dir[0];
            int dCol = dir[1];

            List<String> directionMoves = ChessBoard.collectMovesInDirection(currentRow, currentCol, dRow, dCol);
            possibleMoves.addAll(directionMoves);
        }

        return possibleMoves;
    }
}
