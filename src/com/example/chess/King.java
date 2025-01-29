package com.example.chess;

import java.util.ArrayList;
import java.util.List;

/**
 * King - can move one step in any of the 8 directions.
 */
public class King implements ChessPiece {

    private static final int[] ROW_OFFSETS = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] COL_OFFSETS = {-1, 0, 1, -1, 1, -1, 0, 1};

    @Override
    public List<String> getPossibleMoves(String currentPosition) {
        List<String> possibleMoves = new ArrayList<>();
        int[] rowCol = ChessBoard.positionToRowCol(currentPosition);
        if (rowCol == null) {
            return possibleMoves;
        }

        int currentRow = rowCol[0];
        int currentCol = rowCol[1];

        for (int i = 0; i < ROW_OFFSETS.length; i++) {
            int newRow = currentRow + ROW_OFFSETS[i];
            int newCol = currentCol + COL_OFFSETS[i];

            if (ChessBoard.isValidCell(newRow, newCol)) {
                possibleMoves.add(ChessBoard.rowColToPosition(newRow, newCol));
            }
        }

        return possibleMoves;
    }
}
