package com.example.chess;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ChessAppTest {

    @Test
    public void testPawnAtG1() {
        ChessPiece pawn = new Pawn();
        List<String> moves = pawn.getPossibleMoves("G1");
        // Pawn at G1 -> G2
        assertEquals(1, moves.size());
        assertTrue(moves.contains("G2"));
    }

    @Test
    public void testKingAtD5() {
        ChessPiece king = new King();
        List<String> moves = king.getPossibleMoves("D5");
        // Expected moves: C4, C5, C6, D4, D6, E4, E5, E6
        List<String> expected = Arrays.asList("C4","C5","C6","D4","D6","E4","E5","E6");
        assertEquals(expected.size(), moves.size());
        assertTrue(moves.containsAll(expected));
    }

    @Test
    public void testQueenAtE4() {
        ChessPiece queen = new Queen();
        List<String> moves = queen.getPossibleMoves("E4");
        
        // Just validate a few known positions for brevity
        assertTrue(moves.contains("A4")); // left boundary
        assertTrue(moves.contains("H4")); // right boundary
        assertTrue(moves.contains("E8")); // up boundary
        assertTrue(moves.contains("E1")); // down boundary
        assertTrue(moves.contains("A8")); // diagonal up-left boundary
        assertTrue(moves.contains("H1")); // diagonal down-right boundary
    }

    @Test
    public void testInvalidPosition() {
        ChessPiece king = new King();
        List<String> moves = king.getPossibleMoves("Z10"); // invalid
        assertTrue(moves.isEmpty());
    }

    @Test
    public void testPawnAtLastRank() {
        ChessPiece pawn = new Pawn();
        List<String> moves = pawn.getPossibleMoves("H8");
        // Pawn at H8 cannot move forward (off-board)
        assertTrue(moves.isEmpty());
    }
}
