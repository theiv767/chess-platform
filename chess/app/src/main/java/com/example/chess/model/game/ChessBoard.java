package com.example.chess.model.game;

import android.widget.ImageView;

//tabuleiro de xadrez
public class ChessBoard {
    private Piece[][] pieces = new Piece[8][8];
    private ImageView[][] squares = new ImageView[8][8];
    private SelectedPiece selectedPiece = null;
    private EnumColor turn = EnumColor.WHITE;

    public ChessBoard(){

    }

    public void addSquared(int row, int col, ImageView squared){
        this.squares[row][col] = squared;
    }
    public void addPiece(Piece piece){
        this.pieces[piece.getRow()][piece.getCol()] = piece;
        piece.setChessBoard(this);
    }
//    public void selectPiece(Piece piece){
//        if(piece.isSelected()){ //clicando em uma peça já selecionada
//            piece.setSelected(false);
//            this.selectedPiece = null;
//        }else{  //clicando em uma peça que não estava selecionada
//            piece.setSelected(true);
//            this.selectedPiece = piece;
//        }
//    }

    public void movPiece(SelectedPiece piece, int row, int col){

        this.pieces[row][col] = selectedPiece.getPiece();
        this.pieces[selectedPiece.getRow()][selectedPiece.getCol()] = null;
        this.pieces[row][col].getImage().setLayoutParams(squares[row][col].getLayoutParams());
        this.selectedPiece = null;

    }

    public void changeTurn(){
        if(this.turn.equals(EnumColor.WHITE)){
            this.turn = EnumColor.DARK;
        }else{
            this.turn = EnumColor.WHITE;
        }

    }

    public Piece getPiece(int row, int col) {
        return pieces[row][col];
    }

    public ImageView getSquared(int row, int col) {
        return squares[row][col];
    }

    public SelectedPiece getSelectedPiece() {
        return selectedPiece;
    }

    public EnumColor getTurn() {
        return turn;
    }

    public void setPiece(Piece[][] pieces) {
        this.pieces = pieces;
    }

    public void setSquare(int row, int col, ImageView image) {
        this.squares[row][col] = image;
    }

    public void setSelectedPiece(int row, int col) {
        this.selectedPiece = new SelectedPiece(row, col, this.getPiece(row, col));
    }

    public void setTurn(EnumColor turn) {
        this.turn = turn;
    }
}
