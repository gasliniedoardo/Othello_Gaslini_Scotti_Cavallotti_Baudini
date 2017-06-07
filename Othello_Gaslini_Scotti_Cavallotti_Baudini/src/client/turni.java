
package client;

import Controller.ControlOthello;
import Controller.EseguiMosse;
import View.view;
import graficaothello.GraficaOthello;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class turni {
    public synchronized void esegui(EseguiMosse b,Color giocatore){
        try {
            b.Mosse(giocatore);
            b.MostraMosse();
            view v = new view(b.CampoDiGioco, b.Mosse);
            GraficaOthello G=new GraficaOthello(b,giocatore);
            ControlOthello Ctrl=new ControlOthello(b,v,G,giocatore);
            //while(Ctrl.mossaEx==false){
                //System.out.println("ciao");
            //}
            notify();
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
