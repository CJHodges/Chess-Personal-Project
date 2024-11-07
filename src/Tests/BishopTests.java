package Tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import Board.*;
import Pieces.Bishop;

import static org.junit.jupiter.api.Assertions.*;

public class BishopTests {
    private ChessBoard board;
    private Bishop whiteBishop;
    private Bishop blackBishop;

    @BeforeEach
    public void setUp() {
        board = new ChessBoard();
        whiteBishop = new Bishop(true);
        blackBishop = new Bishop(false);
        board.getSquare(0, 0).setPiece(whiteBishop);
        board.getSquare(7, 7).setPiece(blackBishop);
    }

    @Test
    public void testValidDiagonal(){
        Square startSquare = board.getSquare(0,0);
        Square endSquare = board.getSquare(3,3);
        assertTrue(whiteBishop.isValidMove(startSquare, endSquare, board.getBoard()));
    }

    @Test
    public void testBlockedBySameColourPiece(){
        Square startSquare = board.getSquare(0,0);
        Square endSquare = board.getSquare(3,3);
        Bishop block = new Bishop(true);
        board.getSquare(2,2).setPiece(block);
        assertFalse(whiteBishop.isValidMove(startSquare, endSquare, board.getBoard()));
    }

    @Test
    public void testBlockedByOpponentPiece(){
        Square startSquare = board.getSquare(0,0);
        Square endSquare = board.getSquare(3,3);
        Bishop block = new Bishop(false);
        board.getSquare(2,2).setPiece(block);
        assertFalse(whiteBishop.isValidMove(startSquare, endSquare, board.getBoard()));
    }


    @Test
    public void testCaptureOpponentPiece(){
        Square startSquare = board.getSquare(7,7);
        Square endSquare = board.getSquare(3,3);
        Bishop fool = new Bishop(true);
        endSquare.setPiece(fool);
        assertTrue(blackBishop.isValidMove(startSquare, endSquare, board.getBoard()));
    }

    @Test
    public void testCaptureSameColourPiece(){
        Square startSquare = board.getSquare(7,7);
        Square endSquare = board.getSquare(3,3);
        Bishop fool = new Bishop(false);
        endSquare.setPiece(fool);
        assertFalse(blackBishop.isValidMove(startSquare, endSquare, board.getBoard()));
    }
    @Test
    public void testMoveNowhere(){
        Square startSquare = board.getSquare(7,7);
        assertFalse(blackBishop.isValidMove(startSquare, startSquare, board.getBoard()));
    }

    @Test
    public void testInvalidMoveLocation(){
        Square startSquare = board.getSquare(7,7);
        Square endSquare = board.getSquare(3,5);
        assertFalse(blackBishop.isValidMove(startSquare, endSquare, board.getBoard()));
    }


}
