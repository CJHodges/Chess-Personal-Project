package Pieces;

import Board.Square;

/**
 * The Pawn class represents a pawn piece in a chess game.
 * It extends the abstract Piece class and implements specific movement rules for a pawn.
 *
 *  @author  Callum Hodges
 *  @version 0.1
 *  @since   28-05-2024
 */
public class Pawn extends Piece {
    private boolean FirstMove;

    private int direction;

    /**
     * Constructor for the Pawn class.
     * Initializes the pawn with its color and sets its first move status to true.
     *
     * @param isWhite True if the pawn is white, false if the pawn is black.
     */
    public Pawn(boolean isWhite) {
        super(isWhite);
        this.FirstMove = true;
        this.direction = isWhite ? 1 : -1;

    }

    /**
     * Sets the first move status of the pawn to false
     */
    public void setFirstMove() {
        FirstMove = false;
    }

    /**
     * Checks if the pawn's move from the current square to the target square is valid.
     *
     * @param currentSquare The square where the pawn currently is.
     * @param targetSquare  The square which the pawn is attempting to move.
     * @param board         The 2D array representing the chessboard.
     * @return True if the move is valid, false otherwise.
     */
    @Override
    public boolean isValidMoveSpecific(Square currentSquare, Square targetSquare, Square[][] board) {
        int currentX = currentSquare.getX();
        int currentY = currentSquare.getY();
        int targetX = targetSquare.getX();
        int targetY = targetSquare.getY();


            //move 2 ahead
        if ((targetY == currentY + 2 * direction) && (currentX == targetX) && FirstMove && (checkahead(currentSquare, board)) && targetSquare.getPiece()==null) {
            setFirstMove();
            return true;

            //attacking move
        } else if (targetY - currentY  == direction && Math.abs(currentX - targetX) == 1 && targetSquare.getPiece() != null && this.isWhite != targetSquare.getPiece().isWhite
        ) {
            return true;

            //move 1 ahead
        } else if (checkahead(currentSquare, board) && targetY == currentY + direction && (currentX == targetX)) {
            if (FirstMove) {
                setFirstMove();
            }
            return true;
        } else
            return false;
    }

    /**
     * Checks if the square directly ahead of the pawn is empty.
     *
     * @param currentSquare The square where the pawn currently is.
     * @param board         The 2D array representing the chessboard.
     * @return True if the square ahead is empty, false otherwise.
     */
    public boolean checkahead(Square currentSquare, Square[][] board) {
        Square targetSquare = board[currentSquare.getY() + this.direction][currentSquare.getX()];
        if (targetSquare.getPiece() == null) {
            return true;
        } else
            return false;
    }
}