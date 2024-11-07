package Game;

import Board.*;
import Pieces.*;

import java.util.Scanner;

public class GameLogic {
    private ChessBoard chessBoard;
    private boolean gameOver;
    private Scanner in;

    public GameLogic() {
        chessBoard = new ChessBoard();
        chessBoard.setupPieces();
        gameOver = false;
        in = new Scanner(System.in);

        startGame();
    }
//temporary game loop to test functionality
    private void startGame() {
        int turnNum = 1;

        do {
            boolean colourTurn = turnNum % 2 != 0 ? true : false;
            String colour = turnNum % 2 != 0 ? "white" : "black";

            System.out.println(colour + " player please move ");
            System.out.println("Y of Piece to move: ");
            int CurrentY = in.nextInt();
            System.out.println("X of Piece to move: ");
            int CurrentX = in.nextInt();

            System.out.println("Y of Location to move to: ");
            int NextY = in.nextInt();
            System.out.println("X of Location to move to: ");
            int NextX = in.nextInt();

            boolean KingCheck = chessBoard.getSquare(NextY, NextX).getPiece() instanceof King;

            if (KingCheck && chessBoard.movePiece(CurrentX, CurrentY, NextX, NextY, colourTurn)) {
                System.out.println("Congrats " + colour +" you took the enemy King");
                gameOver = true;
            } else if (chessBoard.movePiece(CurrentX, CurrentY, NextX, NextY, colourTurn)) {
                turnNum++;
            }

            } while (!gameOver);
    }


}

