package serversocket;

import Controller.ControlOthello;
import Controller.EseguiMosse;
import View.view;
import graficaothello.GraficaOthello;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connect extends Thread{  

    public static int row;
    public static int col;
    
    EseguiMosse b = new EseguiMosse();
    view v;
    GraficaOthello G;
    ControlOthello Ctrl;
    private Socket client = null;
    BufferedReader in1 = null;
    PrintStream out1 = null;
    BufferedReader in2 = null;
    PrintStream out2 = null;
    BufferedReader in3 = null;
    PrintStream out3 = null;
    String colore;
    public connect(Socket clientSocket){
            client = clientSocket;
    }
    @Override
    public void run(){
        String a;
        if (socket.a.equalsIgnoreCase("nero")) {    //entra nel nero
            try{
                in1 = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out1 = new PrintStream(client.getOutputStream(), true);
                if (in1.readLine().equalsIgnoreCase("connection;")) {
                    System.out.println("E' stato letto connection;");
                    out1.println("start: " + "default " + socket.a);
                    Thread.sleep(2000);
                    Gioco();
                }
            }catch(Exception e1){
                System.out.println(e1.getMessage());
            }
        }else {
            if(socket.a.equalsIgnoreCase("bianco")){  //entra nel bianco
                try{
                    in2 = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    out2 = new PrintStream(client.getOutputStream(), true);
                    if (in2.readLine().equalsIgnoreCase("connection;")) {
                        System.out.println("è stato letto connection;");
                        out2.println("start: " + "default " + socket.a);
                        Gioco();
                    }
                }catch(Exception e1){
                    System.out.println(e1.getMessage());
                }
            }
        }
    }
    public void Gioco() throws IOException{
        try {
            in3 = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out3 = new PrintStream(client.getOutputStream(), true);
            String msg=null;
            out3.println("round: <black>;");
                while(!("end: ").equals(in3.readLine())){
                    out3.println("round: <black>;");
                    if(msg.toLowerCase().contains("place: ".toLowerCase())){
                        System.out.println("Ho letto place");
                        System.out.println(msg.charAt(8));
                        System.out.println(msg.charAt(13));
                    }
                }
                out3.println("round: <white>;");
                while(!("end: ").equals(in3.readLine())){
                        if(msg.toLowerCase().contains("place: ".toLowerCase())){
                            System.out.println("Ho letto place");
                            System.out.println(msg.charAt(8));
                            System.out.println(msg.charAt(13));
                        }
                }
        } catch (IOException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}