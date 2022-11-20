package com.example.chess.model.game;

//tabuleiro de xadrez
public class ChessBoard {
    private Piece[][] pieces = new Piece[8][8];
    private Piece selectedPiece = null;
    private EnumColor turn = EnumColor.BRANCO;

    public ChessBoard(){

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
