package com.example.chess.model.game.pieces;

import android.widget.ImageView;

import com.example.chess.model.game.ChessBoard;
import com.example.chess.model.game.EnumColor;
import com.example.chess.model.game.Piece;

public class Pawn extends Piece {

    public Pawn(EnumColor color, int row, int col, ImageView image) {
        super(color, row, col, image);
    }

    @Override
    public String checkMoviment(int row, int col, ChessBoard chessBoard) {

        if (this.getColor() == EnumColor.WHITE) {
            if (this.getRow() == 1) { // primeiro lançe que pode ser de uma ou duas casas
                if ((row == 2 || row == 3) && (col == this.getCol()))
                    return "true DEFAULT";
                else
                    return "false null";

            } else {
                if ((row == this.getRow() + 1) && (col == this.getCol())) {
                    if (chessBoard.getPiece(row, col) == null) {
                        return "true DEFAULT";
                    }
                }
                if (row == this.getRow() + 1 && (col == this.getCol() + 1 || col == this.getCol() - 1)) {
                    if (chessBoard.getPiece(row, col) == null)
                        return "false null";
                    if (chessBoard.getPiece(row, col).getColor() == EnumColor.DARK) {
                        return "true CAPTURE";
                    }
                }
                return "false null";
            }
        } else { //lances das pretas
            if (this.getRow() == 6) { // primeiro lançe que pode ser de uma ou duas casas
                if ((row == 5 || row == 4) && (col == this.getCol()))
                    return "true DEFAULT";
                else
                    return "false null";

            } else {
                if ((row == this.getRow() - 1) && (col == this.getCol())) {
                    if (chessBoard.getPiece(row, col) == null) {
                        return "true DEFAULT";
                    }
                }
                if (row == this.getRow() - 1 && (col == this.getCol() + 1 || col == this.getCol() - 1)) {
                    if (chessBoard.getPiece(row, col) == null)
                        return "false null";
                    if (chessBoard.getPiece(row, col).getColor() == EnumColor.WHITE) {
                        return "true CAPTURE";
                    }
                }
                return "false null";
            }
        }
    }
}
