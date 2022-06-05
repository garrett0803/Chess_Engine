import java.lang.Math;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Game {

    public Board[][] gameBoard;
    public Board[] wpieces = new Board[16];
    public Piece[] player = new Piece[16];
    public Piece[] ai = new Piece[16];
    public Board[] bpieces = new Board[16];

    /*linked list to store each players pieces
      data will hold abstract to piece class holding location and piece value IE (king, queen, ect)


     */

    //public Node head=null;
    // public tail=null;
    //public next=null;

    /*
    Maybe best to include binary tree of possible moves
    take to many resources to generate entire list maybe generate list on each opposing players moves
    that would avoid the need for pruning the initial tree
     */


    public void createBoard() {
        gameBoard = new Board[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Board b = new Board(i, j, "-", '-');
                gameBoard[i][j] = b;

            }
        }
    }





    public void assignLoc() {
        int z = 0;
        int y = 2;
        int tp=0;
        for (int i = 1; i < 7; i++) {

            if (i == 1) {


                    //wpieces[0].setLoc(0, 4);
                    //bpieces[0].setLoc(7, 4);
                    gameBoard[0][4].setStatus("Q");
                    gameBoard[0][4].setColor('W');
                    gameBoard[7][4].setStatus("Q");
                    gameBoard[7][4].setColor('B');
                }
            else if(i==2) {
                    //wpieces[1].setLoc(0, 3);
                    //bpieces[1].setLoc(7, 3);
                    gameBoard[0][3].setStatus("K");
                    gameBoard[0][3].setColor('W');
                    gameBoard[7][3].setStatus("K");
                    gameBoard[7][3].setColor('B');
            }
             else if (i == 6) {
                for (int j = 0; j < 8; j++) {
                    gameBoard[1][j].setStatus("P");
                    gameBoard[1][j].setColor('W');
                    gameBoard[6][j].setStatus("P");
                    gameBoard[6][j].setColor('B');
                }
            } else {

                String[] otherObj={"B", "N","R"};



                gameBoard[0][y].setStatus(otherObj[tp]);
                gameBoard[0][y].setColor('W');
                gameBoard[7][y].setStatus(otherObj[tp]);
                gameBoard[7][y].setColor('B');
                gameBoard[0][y + i + z].setStatus(otherObj[tp]);
                gameBoard[0][y + i + z].setColor('W');
                gameBoard[7][y + i + z].setStatus(otherObj[tp]);
                gameBoard[7][y + i + z].setColor('B');
                z++;
                y--;
                tp++;

            }


        }
    }

    public Board[][] getBoard() {
        return gameBoard;
    }
    /*public int[] allMoves(Board[][] gameBoard){

    }*/


    public boolean isValid(int row, int col, Board curPiece) {
        int rowDif = 0;
        int colDif = 0;

        if ((row < 8 && row >= 0) && (col < 8) && (col < 8 && col >= 0)) {
            rowDif = row - curPiece.getRow();
            colDif = col - curPiece.getCol();
            switch (curPiece.getStatus()) {
                case "K":
                    if (Math.abs(rowDif) < 2 && Math.abs(colDif) < 2) {
                        return true;
                    } else {
                        return false;
                    }

                case "Q":
                    if (rowDif == 0 || colDif == 0 || (row != curPiece.getRow() && Math.abs(rowDif) == Math.abs(colDif))) {
                        return true;
                    } else {
                        return false;
                    }

                case "R":
                    if (row != curPiece.getRow() && Math.abs(rowDif) == Math.abs(colDif)) {
                        return true;
                    } else {
                        return false;
                    }

                case "N":
                    if (row != curPiece.getRow()) {
                        if (Math.abs(rowDif) == 2 && Math.abs(colDif) == 1) {
                            return true;
                        } else if (Math.abs(rowDif) == 1 && Math.abs(colDif) == 2) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }

                case "B":
                    if (row == curPiece.getRow() || col == curPiece.getCol()) {
                        return true;
                    } else {
                        return false;
                    }

                case "P":
                    if (rowDif == 1 && colDif == 0) {
                        return true;
                    } else {
                        return false;
                    }
            }
        } else {
            return false;
        }
        return false;

    }


    public char getColor(int row, int col) {
        return gameBoard[row][col].getColor();
    }

    public boolean checkMate(int row, int col) {
        if (isValid(row, col, gameBoard[row][col]) & (gameBoard[row][col].getStatus() == "K")) {
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


    /*public int nextMove(Board g) {
        for (int var1 = 0; var1 < 0; var1++) {
            g.setStatus(var1);


        }
    }*/

    public void printBoard() {
        for (int a = 7; a >= 0; a--) {

            System.out.println("");

            for (int b = 7; b >= 0; b--) {
                System.out.print("| " + gameBoard[a][b].getStatus() + " ");
            }
            System.out.print("|");
        }
        System.out.println();
    }

    public void popTree(Board gameBoard) {


    }
    // we dont want to parse through entire tree again
    //public Node prunTree(Board gameBoard){

    //for(int i=0; i);

    //}

    public void AssignTeam() {
        int C1 = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; i < 8; i++)
                if (gameBoard[i][j].getColor() == 'W') {
                    player[C1] = new Piece(i, j, 'W', 0);
                    C1++;
                } else if (gameBoard[i][j].equals('B')) {
                    ai[C1] = new Piece(i, j, 'B', 0);
                    C1++;
                }

        }
    }



    //lets comp know which human pieces are able to capture on the next move
    //returns which pieces could be affected as arr?
    public Piece asDanger() {
        int ini = 0;
        Piece dangerPiece[] = new Piece[16];
        for (int i = 0; i < 16; i++) {

            int pTypeCheck = player[i].getType();

            if (pTypeCheck == 1) {


                //check all spaces where king can attack
                for (int x = 0; x < 3; x++) {
                    int checkRow = player[x].getRow() - 1;
                    for (int y = 0; y < 3; y++) {
                        int checkCol = player[y].getCol() - 1;
                        if ((gameBoard[checkRow][checkCol]).getColor() == 'B') {
                            dangerPiece[ini] = new Piece(x, y, 'W', player[i].getType());
                            ini++;
                        }
                    }

                }
            } else if (pTypeCheck == 2) {

                for (int y = player[i].getRow() + 1; y < 8; y++) {
                    if (gameBoard[player[i].getRow()][y].getColor() == 'B') {
                        dangerPiece[ini] = new Piece(y, player[i].getCol(), 'W', player[i].getType());
                        ini++;
                        break;
                    } else if (gameBoard[player[i].getRow()][y].getColor() == 'W') {
                        break;
                    }
                }
                for (int y = player[i].getRow() - 1; y <= 0; y--) {
                    if (gameBoard[player[i].getRow()][y].getColor() == 'B') {
                        dangerPiece[ini] = new Piece(y, player[i].getCol(), 'W', player[i].getType());
                        ini++;
                        break;
                    } else if (gameBoard[player[i].getRow()][y].getColor() == 'W') {
                        break;
                    }
                }

                for (int y = player[i].getCol() + 1; y < 8; y++) {
                    if (gameBoard[player[i].getRow()][y].getColor() == 'B') {
                        dangerPiece[ini] = new Piece(player[i].getRow(), y, 'W', player[i].getType());
                        ini++;
                        break;
                    } else if (gameBoard[player[i].getRow()][y].getColor() == 'W') {
                        break;
                    }
                }
                for (int y = player[i].getCol() - 1; y >= 0; y--) {
                    if (gameBoard[player[i].getRow()][y].getColor() == 'B') {
                        dangerPiece[ini] = new Piece(player[i].getRow(), y, 'W', player[i].getType());
                        ini++;
                        break;
                    } else if (gameBoard[player[i].getRow()][y].getColor() == 'W') {
                        break;
                    }


                }

                for (int y = 1; y < 8; y++) {
                    //case for diag when moving up in towards the right corner of the board
                    if (player[i].getRow() + y > 7 || player[i].getCol() > 7) {
                        break;
                    } else if (gameBoard[player[i].getRow() + y][player[i].getCol() + y].getColor() == 'B') {
                        dangerPiece[ini] = new Piece(player[i].getRow() + y, player[i].getCol() + y, 'W', player[i].getType());
                        ini++;
                        break;
                    }
                }
                for (int y = 1; y < 8; y++) {
                    if (player[i].getRow() + y > 7 || player[i].getCol() - y > 0) {
                        break;
                    } else if (gameBoard[player[i].getRow() + y][player[i].getCol() - y].getColor() == 'B') {
                        dangerPiece[ini] = new Piece(player[i].getRow() + y, player[i].getCol() - y, 'W', player[i].getType());
                        ini++;
                        break;
                    } else if (gameBoard[player[i].getRow() + y][player[i].getCol() - y].getColor() == 'W') {
                        break;
                    }

                }
                for (int y = 1; y < 8; y++) {
                    if (player[i].getRow() - y > 7 || player[i].getCol() + y > 0) {
                        break;
                    } else if (gameBoard[player[i].getRow() - y][player[i].getCol() + y].getColor() == 'B') {
                        dangerPiece[ini] = new Piece(player[i].getRow() - y, player[i].getCol() + y, 'W', player[i].getType());
                        ini++;
                        break;

                    } else if (gameBoard[player[i].getRow() - y][player[i].getCol() + y].getColor() == 'W') {
                        break;
                    }
                }

                for (int y = 1; y < 8; y++) {
                    if (player[i].getRow() - y > 7 || player[i].getCol() - y > 0) {
                        break;
                    } else if (gameBoard[player[i].getRow() - y][player[i].getCol() - y].getColor() == 'B') {
                        dangerPiece[ini] = new Piece(player[i].getRow() - y, player[i].getCol() + y, 'W', player[i].getType());
                        ini++;
                        break;


                    } else if (gameBoard[player[i].getRow() - y][player[i].getCol() - y].getColor() == 'W') {
                        break;
                    }
                }
            } else if (pTypeCheck == 3) {
                //case for rook
                for (int y = player[i].getRow() + 1; y < 8; y++) {
                    if (gameBoard[player[i].getRow()][y].getColor() == 'B') {
                        dangerPiece[ini] = new Piece(y, player[i].getCol(), 'W', player[i].getType());
                        ini++;
                        break;
                    } else if (gameBoard[player[i].getRow()][y].getColor() == 'W') {
                        break;
                    }
                }
                for (int y = player[i].getRow() - 1; y <= 0; y--) {
                    if (gameBoard[player[i].getRow()][y].getColor() == 'B') {
                        dangerPiece[ini] = new Piece(y, player[i].getCol(), 'W', player[i].getType());
                        ini++;
                        break;
                    } else if (gameBoard[player[i].getRow()][y].getColor() == 'W') {
                        break;
                    }
                }

                for (int y = player[i].getCol() + 1; y < 8; y++) {
                    if (gameBoard[player[i].getRow()][y].getColor() == 'B') {
                        dangerPiece[ini] = new Piece(player[i].getRow(), y, 'W', player[i].getType());
                        ini++;
                        break;
                    } else if (gameBoard[player[i].getRow()][y].getColor() == 'W') {
                        break;
                    }
                }
                for (int y = player[i].getCol() - 1; y >= 0; y--) {
                    if (gameBoard[player[i].getRow()][y].getColor() == 'B') {
                        dangerPiece[ini] = new Piece(player[i].getRow(), y, 'W', player[i].getType());
                        ini++;
                        break;
                    } else if (gameBoard[player[i].getRow()][y].getColor() == 'W') {
                        break;
                    }


                }

            } else if (pTypeCheck == 4)
            //case for knight
            {
                if (gameBoard[player[i].getRow() + 2][player[i].getCol() + 1].getColor() == 'B') {
                    dangerPiece[ini] = new Piece(player[i].getRow() + 2, player[i].getCol() + 1, 'W', player[i].getType());
                    ini++;
                } else if (gameBoard[player[i].getRow() + 2][player[i].getCol() - 1].getColor() == 'B') {
                    dangerPiece[ini] = new Piece(player[i].getRow() + 2, player[i].getCol() - 1, 'W', player[i].getType());
                    ini++;
                } else if (gameBoard[player[i].getRow() + 1][player[i].getCol() + 2].getColor() == 'B') {
                    dangerPiece[ini] = new Piece(player[i].getRow() + 1, player[i].getCol() + 2, 'W', player[i].getType());
                    ini++;
                }

            }


        }
        return null;

    }

    public int[] getMove(char Color){
        Scanner loopScanner= new Scanner(System.in);
        int[] moveSelect;


        moveSelect= new int[2];
        if(Color == 'B'){
            moveSelect[0]=1;


        }
        else{

            moveSelect[0]=loopScanner.nextInt();
            System.out.println("enter row ");
            moveSelect[1]=loopScanner.nextInt();
            System.out.println("enter col");



        }
        return moveSelect;


    }




    /*public static void main(String[] args){
        Game g=new Game();
        int pieceChoice;
        Scanner myscanner=new Scanner(System.in);
        g.createBoard();
        g.assignLoc();
        g.printBoard();
        int userRow, userCol;
        char userColor='W';
        Scanner s=new Scanner(System.in);
        userRow= s.nextInt();
        userCol=s.nextInt();
        int turnCount=0;

        while (!g.checkMate(userRow,userCol)){
            g.printBoard();
            System.out.println("what piece are you moving");
            pieceChoice=s.nextInt();
            userRow= getMove("w")[0];
            userCol= getMove('W')[1];
            if(g.isValid(userRow,userCol)){

            }




        }

        System.out.println("The game is over.");




    }*/

    //wait till player first move then populate binary tree

}
