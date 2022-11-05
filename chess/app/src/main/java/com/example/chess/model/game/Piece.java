package com.example.chess.model.game;

public abstract class Piece {
    private EnumColor color;  // 0 para brancas, 1 para pretas
    private int row, col;
    private String image;
    private ChessBoard chessBoard;
    private boolean eliminated = false;
    private boolean selected = false;

    public Piece(EnumColor color, int row, int col, String image){
        this.color = color;
        this.row = row;
        this.col = col;
        this.image = image;
    }

    public abstract boolean checkMoviment(int row, int col);

    public EnumColor getColor() {
        return color;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String getImage() {
        return image;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public boolean isEliminated() {
        return eliminated;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setColor(EnumColor color) {
        this.color = color;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }

    public void setSelected(boolean select) {
        this.selected = select;
    }
}
