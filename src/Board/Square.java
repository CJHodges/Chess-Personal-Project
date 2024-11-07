package Board;

import Pieces.Piece;

/**
 * The Square class represents a single square on a chessboard.
 * It holds information about its position and the piece currently occupying it.
 *
 *  @author  Callum Hodges
 *  @version 0.1
 *  @since   28-05-2024
 */
public class Square {
    private Piece piece;
    private int x,y ;

    /**
     * Constructor for the Square class.
     * Initializes the square with its coordinates and sets the piece type as empty.
     *
     * @param x The x-coordinate of the square.
     * @param y The y-coordinate of the square.
     */
    public Square(int y, int x){
        this.y = y;
        this.x = x;
        this.piece = null;
    }

    /**
     * Gets the x-coordinate of the square.
     *
     * @return The x-coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y-coordinate of the square.
     *
     * @return The y-coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Gets the piece currently occupying the square.
     *
     * @return The piece occupying the square, or null if the square is empty.
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Sets a piece on the square.
     *
     * @param piece The piece to place on the square.
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * Moves the piece from this square to another square.
     * Checks if the move is valid before performing it.
     *
     * @param newSquare The square to which the piece is being moved.
     * @param board     The 2D array representing the chessboard.
     */
    public boolean move(Square newSquare, Square[][] board, boolean colour) {
        if (this.piece!=null && piece.isValidMove(this, newSquare, board) && piece.isWhite == colour) {
            newSquare.setPiece(piece);
            setPiece(null);
            return true;
        } else {
            System.out.println("Invalid move");
            return false;
        }
    }

}
