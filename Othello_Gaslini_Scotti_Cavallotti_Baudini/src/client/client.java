package client;

import Controller.EseguiMosse;
import java.awt.Color;

public class client extends Thread{

    turni T;
    Color giocatore;
    EseguiMosse b;
    public client(EseguiMosse b,Color giocatore,turni T){
        this.T=T;
        this.giocatore=giocatore;
        this.b=b;
    }
    @Override
    public void run(){ 
        T.esegui(b,giocatore);
    }
}
