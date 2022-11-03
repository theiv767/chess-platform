package com.example.chess.model;

public abstract class Piece {
    private EnumCor color;
    private int row, col;
    private String image;
    private boolean eliminated = false;
    private boolean select = false;

    public Piece(EnumCor color, int row, int col, String image){
        this.color = color;
        this.row = row;
        this.col = col;
        this.image = image;
    }

    public abstract boolean checkMoviment(int row, int col);

    public EnumCor getColor() {
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
    public Boolean getEliminated(){
        return eliminated;
    }
    public Boolean getStatus(){
        return select;
    }

    public void setColor(EnumCor color) {
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
    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }
    public void setSelect(boolean select) {
        this.select = select;
    }
}
