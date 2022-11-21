package com.example.chess.model.game.pieces;

import android.widget.ImageView;

import com.example.chess.model.game.EnumColor;
import com.example.chess.model.game.Piece;

public class Pawn extends Piece {

    public Pawn(EnumColor color, int row, int col, ImageView image) {
        super(color, row, col, image);
    }

    @Override
    public boolean checkMoviment(int row, int col) {
        /*MÉTODO DE REGRA DE NEGÓCIO,
         verifica se a peça pode ou não fazer o movimento observado
         */
        return true;
    }
}
