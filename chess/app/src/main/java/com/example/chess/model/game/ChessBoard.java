package com.example.chess.model.game;

import android.widget.ImageView;

//tabuleiro de xadrez
public class ChessBoard {
    private Piece[][] pieces = new Piece[8][2];
    private ImageView[][] squares = new ImageView[8][8];
    private Piece selectedPiece = null;
    private EnumColor turn = EnumColor.BRANCO;

    public ChessBoard(){

    }

    public void addSquared(int row, int col, ImageView squared){
        this.squares[row][col] = squared;
    }

    public ImageView getSquared(int row, int col){
        return this.squares[row][col];
    }

    public Piece getPiece(int row, int col){
        return this.pieces[row][col];
    }

    public void addPiece(Piece piece){
        this.pieces[piece.getRow()][piece.getCol()] = piece;
        piece.setChessBoard(this);
    }

    public void selectPiece(Piece piece){
        if(piece.isSelected()){ //clicando em uma peça já selecionada
            piece.setSelected(false);
            this.selectedPiece = null;
        }else{  //clicando em uma peça que não estava selecionada
            piece.setSelected(true);
            this.selectedPiece = piece;
        }
    }

    public void movPiece(Piece piece, int row, int col){
        // especificar um movimento de uma peça no contrutor
        //testar se é possível fazer esse movimento com o métodó que testa isso na peça
        //se for possível: fazer o movimento, se não: dizer que não pode
    }

    public void changeTurn(){
        if(this.turn.equals(EnumColor.BRANCO)){
            this.turn = EnumColor.PRETO;
        }else{
            this.turn = EnumColor.BRANCO;
        }

    }

}
