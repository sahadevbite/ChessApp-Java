package com.example.chess;

import java.util.List;

public class ChessApp {

    /**
     * Main method.
     * Expects two arguments:
     *   1) Piece type (Pawn, King, Queen)
     *   2) Position on the board (e.g., G1, D5, E4, etc.)
     *
     * Example usage:
     *   java com.example.chess.ChessApp Pawn G1
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Error: Please provide PieceType and Position. Example: Pawn G1");
            return;
        }

        String pieceInput = args[0].trim();
        String positionInput = args[1].trim();

        // Validate piece type
        ChessPieceType pieceType;
        try {
            pieceType = ChessPieceType.valueOf(pieceInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: Invalid piece type. Allowed values: Pawn, King, Queen");
            return;
        }

        // Validate and parse position
        int[] rowCol = ChessBoard.positionToRowCol(positionInput);
        if (rowCol == null) {
            System.err.println("Error: Invalid position format. Must be like A1, H8, D5, etc.");
            return;
        }

        // Create the piece
        ChessPiece piece = createPiece(pieceType);

        // Compute all possible moves
        List<String> possibleMoves = piece.getPossibleMoves(positionInput);

        // Print out results
        if (possibleMoves.isEmpty()) {
            System.out.println("No valid moves available.");
        } else {
            // Join all cells into comma-separated string
            String result = String.join(", ", possibleMoves);
            System.out.println(result);
        }
    }

    /**
     * Factory method to create specific piece implementations.
     */
    private static ChessPiece createPiece(ChessPieceType type) {
        switch (type) {
            case PAWN:
                return new Pawn();
            case KING:
                return new King();
            case QUEEN:
                return new Queen();
            default:
                throw new IllegalStateException("Unexpected piece type");
        }
    }
}
