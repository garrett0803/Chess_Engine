import java.lang.Math;
import java.util.Scanner;

public class Game {

    public Board[][] gameBoard;
    public Board[] wpieces=new Board[16];
    public Board[] bpieces=new Board[16];

    /*linked list to store each players pieces
      data will hold abstract to piece class holding location and piece value IE (king, queen, ect)


     */

    public Node head=null;
    public tail=null;
    public next=null;



    public void createBoard(){
        gameBoard = new Board[8][8];
        for(int i=0; i<8;i++){
            for(int j=0; j<8; j++){
                Board b=new Board(i,j,0, '-');
                gameBoard[i][j]=b;

            }
        }
    }


    public void assignLoc(){
        int z=0;
        int y=2;
        for(int i=1; i<7;i++){
            if(i==1 || i==2){
                if(i==1) {
                    wpieces[0].setLoc(0,4);
                    bpieces[0].setLoc(7,4);
                    gameBoard[0][4].setStatus(i);
                    gameBoard[0][4].setColor('W');
                    gameBoard[7][4].setStatus(i);
                    gameBoard[7][4].setColor('B');
                }
                else {
                    wpieces[1].setLoc(0,3);
                    bpieces[1].setLoc(7,3);
                    gameBoard[0][3].setStatus(i);
                    gameBoard[0][3].setColor('W');
                    gameBoard[7][3].setStatus(i);
                    gameBoard[7][3].setColor('B');
                }
            }

            else if(i==6){
                for(int j=0;j<8;j++) {
                    gameBoard[1][j].setStatus(i);
                    gameBoard[1][j].setColor('W');
                    gameBoard[6][j].setStatus(i);
                    gameBoard[6][j].setColor('B');
                }
            }
            else{

                gameBoard[0][y].setStatus(i);
                gameBoard[0][y].setColor('W');
                gameBoard[7][y].setStatus(i);
                gameBoard[7][y].setColor('B');
                gameBoard[0][y+i+z].setStatus(i);
                gameBoard[0][y+i+z].setColor('W');
                gameBoard[7][y+i+z].setStatus(i);
                gameBoard[7][y+i+z].setColor('B');
                z++;
                y--;

                }


        }
    }

    public boolean isValid(int row, int col, Board curPiece){
        int rowDif=0;
        int colDif=0;

        if((row < 8 && row>=0)&&(col<8) && (col < 8 && col >=0 )){
            rowDif=row- curPiece.getRow();
            colDif=col- curPiece.getCol();
            switch (curPiece.getStatus()){
                case 1:
                    if(Math.abs(rowDif)<2 && Math.abs(colDif)<2){
                        return true;
                    }
                    else{
                        return false;
                    }

                case 2:
                    if(rowDif==0||colDif==0||(row!= curPiece.getRow()&&Math.abs(rowDif)==Math.abs(colDif))){
                        return true;
                    }
                    else{
                        return false;
                    }

                case 3:
                    if(row!= curPiece.getRow()&&Math.abs(rowDif)==Math.abs(colDif)){
                        return true;
                    }
                    else{
                        return false;
                    }

                case 4:
                    if(row!= curPiece.getRow()){
                        if(Math.abs(rowDif)==2&&Math.abs(colDif)==1){
                            return true;
                        }
                        else if(Math.abs(rowDif)==1&&Math.abs(colDif)==2){
                            return true;
                        }
                        else{
                            return false;
                        }
                    }
                    else{
                        return false;
                    }

                case 5:
                    if(row== curPiece.getRow()||col== curPiece.getCol()){
                        return true;
                    }

                    else{
                        return false;
                    }

                case 6:
                    if(rowDif==1 && colDif==0){
                        return true;
                    }
                    else{
                        return false;
                    }
            }
        }

        else{
            return false;
        }
        return false;

    }
    public char getColor(int row, int col){
        return gameBoard[row][col].getColor();
    }

    public boolean checkMate(int row, int col){
        if(isValid(row, col, gameBoard[row][col])&(gameBoard[row][col].getStatus()==1)){
            return true;

        }
        return false;
    }

    /*public int DTC(){

    }*/

    /*time complexity of storing pieces and updating there location
    when piece moves update global location
    create an array for each player location in array stores piece and piece location
     */


    public int nextMove(Board g){
        for(int var1=0; var1<0; var++){
            g.setStatus(var1);


        }
    }
    public void printBoard(){
        for(int a=7; a>=0; a--){

            System.out.println("");

            for(int b=7; b>=0; b--){
                System.out.print("| "+ gameBoard[a][b].getStatus()+" ");
            }
            System.out.print("|");
        }
        System.out.println();
    }



    public static void main(String[] args){
        Game g=new Game();
        g.createBoard();
        g.assignLoc();
        g.printBoard();
        int userRow, userCol;
        char userColor='W';
        Scanner s=new Scanner(System.in);
        userRow= s.nextInt();
        userCol=s.nextInt();

        while (!g.checkMate(userRow,userCol)){
            if(g.getColor(userRow,userCol)==userColor){

        }


        }

    }

}
