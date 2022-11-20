package com.example.chess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.example.chess.model.game.ChessBoard;

public class ChessBoardActivity extends AppCompatActivity {

    // classe auxiliar para mexer no tabuleiro
    ChessBoard chessBoard = new ChessBoard();


    private int dpToPx(int dp) {
        float density = this.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chess_board);


        //chessBoard é o gridLayout no centro da tela que representa o tabuleiro
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




    }
}
