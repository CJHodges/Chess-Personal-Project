package Pieces;

import Board.Square;

/**
 * The Rook class represents a rook piece in a chess game.
 * It extends the abstract Piece class and implements specific movement rules for a rook.
 *
 * @author Callum Hodges
 * @version 0.1
 * @since 28-05-2024
 */
public class Rook extends Piece {
    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMoveSpecific(Square currentSquare, Square targetSquare, Square[][] board) {
        int currentX = currentSquare.getX();
        int currentY = currentSquare.getY();
        int targetX = targetSquare.getX();
        int targetY = targetSquare.getY();

        if (currentX == targetX) { // Vertical move
            int step = currentY < targetY ? 1 : -1; //if target y is greater than current y step =+1 else step =-1
            for (int y = currentY + step; y != targetY; y += step) {
                if (board[y][currentX].getPiece() != null) {
                    return false;
                }
            }

        } else if (currentY == targetY) { // Horizontal move
            int step = currentX < targetX ? 1 : -1; //if target x is greater than current x step =+1 else step =-1
            for (int x = currentX + step; x != targetX; x += step) {
                if (board[currentY][x].getPiece() != null) {
                    return false;
                }
            }

        } else {
            return false;
        }
        return true;
    }
}

