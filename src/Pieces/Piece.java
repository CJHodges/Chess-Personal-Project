package Pieces;
import Board.Square;
/**
 * The Piece class represents a generic chess piece.
 * It is an abstract class and serves as a base for all other Pieces
 *
 * @author  Callum Hodges
 * @version 0.1
 * @since   28-05-2024
 */

public abstract class Piece {

    public boolean isWhite;

    /**
     * Constructor for the Piece class.
     * Initializes the piece with its color and direction of movement.
     *
     * @param isWhite True if the piece is white, false if the piece is black.
     */
    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    /**
     * Checks if the piece's move from the current square to the target square is valid.
     * This method must be implemented by subclasses to define specific movement rules.
     *
     * @param currentSquare The square where the piece currently is.
     * @param targetSquare  The square which the piece is attempting to move.
     * @param board         The 2D array representing the chessboard.
     * @return True if the move is valid, false otherwise.
     */
    public abstract boolean isValidMoveSpecific(Square currentSquare, Square targetSquare, Square[][] board);


    public final boolean isValidMove(Square currentSquare, Square targetSquare, Square[][] board) {
        // Check if the piece on the current square is the correct type
        if (currentSquare.getPiece() == null || currentSquare.getPiece().getClass() != this.getClass()) {
            return false;
        }

        // Check if the target square is either empty or contains an opponent's piece
        if (targetSquare.getPiece() != null && targetSquare.getPiece().isWhite == this.isWhite) {
            return false;
        }

        return isValidMoveSpecific(currentSquare, targetSquare, board);
    }
}

