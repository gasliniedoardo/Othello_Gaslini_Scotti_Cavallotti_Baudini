package clientsocket;

import Controller.ControlOthello;
import Controller.EseguiMosse;
import View.view;
import graficaothello.GraficaOthello;
import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.white;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import othello.addframe;
import serversocket.connect;


public class socket extends Thread{
    boolean a = false;
    String ip; int port;
    addframe frame;
    public static  int row;
    public static int col;
    Socket socket = null;
    
    public socket(int row, int col) {
        connect.row = row;
        connect.col = col;
    }

    public socket(String ip, int port,addframe frame) throws IOException {
        this.frame=frame;
        this.ip = ip;
        this.port = port;
        this.start();
    }
    EseguiMosse b = new EseguiMosse();
    view v;
    GraficaOthello G;
    ControlOthello Ctrl;

    public socket(boolean a) {
        this.a = a;
    }
    @Override
	public void run() {
		BufferedReader in = null;
		PrintStream out = null;
		String message = null;
                Color turno = null;
		try{
                    socket = new Socket(ip,port);  // open a socket connection
                    System.out.println("ip e porta creati");
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));    // Apre i canali I/O
                    out = new PrintStream(socket.getOutputStream(), true);
                    out.println("connection;");
                    while(message==null) {                        
                        message = in.readLine();
                        if(message.toLowerCase().contains("bianco".toLowerCase())){
                            turno=white;
                        }else{
                            turno=black;
                        }
                    }
                    /*do{
                        String incorso = null;
                        while(!("round: <"+turno+">;").equals(incorso)){
                            incorso=in.readLine();
                        }
                        out.println("round: <"+turno+">;");*/
                        b.Mosse(turno);
                        b.MostraMosse();
                        v = new view(b.CampoDiGioco, b.Mosse);
                        G = new GraficaOthello(b,turno);
                        Ctrl=new ControlOthello(b,v,G,turno);
                        v.Stampa();
                        System.out.println("Messaggio Ricevuto : " + message);
                        if(message != null){
                            while(G.mossaEx!=true) {
                                System.out.print("");
                            }
                            out.println("place: " + "<" + G.riga + ">, " + "<"+ G.colonna + ">;");
                        }
                        b.eseguimossa(G.riga, G.colonna, turno);
                        b.azzera();
                        b.Mosse(turno);
                        v.Update(b.CampoDiGioco, b.Mosse);
                        G.Update(b, turno);
                        v = new view(b.CampoDiGioco, b.Mosse);
                        G = new GraficaOthello(b,turno);
                        v.Stampa();
                        //
                        //
                        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        frame.jLabel3.setText(Ctrl.Conteggio(white));
                        frame.jLabel4.setText(Ctrl.Conteggio(black));
                        frame.invalidate();
                        frame.validate();
                        frame.repaint();
                        out.println("end: ");
                    //}while(Ctrl.FineGioco()==true);
                    out.println("endgame");
                    //in.close();
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}     
    }
}
