
package Controller;

import java.awt.Color;

public class Box {
    public Casella [][]CampoDiGioco;
    public boolean [][]Mosse;
    
    //Costruttore
    public Box(){
        CampoDiGioco = new Casella[8][8]; // dove vengono salvate le posizioni delle pedine
        Mosse = new boolean[8][8]; // in base alle pedine presenti nel campo di gioco, vengono salvate le possibili mosse
        for(int r=0;r<CampoDiGioco.length;r++){
            for(int c=0;c<CampoDiGioco.length;c++){
                CampoDiGioco[r][c]=new Casella(true);   
            }
        }
        // Vengono impostate le 4 pedine iniziali
        CampoDiGioco[3][3] = new Casella(false, Color.white);
        CampoDiGioco[4][3] = new Casella(false, Color.black);
        CampoDiGioco[3][4] = new Casella(false, Color.black);
        CampoDiGioco[4][4] = new Casella(false, Color.white);
        System.out.println("Pedine bianche: "+"("+4+";"+4+")"+"("+5+";"+5+")");
        System.out.println("Pedine nere: "+"("+5+";"+4+")"+"("+4+";"+5+")");
    }
    public boolean finegioco(){
        for(int r=0;r<CampoDiGioco.length;r++){
            for(int c=0;c<CampoDiGioco.length;c++){
                if(Mosse[r][c]==true){
                    return true;
                }
            }
        }
        return false;
    }
    public void mostrapedine(Color giocatore){
        System.out.println("Le tue pedine sono: ");
        for(int r=0;r<CampoDiGioco.length;r++){
            for(int c=0;c<CampoDiGioco.length;c++){
                if(CampoDiGioco[r][c].colore==giocatore){
                    System.out.println("("+(1+r)+";"+(1+c)+")");
                }
            }
        }
    }
    // le mosse ricominciano da zero e verrannno reimpostate da PossibiliMosse
    public void azzera(){
        for(int r=0;r<CampoDiGioco.length;r++){
            for(int c=0;c<CampoDiGioco.length;c++){
                Mosse[r][c]=false;
            }
        }
    }
}
