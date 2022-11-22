package com.example.chess;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.example.chess.model.game.ChessBoard;
import com.example.chess.model.game.EnumColor;
import com.example.chess.model.game.pieces.Bishop;
import com.example.chess.model.game.pieces.King;
import com.example.chess.model.game.pieces.Knight;
import com.example.chess.model.game.pieces.Pawn;
import com.example.chess.model.game.pieces.Queen;
import com.example.chess.model.game.pieces.Rook;

import java.util.LinkedList;

public class ChessBoardActivity extends AppCompatActivity {

    // classe auxiliar para mexer no tabuleiro
    ChessBoard chessBoard = new ChessBoard();

    private void initGame(){
        GridLayout chessBoardGrid = findViewById(R.id.chessBoardGrid);
        Log.i("testeee", "criou a tela");
        chessBoardGrid.setRowCount(8); // número de linhas = 8
        chessBoardGrid.setColumnCount(8); //número de colunas = 8

        for (int i = 0; i<chessBoardGrid.getColumnCount(); i++) { // eixo do transitionName(identificador que vou usar)
            int cont = 7;  // eixo y das cordenadas do TransitionName(identificador que vou usar);
            for (int j = 0; j < chessBoardGrid.getRowCount(); j++) {
                GridLayout.Spec row = GridLayout.spec(j);
                GridLayout.Spec col = GridLayout.spec(i);
                GridLayout.LayoutParams coordinates = new GridLayout.LayoutParams(row, col);

                ImageView squared = new ImageView(this);//imagem da casa do tabuleiro
                squared.setLayoutParams(coordinates);

                // controlando se a cor da casa será clara ou escura
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        squared.setImageResource(R.drawable.whitesquared);
                    } else {
                        squared.setImageResource(R.drawable.darksquared);
                    }
                } else {
                    if (j % 2 == 0) {
                        squared.setImageResource(R.drawable.darksquared);
                    } else {
                        squared.setImageResource(R.drawable.whitesquared);
                    }
                }
                squared.getLayoutParams().height = dpToPx(48);
                squared.getLayoutParams().width = dpToPx(48);
                squared.setTransitionName(i+""+cont); //nome para identificação das cordenadas do tabuleiro;
                squared.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("testeee", "squared   "+ v.getTransitionName());
                    }
                });

                chessBoardGrid.addView(squared, coordinates); // adicionando uma nova casa no tabuleiro
                chessBoard.addSquared(i, cont, squared);
                cont--;
            }
        }// fim do processo de adicionar as casas do tabuleiro

        //ADICIONANDO PEÇAS
        for(int i=0; i<8; i++){ // adicionando peões
            //
            ImageView pawnDarkImg = new ImageView(this);
            pawnDarkImg.setImageResource(R.drawable.pawndark);
            chessBoard.addPiece(new Pawn(EnumColor.DARK, 6, i, pawnDarkImg));
            ImageView pawnWhiteImg = new ImageView(this);
            chessBoard.addPiece(new Pawn(EnumColor.DARK, 1, i, pawnWhiteImg));

        }

        ImageView bishopDark1Img = new ImageView(this, null, 0);
        ImageView bishopDark2Img = new ImageView(this);
        ImageView rookDark1Img = new ImageView(this);
        ImageView rookDark2Img = new ImageView(this);
        ImageView knightDark1Img =  new ImageView(this);
        ImageView knightDark2Img =  new ImageView(this);
        ImageView queenDarkImg =  new ImageView(this);
        ImageView kingDarkImg =  new ImageView(this);
        bishopDark1Img.setImageResource(R.drawable.bishopdark);
        bishopDark2Img.setImageResource(R.drawable.bishopdark);
        rookDark1Img.setImageResource(R.drawable.rookdark);
        rookDark2Img.setImageResource(R.drawable.rookdark);
        knightDark1Img.setImageResource(R.drawable.knightdark);
        knightDark2Img.setImageResource(R.drawable.knightdark);
        queenDarkImg.setImageResource(R.drawable.queendark);
        kingDarkImg.setImageResource(R.drawable.kingdark);
        chessBoard.addPiece(new Bishop(EnumColor.DARK, 7, 2, bishopDark1Img));
        chessBoard.addPiece(new Bishop(EnumColor.DARK, 7, 5, bishopDark2Img));
        chessBoard.addPiece(new Knight(EnumColor.DARK, 7, 1, knightDark1Img));
        chessBoard.addPiece(new Knight(EnumColor.DARK, 7, 6, knightDark2Img));
        chessBoard.addPiece(new Rook(EnumColor.DARK, 7, 0, rookDark1Img));
        chessBoard.addPiece(new Rook(EnumColor.DARK, 7, 7, rookDark2Img));
        chessBoard.addPiece(new King(EnumColor.DARK, 4, 7, kingDarkImg));
        chessBoard.addPiece(new Queen(EnumColor.DARK, 7, 3, queenDarkImg));

        chessBoard.getPiece(4, 7).getImage().setLayoutParams(chessBoard.getSquared(4, 7).getLayoutParams());
        chessBoard.getPiece(4, 7).getImage().setLeft(chessBoard.getSquared(4, 7).getLeft());
        chessBoard.getPiece(4, 7).getImage().setTop(chessBoard.getSquared(4, 7).getTop());
        chessBoard.getPiece(4, 7).getImage().setTop(chessBoard.getSquared(4, 7).getTop());
//        chessBoard.getPiece(7, 4).getImage().getLayoutParams().width =
        chessBoardGrid.addView(chessBoard.getPiece(4, 7).getImage());
        //UM CAMINHO PARA ADICIONAR AS PEÇAS


    }

    private int dpToPx(int dp) {
        float density = this.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chess_board);

        initGame();



    }
}
