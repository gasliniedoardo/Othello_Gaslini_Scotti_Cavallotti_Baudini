package Controller;

import java.awt.Color;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EseguiMosse extends PossibiliMosse{
    
    // viene presa la mossa e inserita nel campo di gioco
    public void eseguimossa(int r, int c,Color giocatore) {   
        CampoDiGioco[r][c]=new Casella(false, giocatore);
        cambiopedine(r,c,giocatore);
    }
    
    // cambiopedine, in base alla pedina inserita, modifica il campo di gioco
    private void cambiopedine(int r, int c, Color giocatore){
        CambioOrizzdx(r,c,giocatore);
        CambioOrizzsx(r,c,giocatore);
        CambioVertUp(r,c,giocatore);
        CambioVertDown(r,c,giocatore);
        CambioObldx1(r,c,giocatore);
        CambioObldx2(r,c,giocatore); 
        CambioOblsx2(r,c,giocatore);
        CambioOblsx1(r,c,giocatore);    
    }
    
    private void CambioOrizzdx(int r, int c, Color giocatore) {
        try{
            int arrivo=0;
            if(CampoDiGioco[r][1+c].libera==false && CampoDiGioco[r][1+c].colore!=(giocatore)){
                for(int C=c;C<8;C++){
                    if(CampoDiGioco[r][1+C].colore==(giocatore)){
                        arrivo=C;
                        break;
                    }
                }
            }
            if(arrivo!=0){
                for(int C=c;C<=arrivo;C++){
                    CampoDiGioco[r][C]=new Casella(false, giocatore);
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){
        }
    }
    
    private void CambioOrizzsx(int r, int c, Color giocatore) {
        try{
            int arrivo=0;
            if(CampoDiGioco[r][-1+c].libera==false && CampoDiGioco[r][-1+c].colore!=(giocatore)){
                for(int C=c;C>-1;C--){
                    if(CampoDiGioco[r][-1+C].colore==(giocatore)){
                        arrivo=C;
                        break;
                    }
                }
            }
            if(arrivo!=0){
                for(int C=c;C>=arrivo;C--){
                    CampoDiGioco[r][C]=new Casella(false, giocatore);
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){
        }
    }
    
    private void CambioVertUp(int r, int c,Color giocatore) {
        try{
            int arrivo=0;
            if(CampoDiGioco[-1+r][c].libera==false && CampoDiGioco[-1+r][c].colore!=(giocatore)){
                for(int R=r;R>-1;R--){
                    if(CampoDiGioco[-1+R][c].colore==(giocatore)){
                        arrivo=R;
                        break;
                    }
                }
            }
            if(arrivo!=0){
                for(int R=r;R>=arrivo;R--){
                    CampoDiGioco[R][c]=new Casella(false, giocatore);
                }  
            }
        }catch(ArrayIndexOutOfBoundsException e){         
        }
    }
    
    private void CambioVertDown(int r, int c, Color giocatore) {
        try{
            int arrivo=0;
            if(CampoDiGioco[1+r][c].libera==false && CampoDiGioco[1+r][c].colore!=(giocatore)){
                for(int R=r;R<8;R++){
                    if(CampoDiGioco[1+R][c].colore==(giocatore)){
                        arrivo=R;
                        break;
                    }
                }
            }
            if(arrivo!=0){
                for(int R=r;R<=arrivo;R++){
                    CampoDiGioco[R][c]=new Casella(false, giocatore);
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){
        }
    } 
    //In basso a sinistra
    private void CambioObldx1(int r, int c,Color giocatore) {
        try{
            int arrivo=0;
            int C=c;
            if(CampoDiGioco[1+r][1+c].libera==false && CampoDiGioco[1+r][1+c].colore!=(giocatore)){
                for(int R=r;R<8;R++){
                    if(CampoDiGioco[1+R][1+C].colore==(giocatore)){
                        arrivo=R;
                        break;
                    }
                    C++;
                }
            }
            C=c;
            if(arrivo!=0){
                for(int R=r;R<=arrivo;R++){
                        CampoDiGioco[R][C]=new Casella(false, giocatore);
                        C++;
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){
        }
    }
     //In alto a destra
    private void CambioObldx2(int r, int c,Color giocatore) {
        try{
            int arrivo=0;
            int C=c;
            if(CampoDiGioco[-1+r][1+c].libera==false && CampoDiGioco[-1+r][1+c].colore!=(giocatore)){
                for(int R=r;R>-1;R--){
                    if(CampoDiGioco[-1+R][1+C].colore==(giocatore)){
                        arrivo=R;
                        break;
                    }
                    C++;
            }
            }
            C=c;
            if(arrivo!=0){
                for(int R=r;R>=arrivo;R--){
                        CampoDiGioco[R][C]=new Casella(false, giocatore);
                        C++;
                }
            }

        }catch(ArrayIndexOutOfBoundsException e){
        }
    }
     //In basso a sinistra
    private void CambioOblsx2(int r, int c,Color giocatore) {
        try{            
            int arrivo=0;
            int C=c;
            if(CampoDiGioco[1+r][-1+c].libera==false && CampoDiGioco[1+r][-1+c].colore!=(giocatore)){
                for(int R=r;R<8;R++){
                    if(CampoDiGioco[1+R][-1+C].colore==(giocatore)){
                        arrivo=R;
                        break;
                    }
                    C--;
                }
            }
            C=c;
            if(arrivo!=0){
                for(int R=r;R<=arrivo;R++){
                        CampoDiGioco[R][C]=new Casella(false, giocatore);
                        C--;
                    }
            }
        }catch(ArrayIndexOutOfBoundsException e){
        }
    }
    //In alto a sinistra
    private void CambioOblsx1(int r, int c,Color giocatore) {
        try{
            int arrivo=0;
            int C=c;
            if(CampoDiGioco[-1+r][-1+c].libera==false && CampoDiGioco[-1+r][-1+c].colore!=(giocatore)){
                for(int R=r;R>-1;R--){
                    if(CampoDiGioco[-1+R][-1+C].colore==(giocatore)){
                        arrivo=R;
                        break;
                    }
                    C--;
                }
            }
            C=c;
            if(arrivo!=0){
                for(int R=r;R>=arrivo;R--){
                        CampoDiGioco[R][C]=new Casella(false, giocatore);
                        C--;

                }
            }
        }catch(ArrayIndexOutOfBoundsException e){
        }
    }
}