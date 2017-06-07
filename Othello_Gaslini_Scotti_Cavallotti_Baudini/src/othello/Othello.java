
package othello;

import Controller.ControlOthello;
import Controller.EseguiMosse;
import View.view;
import graficaothello.GraficaOthello;
import java.awt.Color;
import static java.awt.Color.black;
import java.io.IOException;

public class Othello /*extends Thread*/{
    /*public Othello(Color turno){
        this.turno=turno;
    }
    @Override*/
    public static void main(String arg[]) throws IOException{

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new addframe().setVisible(true);
                
            }
        });
        /*GraficaOthello G;  
        EseguiMosse b = new EseguiMosse();
        b.Mosse(turno);
        b.MostraMosse();
        view v = new view(b.CampoDiGioco, b.Mosse);
        G=new GraficaOthello(b,turno);
        ControlOthello Ctrl=new ControlOthello(b,v,G,turno);*/

    }
}