package Pieces;

import Board.Square;

/**
 * The Bishop class represents a bishop piece in a chess game.
 * It extends the abstract Piece class and implements specific movement rules for a bishop.
 *
 * @author Callum Hodges
 * @version 0.1
 * @since 28-05-2024
 */
public class Bishop extends Piece {
    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    /**
     * @param currentSquare description of parameter
     * @param targetSquare  description of parameter
     * @param board         description of parameter
     * @return description of return value
     */
    @Override
    public boolean isValidMoveSpecific(Square currentSquare, Square targetSquare, Square[][] board) {
        // Bishop moves diagonally
        int currentX = currentSquare.getX();
        int currentY = currentSquare.getY();
        int targetX = targetSquare.getX();
        int targetY = targetSquare.getY();

        if (Math.abs(currentX - targetX) == Math.abs(currentY - targetY)) {
            int stepX = currentX < targetX ? 1 : -1;
            int stepY = currentY < targetY ? 1 : -1;
            for (int x = currentX + stepX, y = currentY + stepY; x != targetX && y != targetY; x += stepX, y += stepY) {
                if (board[y][x].getPiece() != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
