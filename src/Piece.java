public class Piece {
    private int row = 0;
    private int col = 0;
    private String color="";
    private int type;


    public Piece(int row, int col, String color, int type) {
        this.row = row;
        this.col = col;
        this.color = color;
        this.type = type;
    }


    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }

    public String getColor(){
        return color;
    }
    public int getType(){
        return type;
    }


}


