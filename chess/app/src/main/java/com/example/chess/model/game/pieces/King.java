package com.example.chess.model.game.pieces;

import android.widget.ImageView;

import com.example.chess.model.game.ChessBoard;
import com.example.chess.model.game.EnumColor;
import com.example.chess.model.game.Piece;

public class King extends Piece {

    public King(EnumColor color, int row, int col, ImageView image) {
        super(color, row, col, image);
    }

    @Override
    public boolean checkMoviment(int row, int col, ChessBoard chessBoard) {
        /*MÉTODO DE REGRA DE NEGÓCIO,
         verifica se a peça pode ou não fazer o movimento observado
         */
        return true;
    }
}
