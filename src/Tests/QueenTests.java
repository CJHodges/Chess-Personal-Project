package Tests;

import Pieces.Queen;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import Board.*;

import static org.junit.jupiter.api.Assertions.*;


public class QueenTests {

    private ChessBoard board;
    private Queen whiteQueen;
    private Queen blackQueen;


    @BeforeEach
    public void setUp() {
        board = new ChessBoard();
        whiteQueen = new Queen(true);
        blackQueen = new Queen(false);
        board.getSquare(0, 0).setPiece(whiteQueen);
        board.getSquare(7, 7).setPiece(blackQueen);
    }

    @Test
    public void testValidVerticalMove() {
        Square startSquare = board.getSquare(0, 0);
        Square endSquare = board.getSquare(6, 0);
        assertTrue(whiteQueen.isValidMove(startSquare, endSquare, board.getBoard()));
    }

    @Test
    public void testValidHorizontalMove() {
        Square startSquare = board.getSquare(7, 7);
        Square endSquare = board.getSquare(7, 0);
        assertTrue(blackQueen.isValidMove(startSquare, endSquare, board.getBoard()));
    }

    @Test
    public void testValidDiagonalMove() {
        Square startSquare = board.getSquare(7, 7);
        Square endSquare = board.getSquare(3, 3);
        assertTrue(whiteQueen.isValidMove(startSquare, endSquare, board.getBoard()));
    }

    @Test
    public void testBlockedByOwnPieceDiagonalMove() {
        Square startSquare = board.getSquare(7, 7);
        Square endSquare = board.getSquare(3, 3);
        board.getSquare(5, 5).setPiece(new Queen(false));
        assertFalse(blackQueen.isValidMove(startSquare, endSquare, board.getBoard()));
    }

    @Test
    public void testBlockedByOwnPieceVerticalMove() {
        Square startSquare = board.getSquare(0, 0);
        Square endSquare = board.getSquare(5, 0);
        board.getSquare(3, 0).setPiece(new Queen(true));
        assertFalse(whiteQueen.isValidMove(startSquare, endSquare, board.getBoard()));
    }

    @Test
    public void testBlockedByOwnPieceHorizontalMove() {
        Square startSquare = board.getSquare(0, 0);
        Square endSquare = board.getSquare(0, 7);
        board.getSquare(0, 4).setPiece(new Queen(true));
        assertFalse(whiteQueen.isValidMove(startSquare, endSquare, board.getBoard()));
    }


    @Test
    public void testBlockedByOpponentPieceDiagonalMove() {
        Square startSquare = board.getSquare(7, 7);
        Square endSquare = board.getSquare(3, 3);
        board.getSquare(5, 5).setPiece(new Queen(true));
        assertFalse(blackQueen.isValidMove(startSquare, endSquare, board.getBoard()));
    }

    @Test
    public void testBlockedByOpponentPieceVerticalMove() {
        Square startSquare = board.getSquare(0, 0);
        Square endSquare = board.getSquare(5, 0);
        board.getSquare(3, 0).setPiece(new Queen(false));
        assertFalse(whiteQueen.isValidMove(startSquare, endSquare, board.getBoard()));
    }

    @Test
    public void testBlockedByOpponentPieceHorizontalMove() {
        Square startSquare = board.getSquare(0, 0);
        Square endSquare = board.getSquare(0, 7);
        board.getSquare(0, 4).setPiece(new Queen(false));
        assertFalse(whiteQueen.isValidMove(startSquare, endSquare, board.getBoard()));
    }

    @Test
    public void testCaptureOpponentVertical() {
        Square startSquare = board.getSquare(0, 0);
        Square endSquare = board.getSquare(6, 0);
        endSquare.setPiece(new Queen(false));
        assertTrue(whiteQueen.isValidMove(startSquare, endSquare, board.getBoard()));
    }

    @Test
    public void testCaptureOpponentHorizontal() {
        Square startSquare = board.getSquare(7, 7);
        Square endSquare = board.getSquare(7, 0);
        endSquare.setPiece(new Queen(true));
        assertTrue(blackQueen.isValidMove(startSquare, endSquare, board.getBoard()));
    }

    @Test
    public void testCaptureOpponentDiagonal() {
        Square startSquare = board.getSquare(7, 7);
        Square endSquare = board.getSquare(2, 2);
        endSquare.setPiece(new Queen(true));
        assertTrue(blackQueen.isValidMove(startSquare, endSquare, board.getBoard()));
    }
}

