package Tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import Board.*;
import Pieces.Pawn;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Pawn class.
 * Tests the movement and capturing logic of the Pawn pieces.
 *
 *  @author  Callum Hodges
 *  @version 0.1
 *  @since   28-05-2024
 */

public class PawnTests {
    private Pawn whitePawn;
    private Pawn blackPawn;
    private ChessBoard board;

    /**
     * Sets up the test environment before each test.
     * Initializes a chessboard and places pawns on their initial positions.
     */

    @BeforeEach
    public void setUp() {
        board = new ChessBoard();
        whitePawn = new Pawn(true);
        blackPawn = new Pawn(false);

        // Place the pawns on the initial positions for testing
        board.getSquare(1, 1).setPiece(whitePawn);
        board.getSquare(6, 1).setPiece(blackPawn);
    }

    /**
     * Tests the initial two-square move for both white and black pawns.
     */
    @Test
    public void testInitialTwoSquareMove() {
        // White pawn initial move
        assertTrue(whitePawn.isValidMove(board.getSquare(1, 1), board.getSquare(3, 1), board.getBoard()));
        assertFalse(whitePawn.isValidMove(board.getSquare(3,1 ), board.getSquare(5,1), board.getBoard()));

        // Black pawn initial move
        assertTrue(blackPawn.isValidMove(board.getSquare(6, 1), board.getSquare(4, 1), board.getBoard()));
        assertFalse(blackPawn.isValidMove(board.getSquare(4,1 ), board.getSquare(2,1), board.getBoard()));
    }

    /**
     * Tests the regular one-square move for both white and black pawns.
     */
    @Test
    public void testRegularOneSquareMove() {
        // White pawn regular move & test that cannot move 2 after
        assertTrue(whitePawn.isValidMove(board.getSquare(1, 1), board.getSquare(2, 1), board.getBoard()));
        assertFalse(whitePawn.isValidMove(board.getSquare(2,1), board.getSquare(4,1), board.getBoard()));


        // Black pawn regular move & test that cannot move 2 after
        assertTrue(blackPawn.isValidMove(board.getSquare(6, 1), board.getSquare(5, 1), board.getBoard()));
        assertFalse(blackPawn.isValidMove(board.getSquare(5,1), board.getSquare(3,1),board.getBoard()));
    }

    /**
     * Tests the capturing move for both white and black pawns.
     */
    @Test
    public void testCapturingMove() {
        // Place a piece to be captured
        board.getSquare(2, 2).setPiece(blackPawn);
        board.getSquare(2, 0).setPiece(blackPawn);

        // White pawn capturing move
        assertTrue(whitePawn.isValidMove(board.getSquare(1, 1), board.getSquare(2, 2), board.getBoard()));
        assertTrue(whitePawn.isValidMove(board.getSquare(1, 1), board.getSquare(2, 0), board.getBoard()));

        // Place a piece to be captured
        board.getSquare(5, 0).setPiece(whitePawn);
        board.getSquare(5, 2).setPiece(whitePawn);

        // Black pawn capturing move
        assertTrue(blackPawn.isValidMove(board.getSquare(6, 1), board.getSquare(5, 0), board.getBoard()));
        assertTrue(blackPawn.isValidMove(board.getSquare(6, 1), board.getSquare(5, 2), board.getBoard()));
    }
    /**
     * Tests invalid moves for the white pawn, such as moving to an occupied square and capturing an allied piece.
     */
    @Test
    public void testInvalidMove() {
        //make invalid attack move
        assertFalse(whitePawn.isValidMove(board.getSquare(1, 1), board.getSquare(2, 2), board.getBoard()));

        // Attempt to move to an occupied square
        board.getSquare(2, 1).setPiece(new Pawn(true));
        assertFalse(whitePawn.isValidMove(board.getSquare(1, 1), board.getSquare(2, 1), board.getBoard()));

        // Attempt to capture an allied piece
        board.getSquare(2, 2).setPiece(new Pawn(true));
        assertFalse(whitePawn.isValidMove(board.getSquare(1, 1), board.getSquare(2, 2), board.getBoard()));

        // Attempt to move that a pawn cannot make
        assertFalse(whitePawn.isValidMove(board.getSquare(1,1), board.getSquare(7,7), board.getBoard()));

        //make invalid attack move
        assertFalse(blackPawn.isValidMove(board.getSquare(6, 1), board.getSquare(5, 0), board.getBoard()));

        // Attempt to move to an occupied square
        board.getSquare(5, 1).setPiece(new Pawn(false));
        assertFalse(blackPawn.isValidMove(board.getSquare(6, 1), board.getSquare(5, 1), board.getBoard()));

        // Attempt to capture an allied piece
        board.getSquare(5, 0).setPiece(new Pawn(false));
        assertFalse(blackPawn.isValidMove(board.getSquare(6, 1), board.getSquare(5, 0), board.getBoard()));

    }

    @Test
    public void testMoveNowhere(){
        Square startSquare = board.getSquare(1,1);
        assertFalse(whitePawn.isValidMove(startSquare, startSquare, board.getBoard()));
    }

}

