package Pieces;

import Board.Square;

/**
 * The King class represents a king piece in a chess game.
 * It extends the abstract Piece class and implements specific movement rules for a king.
 *
 *  @author  Callum Hodges
 *  @version 0.1
 *  @since   28-05-2024
 */
public class King extends Piece {

    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMoveSpecific(Square currentSquare, Square targetSquare, Square[][] board) {

        if (Math.abs(currentSquare.getX() - targetSquare.getX()) <= 1 &&
                Math.abs(currentSquare.getY() - targetSquare.getY()) <= 1) {
            return true;
        }
        return false;
    }
}
