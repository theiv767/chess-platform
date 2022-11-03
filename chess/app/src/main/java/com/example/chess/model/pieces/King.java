package com.example.chess.model.pieces;

import com.example.chess.model.EnumCor;
import com.example.chess.model.Piece;

public class King extends Piece {

    public King(EnumCor color, int row, int col, String image) {
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
