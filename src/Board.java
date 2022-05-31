public class Board {


  private int row=0;
  private int col=0;
  private String status="";
  private char color;

  public Board(int row, int col, String status, char color){
    this.row=row;
    this.col=col;
    this.status=status;
    this.color=color;

  }
  public void setLoc(int row, int col){
    this.row=row;
    this.col=col;


  }
  public void setStatus(String status){
    this.status=status;
  }
  public void setColor(char color){
    this.color=color;
  }
  public int getRow(){
    return row;
  }

  public int getCol(){
    return col;
  }

  public String getStatus(){
    return status;
  }
  public char getColor(){
    return color;
  }


  void printBoard(){


  }




}
