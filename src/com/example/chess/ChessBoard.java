package com.example.chess;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard {

    /**
     * Converts a position string like "A1", "H8", "D5" into an integer array {row, col}.
     * - Row: 1..8
     * - Col: 1..8
     *
     * Returns null if the position string is invalid.
     */
    public static int[] positionToRowCol(String position) {
        if (position == null || position.length() < 2 || position.length() > 3) {
            return null;
        }

        char fileChar = position.toUpperCase().charAt(0); // e.g., 'A'..'H'
        String rankStr = position.substring(1);           // e.g., '1'..'8'

        // Convert 'A'..'H' to 1..8
        int col = fileChar - 'A' + 1;
        if (col < 1 || col > 8) {
            return null;
        }

        int row;
        try {
            row = Integer.parseInt(rankStr);
        } catch (NumberFormatException e) {
            return null;
        }
        if (row < 1 || row > 8) {
            return null;
        }

        return new int[]{row, col};
    }

    /**
     * Converts 1-based row/col to a standard chess notation string: e.g. (1,1) -> "A1".
     */
    public static String rowColToPosition(int row, int col) {
        char fileChar = (char) ('A' + (col - 1));
        return String.valueOf(fileChar) + row;
    }

    /**
     * Returns true if the given (row, col) is within the 8x8 chessboard.
     */
    public static boolean isValidCell(int row, int col) {
        return (row >= 1 && row <= 8 && col >= 1 && col <= 8);
    }

    /**
     * Given a starting position (row, col) and increments (dRow, dCol),
     * it collects all cells along that direction until hitting board edge.
     * This is primarily used by the Queen (or Rook/Bishop in a full solution).
     */
    public static List<String> collectMovesInDirection(int startRow, int startCol, int dRow, int dCol) {
        List<String> moves = new ArrayList<>();
        int currentRow = startRow + dRow;
        int currentCol = startCol + dCol;

        while (isValidCell(currentRow, currentCol)) {
            moves.add(rowColToPosition(currentRow, currentCol));
            currentRow += dRow;
            currentCol += dCol;
        }

        return moves;
    }
}
