public class Board {


  private int row=0;
  private int col=0;
  private String status="";
  private String color="";

  public Board(int row, int col, String status, String color){
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
  public void setColor(String  color){
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
  public String getColor(){
    return color;
  }


  void printBoard(){


  }




}
