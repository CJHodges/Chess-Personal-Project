package Board;

import Pieces.*;

import java.util.HashMap;

/**
 * The ChessBoard class represents a chessboard.
 * It contains an 8x8 grid of squares and methods to initialize and manipulate the board.
 *
 * @author Callum Hodges
 * @version 0.1
 * @since 28-05-2024
 */

public class ChessBoard {
    private Square[][] board;

    private HashMap<Piece, Square> WhiteKingLocation;

    private HashMap<Piece, Square> BlackKingLocation;


    /**
     * Constructor for the ChessBoard class.
     * Initializes the 8x8 board and sets up the pieces.
     */
    public ChessBoard() {
        board = new Square[8][8];
        initializeBoard();
    }


    /**
     * Gets the 2D array representing the chessboard.
     *
     * @return The 2D array of squares.
     */
    public Square[][] getBoard() {
        return board;
    }

    /**
     * Initializes the chessboard with squares and sets up the pieces.
     */
    private void initializeBoard() {
        //make the 8x8 grid have x and y values and null pieces
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Square(i, j);
            }
        }
        // Add pieces to the board
    }

    /**
     * Sets up the pieces on the chessboard.
     * This method should be implemented to place pieces in their initial positions.
     */
    public void setupPieces() {
        //Place all pawns on the board and add them to the maps.
        for (int i = 0; i < 8; i++) {
            //create the 2 pawn types
            Pawn pawnIterateWhite = new Pawn(true);
            Pawn pawnIterateBlack = new Pawn(false);

            //place the pawns in the right location
            getSquare(1, i).setPiece(pawnIterateWhite);
            getSquare(6, i).setPiece(pawnIterateBlack);
        }
        for (int i = 1; i<3; i++){
            boolean colour = i%2 == 0;
            int row = i%2 == 0 ? 0 : 7 ;

            //make all other pieces
            Rook Rook = new Rook(colour);
            Knight knight = new Knight(colour);
            Bishop bishop = new Bishop(colour);
            Queen queen = new Queen(colour);
            King king = new King(colour);

            //add pieces to the correct location on the board
            getSquare(row, 0).setPiece(Rook);
            getSquare(row, 7).setPiece(Rook);
            getSquare(row, 1).setPiece(knight);
            getSquare(row, 6).setPiece(knight);
            getSquare(row, 2).setPiece(bishop);
            getSquare(row, 5).setPiece(bishop);
            getSquare(row, 4).setPiece(queen);
            getSquare(row, 5).setPiece(king);
        }

        }


    /**
     * Gets the square at the specified coordinates.
     *
     * @param x The x-coordinate of the square.
     * @param y The y-coordinate of the square.
     * @return The square at the specified coordinates.
     * @throws IllegalArgumentException If the coordinates are out of bounds.
     */
    public Square getSquare(int y, int x) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8) {
            return board[y][x];
        } else {
            throw new IllegalArgumentException("Coordinates out of bounds");
        }
    }

    /**
     * Moves a piece from one square to another based on the provided coordinates.
     *
     * @param currentX The x-coordinate of the current square.
     * @param currentY The y-coordinate of the current square.
     * @param newX     The x-coordinate of the target square.
     * @param newY     The y-coordinate of the target square.
     */
    public boolean movePiece(int currentX, int currentY, int newX, int newY, boolean colour) {
        Square currentSquare = getSquare(currentY, currentX);
        Square newSquare = getSquare(newY, newX);
        return currentSquare.move(newSquare, board, colour);
    }
}

