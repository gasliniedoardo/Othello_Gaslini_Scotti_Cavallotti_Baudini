package View;

import Controller.Casella;
import static java.awt.Color.white;

public class view {
    
    protected Casella [][]CampoDiGioco;
    protected boolean [][]Mosse;
    
    public view(Casella[][] CampoDiGioco, boolean[][] Mosse) {
        this.CampoDiGioco = CampoDiGioco;
        this.Mosse=Mosse;
    }
    //Metodo per stampare la vista testuale del campo di gioco
    public void Stampa (){
        System.out.print(" |   | ");
        for(int c=0;c<CampoDiGioco.length;c++){
            System.out.print(" | "+(1+c)+" | ");
        }
        System.out.println("");
        for(int c=0;c<10;c++){
            System.out.print("------");
        }
        System.out.println("--");
        for(int r=0;r<CampoDiGioco.length;r++){
            System.out.print(" | "+(1+r)+" | ");
            for(int c=0;c<CampoDiGioco.length;c++){
                if(CampoDiGioco[r][c].libera==false){
                        if(CampoDiGioco[r][c].colore== white){
                            System.out.print(" | W | ");     
                        }else{System.out.print(" | B | ");}                 
                }else if(Mosse[r][c]==true){
                        System.out.print(" | x | ");
                    }else{System.out.print(" |   | ");}     
            }
            System.out.println("");
            for(int c=0;c<10;c++){
                System.out.print("------");
            }
            System.out.println("--");
        }
    }
    // metodo per aggiornare il campo di gioco e le possibili mosse
    public void Update (Casella[][] CampoDiGioco, boolean[][] Mosse) {
        this.CampoDiGioco = CampoDiGioco;
        this.Mosse=Mosse;
    }
    
}
