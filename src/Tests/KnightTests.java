package Tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import Board.*;
import Pieces.Knight;

import static org.junit.jupiter.api.Assertions.*;


public class KnightTests {

    private ChessBoard board;
    private Knight whiteKnight;
    private Knight blackKnight;


    @BeforeEach
    public void setUp() {
        board = new ChessBoard();
        whiteKnight = new Knight(true);
        blackKnight = new Knight(false);
        board.getSquare(0, 5).setPiece(whiteKnight);
        board.getSquare(7, 5).setPiece(blackKnight);
    }

    @Test
    public void testValidMove1(){
        Square startSquare = board.getSquare(0,5);
        Square endSquare = board.getSquare(1,3);
        assertTrue(whiteKnight.isValidMove(startSquare, endSquare, board.getBoard()));

    }

    @Test
    public void testValidMove2(){
        Square startSquare = board.getSquare(7,5);
        Square endSquare = board.getSquare(5,4);
        assertTrue(blackKnight.isValidMove(startSquare, endSquare, board.getBoard()));
    }

    @Test
    public void testBlockedMove1(){
        Square startSquare = board.getSquare(0,5);
        Square endSquare = board.getSquare(1,3);
        endSquare.setPiece(new Knight(true));
        assertFalse(whiteKnight.isValidMove(startSquare, endSquare, board.getBoard()));
    }

    @Test
    public void testBlockedMove2(){
        Square startSquare = board.getSquare(7,5);
        Square endSquare = board.getSquare(5,4);
        endSquare.setPiece(new Knight(false));
        assertFalse(blackKnight.isValidMove(startSquare, endSquare, board.getBoard()));
    }

    @Test
    public void testValidCaptureMove1(){
        Square startSquare = board.getSquare(0,5);
        Square endSquare = board.getSquare(1,3);
        endSquare.setPiece(new Knight(false));
        assertTrue(whiteKnight.isValidMove(startSquare, endSquare, board.getBoard()));

    }

    @Test
    public void testValidCaptureMove2(){
        Square startSquare = board.getSquare(7,5);
        Square endSquare = board.getSquare(5,4);
        endSquare.setPiece(new Knight(true));
        assertTrue(blackKnight.isValidMove(startSquare, endSquare, board.getBoard()));

    }

    @Test
    public void testInvalidLocation(){
        Square startSquare = board.getSquare(7,5);
        Square endSquare = board.getSquare(0,0);
        assertFalse(blackKnight.isValidMove(startSquare,endSquare, board.getBoard()));
    }

    @Test
    public void testMoveNowhere(){
        Square startSquare = board.getSquare(7,5);
        assertFalse(blackKnight.isValidMove(startSquare,startSquare,board.getBoard()));
    }
}
