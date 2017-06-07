package Controller;

import View.view;
import graficaothello.GraficaOthello;
import java.awt.Color;
import static java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlOthello{
    int TOTW;
    int TOTB;
    EseguiMosse b;
    view v;
    Color turno;
    GraficaOthello G;
    public ControlOthello(EseguiMosse b,view v,GraficaOthello G,Color t){
        turno=t;
        this.b=b;
        this.v=v;
        this.G=G;

    }
    public boolean FineGioco(){
        for(int r=0;r<b.CampoDiGioco.length;r++){
            for(int c=0;c<b.CampoDiGioco.length;c++){
                if(b.Mosse[r][c]==true){
                    return true;
                }
            }
        }
        return false;
    }
        
    public String Conteggio(Color turno){
        TOTW=0;
        TOTB=0;
        for(int r=0;r<b.CampoDiGioco.length;r++){
            for(int c=0;c<b.CampoDiGioco.length;c++){
                if(b.CampoDiGioco[r][c].colore==black){
                   TOTB++;
                }else if(b.CampoDiGioco[r][c].colore==white){
                    TOTW++;
                }
            }
        }
        if(turno==black){
            return ""+TOTB;
        }else{
            return ""+TOTW;
        }
    }
    public void Fine(){
        System.out.println("FINE GIOCO");
        System.out.println("NERI: "+TOTB+" BIANCHI: "+TOTW);
        if(TOTB<TOTW){
            System.out.println("HANNO VINTO I BIANCHI");
        }else if(TOTB>TOTW){
            System.out.println("HANNO VINTO I NERI");
        }else{System.out.println("PAREGGIO");}
    }

}