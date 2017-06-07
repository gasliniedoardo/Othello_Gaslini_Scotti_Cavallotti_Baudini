package serversocket;

import java.net.ServerSocket;
import java.net.Socket;

import server.finestra;

public class socket extends Thread{

	private static ServerSocket Server;
        public static String a;
        public static String a1;
        
	public socket() throws Exception{
		Server = new ServerSocket(2000);
		System.out.println("Il Server è in attesa sulla porta 2000.");
                finestra.jTextArea1.setText(finestra.jTextArea1.getText() + "Il Server è in attesa sulla porta 2000.\n");
                this.start();
	}
	public void run(){
            try {
                System.out.println("In attesa di Connessione.");
                finestra.jTextArea1.setText(finestra.jTextArea1.getText() + "In attesa di Connessione.\n");
                Socket client = Server.accept();
                finestra.jTextArea1.setText(finestra.jTextArea1.getText() + "1 Connessione accettata da: " + client.getInetAddress() + "\n");
                System.out.println("Connessione accettata da: "+ client.getInetAddress());
                finestra.jTextArea1.setText(finestra.jTextArea1.getText() + "In attesa del secondo player " +  "\n");
                Socket client1 = Server.accept();
                finestra.jTextArea1.setText(finestra.jTextArea1.getText() + "2 Connessione accettata da: "+ client.getInetAddress() + "\n");
                Thread.sleep(200);
                connect c = new connect(client);
                c.setName("nero");
                a = c.getName();
                c.start();
                Thread.sleep(200);
                connect c1 = new connect(client1);
                c1.setName("bianco");
                a = c1.getName();
                c1.start();
            }catch(Exception e) {

            }
	}
}