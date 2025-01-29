package com.example.chess;

import java.util.ArrayList;
import java.util.List;

/**
 * Pawn - moves 1 step vertically "forward".
 * We will assume 'forward' means increasing row number (row -> row+1).
 * For example:
 *   "Pawn, G1" -> "G2"
 * If the pawn is on the 8th rank, it has no forward moves.
 */
public class Pawn implements ChessPiece {

    @Override
    public List<String> getPossibleMoves(String currentPosition) {
        List<String> possibleMoves = new ArrayList<>();
        int[] rowCol = ChessBoard.positionToRowCol(currentPosition);
        if (rowCol == null) {
            return possibleMoves;
        }

        int currentRow = rowCol[0];
        int currentCol = rowCol[1];

        // A white pawn moves from row -> row + 1
        int forwardRow = currentRow + 1;
        if (ChessBoard.isValidCell(forwardRow, currentCol)) {
            possibleMoves.add(ChessBoard.rowColToPosition(forwardRow, currentCol));
        }

        return possibleMoves;
    }
}
