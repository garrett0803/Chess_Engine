import javax.accessibility.Accessible;
import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;

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

                message=board[i][j].getStatus();


                gboard[i][j]=new Button(""+ message);
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
    public void actionPerformed(ActionEvent ae){
        String str = ae.getActionCommand();
        if(str.equals(str)){
            message="test was selected";
            System.out.println("test was successful");


        }
        else{
            message="no action";
            System.out.println("no action");
        }
        repaint();

    }

    public void paint(Graphics g){
        g.drawString(message, 150,500);
    }

    public static void main(String[] args){
        Grid appwin=new Grid();
        appwin.setSize(new Dimension(1000,400));
        appwin.setTitle("CHESSV0");
        appwin.setVisible(true);
    }
}


