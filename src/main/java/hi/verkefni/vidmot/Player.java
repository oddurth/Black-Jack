package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.Gildi;
import hi.verkefni.vinnsla.LeikmadurInterface;
import hi.verkefni.vinnsla.SpilV;

import java.util.Arrays;

public class Player implements LeikmadurInterface {
    private String name = "";
    private int score = 0;

    private int numSpil = 0;

    private SpilV[] cards = new SpilV[5];

    @Override
    public int getSamtals() {
        return this.score;
    }

    @Override
    public String getNafn() {
        return this.name;
    }

    public SpilV getCardByIndex(int index){
        return this.cards[index];
    }

    @Override
    public void setNafn(String s) {
        this.name = s;
    }

    @Override
    public void gefaSpil(SpilV spilV) {
        if(spilV!=null){
            this.cards[numSpil] = spilV;
            this.score += spilV.getVirdi();
            this.numSpil++;
        }
    }

    @Override
    public boolean vinnurDealer(LeikmadurInterface d) {
        if (d.getSamtals() > 21){
            return true;
        }

        else if (d.getSamtals() < this.getSamtals() && this.getSamtals()<=21){
            return true;
        }

        else return false;
    }

    @Override
    public LeikmadurInterface hvorVann(LeikmadurInterface d) {
        if (vinnurDealer(d)){
            return this;
        }
        else return d;
    }

    @Override
    public void nyrLeikur() {
        for (int i = 0; i < this.numSpil; i++){
            this.cards[i] = null;
        }

        Arrays.fill(cards, null);

        this.score = 0;
        this.numSpil = 0;
    }

    public int getPlayerNumCards(){

        return this.numSpil;
    }

    public Gildi getNumValue(int index){
        if (this.cards[index]!=null){
             return this.cards[index].getGildi();
        }
        return null;
    }

    public int getNumSort(int index){
        String sort = this.cards[index].getTegund().toString();

        switch (sort){
            case "HJARTA":
                return 1;

            case "SPADI":
                return 2;


            case "TIGULL":
                return 3;


            case "LAUF":
                return 4;

        }

        return -1;
    }
}
