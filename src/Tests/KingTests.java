package Tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import Board.*;
import Pieces.King;

import static org.junit.jupiter.api.Assertions.*;

public class KingTests {
    private ChessBoard board;
    private King whiteKing;
    private King blackKing;

    @BeforeEach
    public void setUp() {
        board = new ChessBoard();
        whiteKing = new King(true);
        blackKing = new King(false);
        board.getSquare(0, 0).setPiece(whiteKing);
        board.getSquare(7, 7).setPiece(blackKing);
    }

    @Test
    public void testValidVertical(){
        Square startSquare = board.getSquare(0,0);
        Square endSquare = board.getSquare(1,0);
        assertTrue(whiteKing.isValidMove(startSquare, endSquare,board.getBoard()));
    }

    @Test
    public void testValidHorizontal(){
        Square startSquare = board.getSquare(7,7);
        Square endSquare = board.getSquare(7,6);
        assertTrue(blackKing.isValidMove(startSquare, endSquare,board.getBoard()));
    }

    @Test
    public void testValidDiagonal(){
        Square startSquare = board.getSquare(7,7);
        Square endSquare = board.getSquare(6,6);
        assertTrue(blackKing.isValidMove(startSquare, endSquare,board.getBoard()));
    }

    @Test
    public void testBlockedHorizontal(){
        Square startSquare = board.getSquare(7,7);
        Square endSquare = board.getSquare(7,6);
        endSquare.setPiece(new King(false));
        assertFalse(blackKing.isValidMove(startSquare, endSquare,board.getBoard()));
    }

    @Test
    public void testBlockedVertical(){
        Square startSquare = board.getSquare(0,0);
        Square endSquare = board.getSquare(1,0);
        endSquare.setPiece(new King(true));
        assertFalse(whiteKing.isValidMove(startSquare, endSquare,board.getBoard()));
    }

    @Test
    public void testBlockedDiagonal(){
        Square startSquare = board.getSquare(0,0);
        Square endSquare = board.getSquare(1,1);
        endSquare.setPiece(new King(true));
        assertFalse(whiteKing.isValidMove(startSquare, endSquare,board.getBoard()));
    }

    @Test
    public void testCaptureOpponentDiagonal(){
        Square startSquare = board.getSquare(0,0);
        Square endSquare = board.getSquare(1,1);
        endSquare.setPiece(new King(false));
        assertTrue(whiteKing.isValidMove(startSquare, endSquare,board.getBoard()));
    }

    @Test
    public void testCaptureOpponentVertical(){
        Square startSquare = board.getSquare(0,0);
        Square endSquare = board.getSquare(1,0);
        endSquare.setPiece(new King(false));
        assertTrue(whiteKing.isValidMove(startSquare, endSquare,board.getBoard()));
    }

    @Test
    public void testCaptureOpponentHorizontal(){
        Square startSquare = board.getSquare(0,0);
        Square endSquare = board.getSquare(0,1);
        endSquare.setPiece(new King(false));
        assertTrue(whiteKing.isValidMove(startSquare, endSquare,board.getBoard()));
    }

    @Test
    public void testInvalidMoveLocation(){
        Square startSquare = board.getSquare(0,0);
        Square endSquare = board.getSquare(6,4);
        assertFalse(whiteKing.isValidMove(startSquare, endSquare,board.getBoard()));
    }


}