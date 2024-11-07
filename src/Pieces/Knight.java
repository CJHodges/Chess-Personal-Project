package Pieces;

import Board.Square;

/**
 * The Knight class represents a knight piece in a chess game.
 * It extends the abstract Piece class and implements specific movement rules for a knight.
 *
 *  @author  Callum Hodges
 *  @version 0.1
 *  @since   28-05-2024
 */
public class Knight extends Piece{
    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMoveSpecific(Square currentSquare, Square targetSquare, Square[][] board) {

        if (Math.abs(currentSquare.getX() - targetSquare.getX()) == 1 &&
                Math.abs(currentSquare.getY() - targetSquare.getY()) == 2) {
            return true;

        } else if (Math.abs(currentSquare.getX() - targetSquare.getX()) == 2 &&
                Math.abs(currentSquare.getY() - targetSquare.getY()) == 1){
            return true;

        }else{
            return false;
        }
    }




}
