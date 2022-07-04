import javax.accessibility.Accessible;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import java.util.EventListener;
import java.awt.Color;

public class Grid extends Frame implements ActionListener {
    String message="";
    public Game gcheck;
    public Board[][] board;
    public Button[][] gboard;
    static final int n=8;

    public Grid(){
        gcheck=new Game();
        gboard=new Button[8][8];

        gcheck.createBoard();
        gcheck.assignLoc();
        board= gcheck.getBoard();

        //add(temp);

        //temp.addActionListener(this);

        setLayout(new GridLayout(n,n));
        setFont(new Font("SansSerif",Font.BOLD,24));
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                String msg="";

                msg=board[i][j].getStatus();


                gboard[i][j]=new Button(""+ msg);
                add(gboard[i][j]);
                gboard[i][j].addActionListener(this);




            }
        }

        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int rowCheck,colCheck;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ae.getSource() == gboard[i][j]) {

                    message = "you pressed " + gboard[i][j].getLabel();
                    System.out.println(message);
                    List<Integer>list=new ArrayList<Integer>();
                    list=gcheck.allMoves(i,j, board);
                    int size=list.size();
                    for(int a=0;a<size;a++){
                        rowCheck=list.get(a);
                        a++;
                        colCheck=list.get(a);
                        gboard[rowCheck][colCheck].setBackground(Color.green);

                    }

                    gboard[i][j].setBackground(Color.red);
                }
            }



        }

        repaint();
    }

    public void paint(Graphics g){
        g.drawString(message, 150,500);
    }

    public static void main(String[] args){
        Grid appwin=new Grid();
        appwin.setSize(new Dimension(1000,400));
        appwin.setTitle("DEBUG");
        appwin.setVisible(true);
    }
}


