package com.example.chess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.ImageView;

public class ChessBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chess_board);


        //chessBoard é o gridLayout no centro da tela que representa o tabuleiro
        GridLayout chessBoard = findViewById(R.id.chessBoard);
        chessBoard.setRowCount(8); // setando o número de linhas para 8
        chessBoard.setColumnCount(8); // setando o número de colunas para 8
        for(int i=0; i< chessBoard.getColumnCount(); i++){
            for(int j=0; j< chessBoard.getRowCount(); j++){
                GridLayout.Spec row = GridLayout.spec(j, GridLayout.FILL);
                GridLayout.Spec col = GridLayout.spec(i, GridLayout.FILL);
                GridLayout.LayoutParams coordinates = new GridLayout.LayoutParams(row, col);

                ImageView squared = new ImageView(this);//imagem da casa do tabuleiro

                // controlando se a cor da casa será clara ou escura
                if(i%2 == 0){
                    if(j%2 ==0){
                        squared.setImageResource(R.drawable.whitesquared);
                    }else{
                        squared.setImageResource(R.drawable.darksquared);
                    }
                }else{
                    if(j%2 == 0){
                        squared.setImageResource(R.drawable.darksquared);
                    }else{
                        squared.setImageResource(R.drawable.whitesquared);
                    }
                }
                chessBoard.addView(squared, coordinates); // adicionando uma nova casa no tabuleiro

            }
        } // fim do processo de adicionar as casas do tabuleiro


        



    }
}
