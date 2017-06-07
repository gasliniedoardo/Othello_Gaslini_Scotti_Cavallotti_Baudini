package graficaothello;

import Controller.EseguiMosse;
import Controller.Casella;
import static graficaothello.GraficaOthello.frame;
import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.white;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class GraficaOthello extends JPanel {
   static JFrame frame = new JFrame("Othello");
   private static final int PREF_W = 800; //grandezza finestra
   private static final int PREF_H = 800; //grandezza finestra
   private static final int GRID_ROWS = 8;
   private static final int GRID_COLS = 8;
   //JLabel img = new JLabel(new ImageIcon("me.jpeg"));
   ImageIcon img = new ImageIcon("n.jpg");
   public static int p1 = 500 , p2 = 100;
   private JPanel gridPanel;
   
    public Casella [][]CampoDiGioco;
    public boolean [][]Mosse;
    public ColorGridCell C[][]=new ColorGridCell[8][8];
    Color turno;
    public boolean mossaEx=false;
    public int riga;
    public int colonna;
    
    public GraficaOthello(EseguiMosse Ex,Color giocatore) throws IOException {
        turno=giocatore;
        CampoDiGioco = Ex.CampoDiGioco;
        Mosse=Ex.Mosse;
        gridPanel = new JPanel(new GridLayout(GRID_ROWS, GRID_COLS));
        gridPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        for (int row = 0; row < GRID_ROWS; row++) {
           for (int col = 0; col < GRID_COLS; col++) {
                   //setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
                   //setBorder(BorderFactory.createLineBorder(Color.BLACK));
                   gridPanel.setBorder((Border) new CompoundBorder(new LineBorder(Color.black, 2), new EmptyBorder(2, 2, 2, 2)));
                   C[row][col]=new ColorGridCell(this,row, col,Ex,turno);
                   gridPanel.add(C[row][col]);
                   //////////////////////////////////////////////////////////////////////////////////
            }
        }
        createAndShowGui(this);
        setLayout(new GridBagLayout()); // per centrare
        add(gridPanel);
            /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addframe().setVisible(true);
                
            }
        });*/
    }
     

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public static void createAndShowGui(GraficaOthello mainPanel) {
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
      frame.setLocation(p1, p2);
   }
   
   
   public void Update (EseguiMosse Ex,Color turno) throws IOException {
        CampoDiGioco = Ex.CampoDiGioco;
        Mosse= Ex.Mosse;
        gridPanel.removeAll();
        gridPanel = new JPanel(new GridLayout(GRID_ROWS, GRID_COLS));
        gridPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        for (int row = 0; row < GRID_ROWS; row++) {
           for (int col = 0; col < GRID_COLS; col++) {
                   gridPanel.setBorder((Border) new CompoundBorder(new LineBorder(Color.black, 2), new EmptyBorder(2, 2, 2, 2)));
                   C[row][col]=new ColorGridCell(this,row, col,Ex,turno);
                   gridPanel.add(C[row][col]);
            }
        }
        frame.getContentPane().add(this);
        setLayout(new GridBagLayout()); // per centrare
        add(gridPanel);
    }
}

@SuppressWarnings("serial")
class ColorGridCell extends JPanel {
    private static final int PREF_W = 100;
    private static final int PREF_H = 100;
    private final static Color[] COLORS = {Color.green, Color.white, Color.black};
    protected Casella [][]CampoDiGioco;
    protected boolean [][]Mosse;
    Color giocatore;
    BufferedImage PictureBlack = ImageIO.read(new File("/immagini/black.png"));
    BufferedImage PictureWhite = ImageIO.read(new File("/immagini/white.png"));
    //BufferedImage PictureMossa = ImageIO.read(new File("mossa.png"));
    Image pblack = PictureBlack.getScaledInstance(86, 86,  java.awt.Image.SCALE_SMOOTH);
    Image pwhite = PictureWhite.getScaledInstance(86, 86,  java.awt.Image.SCALE_SMOOTH);
    JLabel piclabel;
    GraficaOthello mainPanel;
    private final int row;
    private final int col;

   public ColorGridCell(GraficaOthello mainPanel,int row, int col,EseguiMosse Ex,Color turno) throws IOException {
       this.mainPanel=mainPanel;
        giocatore=turno;
        CampoDiGioco = Ex.CampoDiGioco;
        Mosse= Ex.Mosse;
        this.row = row;
        this.col = col;
        setBackground(Color.green);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        if(Ex.Mosse[row][col]==true){
            setBackground(Color.red);
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }else if(CampoDiGioco[row][col].colore==black){
                    piclabel=new JLabel(new ImageIcon(pblack));
                    add(piclabel);
                }else if(CampoDiGioco[row][col].colore==white){
                        piclabel=new JLabel(new ImageIcon(pwhite));
                        add(piclabel);
                }

        
        addMouseListener(new MouseAdapter() {
        @Override
         public void mousePressed(MouseEvent e) {
            
            if(Mosse[row][col]==true){
                Mosse[row][col]=false;
                Ex.eseguimossa(row, col, giocatore);
                if(giocatore==black){   
                    setBackground(Color.green);
                    piclabel=new JLabel(new ImageIcon(pblack));
                    add(piclabel);
                }else{  
                    setBackground(Color.green);
                    piclabel=new JLabel(new ImageIcon(pwhite));
                    add(piclabel);
                }
                mainPanel.mossaEx=true;
                mainPanel.riga=row;
                mainPanel.colonna=col;
                boolean a = true;
                clientsocket.socket up = new clientsocket.socket(a);
                //clientsocket.socket upgrade = new clientsocket.socket(row,col);
            }
            frame.invalidate();
            frame.validate();
            frame.repaint();
         }
      });
   }
   
   
   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }
   
   public int getRow() {
      return row;
   }

   public int getCol() {
      return col;
   }
}