package Pieces;

import Board.Square;

/**
 * The Queen class represents a queen piece in a chess game.
 * It extends the abstract Piece class and implements specific movement rules for a queen.
 *
 *  @author  Callum Hodges
 *  @version 0.1
 *  @since   28-05-2024
 */
public class Queen extends Piece {
    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMoveSpecific(Square currentSquare, Square targetSquare, Square[][] board) {
        int currentX = currentSquare.getX();
        int currentY = currentSquare.getY();
        int targetX = targetSquare.getX();
        int targetY = targetSquare.getY();

        // Check if the move is along a column
        if (currentX == targetX) {
            int step = currentY < targetY ? 1 : -1;
            for (int y = currentY + step; y != targetY; y += step) {
                if (board[y][currentX].getPiece() != null) {
                    return false;
                }
            }
            return true;
        }

        // Check if the move is along a row
        if (currentY == targetY) {
            int step = currentX < targetX ? 1 : -1;
            for (int x = currentX + step; x != targetX; x += step) {
                if (board[currentY][x].getPiece() != null) {
                    return false;
                }
            }
            return true;
        }

        // Check if the move is along a diagonal
        int xStep = currentX < targetX ? 1 : -1;
        int yStep = currentY < targetY ? 1 : -1;
        if (Math.abs(currentX - targetX) == Math.abs(currentY - targetY)) {
            for (int x = currentX + xStep, y = currentY + yStep; x != targetX; x += xStep, y += yStep) {
                if (board[y][x].getPiece() != null) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }




}
