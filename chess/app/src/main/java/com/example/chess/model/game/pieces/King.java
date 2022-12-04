package com.example.chess.model.game.pieces;

import android.widget.ImageView;

import com.example.chess.model.game.ChessBoard;
import com.example.chess.model.game.EnumColor;
import com.example.chess.model.game.Piece;

public class King extends Piece {
    private boolean canCastle = true;
    public King(EnumColor color, int row, int col, ImageView image) {
        super(color, row, col, image);
        this.setCanCastle(true);
    }

    @Override
    public String checkMoviment(int row, int col, ChessBoard chessBoard) {

        //1- testar roques(castle), função isCanCastle() retorna se ainda pode ou não fazer roque (essa função tem em toda peça)

        //2-ver os outros lançes possíveis

        // finish
        canCastle = false;
        return "";
    }

}
