public class Ai {
    private Piece aiPiece;
    private Piece playerPiece;
    public Board gBoard




    //current piece is the piece from the array pieces
    //split disc into 3 sub groups
    ///early game, mid game end game

    //early game moves are used to capture pieces without putting your own pieces in a danger position
    //mid game involves moving pieces to make postion from a end game table base
    //end game parsing through large table bases and replicating those moves



    public Ai(Piece aiPiece, Piece playerPiece) {
        aiPiece = aiPiece;
        playerPiece = playerPiece;

    }


    public void updatePos(Piece x, char play){
        if(play=='W'){
            playerPiece=x;
        }
        else{
            aiPiece==;
        }




    }

    int nextMove(){

    }

}
