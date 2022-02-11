package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.SpilV;
import hi.verkefni.vinnsla.Stokkur;

public class Game {
    private Player player = new Player();
    private Player dealer = new Player();

    private Stokkur s = new Stokkur();

    boolean stopGame = true;

    int dealerIndex = 0;

    public void startNewGame(){
        stopGame = false;
        dealerIndex = 0;

        dealer.setNafn("Dealer");

        player.nyrLeikur();
        dealer.nyrLeikur();

        for (int i = 0; i < 2; i++){
            player.gefaSpil(draga());
        }

        dealer.gefaSpil(draga());
        dealerIndex++;

    }

    public void nextRound(){
        if (!stopGame) {
             while (dealer.getSamtals() < 16){
            dealer.gefaSpil(draga());
            dealerIndex++;
        }

        if (dealer.getSamtals() > 21){
            stopGame();
            setWinnerIndex(0);
        }

            if (player.getSamtals() <= 21) {
                player.gefaSpil(draga());

                }

                if (player.getSamtals() > 21) {
                    stopGame();
                    setWinnerIndex(1);
            }

        }
    }

    public void hold(){
        if (!stopGame){
            while (dealer.getSamtals() < 16){
                dealer.gefaSpil(draga());
                dealerIndex++;
            }
            stopGame();
        }
    }

    public String getPlayerSamtals(){
        return String.valueOf(player.getSamtals());
    }

    public int getPlayerGameNumCards(){
        return player.getPlayerNumCards();
    }

    public String getDealerSamtals(){
        return String.valueOf(dealer.getSamtals());
    }

    public int getDealerGameNumCards(){
        return dealer.getPlayerNumCards();
    }

    public int getDealerNumCards(){
        return dealerIndex;
    }

    private int winnerIndex = 0;


    public void stopGame(){

        ViewManager view = new ViewManager();
        view.noButtons();

        s = new Stokkur();

        if (player.vinnurDealer(dealer)){
            winnerIndex = 0;
        }

        else if(player.getSamtals() == dealer.getSamtals()){
            winnerIndex = 2;
        }

        else {
            winnerIndex = 1;
        }

        stopGame = true;
    }

    private void setWinnerIndex(int i){
        winnerIndex = i;
    }

    public int getWinnerIndex(){
        return winnerIndex;
    }

    public String stringWhoWon(){
        return player.hvorVann(dealer).getNafn();
    }

    public void setPlayerName(String name){
        player.setNafn(name);
    }

    public int getCardValue(int index){
        String theString = player.getNumValue(index).toString();


        if (theString.equalsIgnoreCase("g")){
            return 11;
        }

        if (theString.equalsIgnoreCase("d")){
            return 12;
        }

        if (theString.equalsIgnoreCase("k")){
            return 13;
        }

        if (theString.equalsIgnoreCase("a")){
            return 14;
        }

        else{
            return Integer.parseInt(theString);
        }

    }

    public int getDealerCardValue(int index){
        String theString = dealer.getNumValue(index).toString();


        if (theString.equalsIgnoreCase("g")){
            return 11;
        }

        if (theString.equalsIgnoreCase("d")){
            return 12;
        }

        if (theString.equalsIgnoreCase("k")){
            return 13;
        }

        if (theString.equalsIgnoreCase("a")){
            return 14;
        }

        else{
            return Integer.parseInt(theString);
        }

    }

    public int getCardSort(int sort){
        return player.getNumSort(sort);
    }

    public int getDealerCardSort(int sort){
        return dealer.getNumSort(sort);
    }

    private SpilV draga(){
        if(s.dragaSpil()==null){
            s = new Stokkur();
        }

        return s.dragaSpil();
    }

    public boolean getStopGame(){
        return stopGame;
    }





}

