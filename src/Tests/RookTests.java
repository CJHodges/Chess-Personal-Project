package Tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import Board.*;
import Pieces.Rook;

import static org.junit.jupiter.api.Assertions.*;


public class RookTests {
    private ChessBoard board;
    private Rook whiteRook;
    private Rook blackRook;

    @BeforeEach
    public void setUp() {
        board = new ChessBoard();
        whiteRook = new Rook(true);
        blackRook = new Rook(false);
        board.getSquare(0, 0).setPiece(whiteRook);
        board.getSquare(7, 7).setPiece(blackRook);
    }

    @Test
    public void testValidVerticalMove() {
        Square startSquare = board.getSquare(0, 0);
        Square endSquare = board.getSquare(5, 0);
        assertTrue(whiteRook.isValidMove(startSquare, endSquare, board.getBoard()));
    }

    @Test
    public void testValidHorizontalMove() {
        Square startSquare = board.getSquare(0, 0);
        Square endSquare = board.getSquare(0, 5);
        assertTrue(whiteRook.isValidMove(startSquare, endSquare, board.getBoard()));
    }

    @Test
    public void testInvalidMoveDiagonal() {
        Square startSquare = board.getSquare(0, 0);
        Square endSquare = board.getSquare(3, 3);
        assertFalse(whiteRook.isValidMove(startSquare, endSquare, board.getBoard()));
    }

    @Test
    public void testBlockedBySameColorPiece() {
        board.getSquare(3, 0).setPiece(new Rook(true)); // Place another white rook in the path
        Square startSquare = board.getSquare(0, 0);
        Square endSquare = board.getSquare(5, 0);
        assertFalse(whiteRook.isValidMove(startSquare, endSquare, board.getBoard()));
    }

    @Test
    public void testBlockedByOpponentPiece() {
        board.getSquare(3, 0).setPiece(new Rook(false)); // Place a black rook in the path
        Square startSquare = board.getSquare(0, 0);
        Square endSquare = board.getSquare(5, 0);
        assertFalse(whiteRook.isValidMove(startSquare, endSquare, board.getBoard()));
    }

    @Test
    public void testCaptureOpponentPiece() {
        board.getSquare(5, 0).setPiece(new Rook(false)); // Place a black rook on the target square
        Square startSquare = board.getSquare(0, 0);
        Square endSquare = board.getSquare(5, 0);
        assertTrue(whiteRook.isValidMove(startSquare, endSquare, board.getBoard()));
    }

    @Test
    public void testInvalidMoveSameSquare() {
        Square startSquare = board.getSquare(0, 0);
        assertFalse(whiteRook.isValidMove(startSquare, startSquare, board.getBoard()));
    }

    @Test
    public void testMoveToOccupiedSquareSameColor() {
        board.getSquare(0, 5).setPiece(new Rook(true)); // Place another white rook on the target square
        Square startSquare = board.getSquare(0, 0);
        Square endSquare = board.getSquare(0, 5);
        assertFalse(whiteRook.isValidMove(startSquare, endSquare, board.getBoard()));
    }
}

