public class Piece {
    private int row = 0;
    private int col = 0;
    private char color;
    private int type;


    public Piece(int row, int col, char color, int type) {
        this.row = row;
        this.col = col;
        this.color = color;
        this.type = type;
    }

w
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }

    public char getColor(){
        return color;
    }
    public int getType(){
        return type;
    }


}


