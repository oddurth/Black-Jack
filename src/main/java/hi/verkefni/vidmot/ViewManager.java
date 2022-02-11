package hi.verkefni.vidmot;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Arrays;

public class ViewManager {

    private Game game = new Game();

    boolean stopGame = false;

    private CardComponent[] drawCards = new CardComponent[5];
    private DealerCardComponent[] dealerCards = new DealerCardComponent[5];
    private int indexOfCard = 0;

    private int numCards = 0;

    private static final int HEIGHT = 867;
    private static final int WIDTH = 651;

    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    private boolean[] cardDone = new boolean[3];

    private int dealerPos = 100;
    private int dealerNumCards = 0;




    public ViewManager(){
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);

        Arrays.fill(cardDone, false);

        indexOfCard = 0;

        for (int i = 0; i < 5; i++){
            drawCards[i] = null;
        }

        for (int i = 0; i < 5; i++){
            dealerCards[i] = null;
        }

        createBackground();
        createButtons();

        createDealerSamtals();

        createNafnSubScene();

    }


    public Stage getMainStage(){
        return mainStage;
    }

    private Rectangle rect = new Rectangle();
    private ImageView nafnspjald = new ImageView();
    private TextField nafnField = new TextField();
    private Label playerLabel = new Label();
    ButtonComponent aframButton = new ButtonComponent("Áfram");


    public void createNafnSubScene(){

        rect.setLayoutX(0);
        rect.setLayoutY(0);
        rect.setWidth(mainPane.getWidth());
        rect.setHeight(mainPane.getHeight());
        rect.setFill(Color.rgb(130,130,130));
        rect.setOpacity(0.4);
        mainPane.getChildren().add(rect);


        Image img = new Image("NafnSpjald.png", 582,330,false,false);
        nafnspjald.setImage(img);


        nafnspjald.setX(32);
        nafnspjald.setY(250);
        nafnspjald.setFitWidth(0);
        nafnspjald.setFitHeight(0);
        mainPane.getChildren().add(nafnspjald);

        nafnspjald.toFront();

        nafnField.setLayoutX(95);
        nafnField.setLayoutY(444);
        nafnField.setPrefWidth(465);
        nafnField.setPrefHeight(90);
        nafnField.setText("");
        nafnField.setStyle("-fx-background-color: transparent; -fx-text-fill: black; -fx-font-size:35;");
        nafnField.setAlignment(Pos.CENTER);
        mainPane.getChildren().add(nafnField);

        System.out.println(nafnField.getText());


        playerLabel.setAlignment(Pos.TOP_RIGHT);
        playerLabel.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size:19;");
        playerLabel.setLayoutX(385);
        playerLabel.setLayoutY(mainPane.getHeight()-40);
        playerLabel.setPrefWidth(250);
        playerLabel.setPrefHeight(70);
        mainPane.getChildren().add(playerLabel);

        mainPane.getChildren().add(aframButton);
        aframButton.setLayoutX(244);
        aframButton.setLayoutY(569);
        aframButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-padding: -5px -5px -5px -5px; -fx-font-size:21; -fx-background-image: url('ButtonUpBlackJack.png');");

        aframButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                playerLabel.setText(nafnField.getText());
                deleteNameScreen();
                game.setPlayerName(nafnField.getText());
            }
        });
    }

    private void deleteNameScreen(){
        mainPane.getChildren().remove(aframButton);
        mainPane.getChildren().remove(nafnField);
        mainPane.getChildren().remove(nafnspjald);
        mainPane.getChildren().remove(rect);
    }

    private void createCard(int x, int y, int value, int sort){
        CardComponent firstCard = new CardComponent(value, sort);

        firstCard.setLayoutX(x-3);
        firstCard.setLayoutY(-240);

        ImageView imageView = new ImageView(firstCard.imageToLoad(sort));
        imageView.setX(x);
        imageView.setY(-240);
        imageView.setFitWidth(145);
        imageView.setFitHeight(240);

        firstCard.setGraphic(imageView);

        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.millis(350));
        transition.setToX(0);
        transition.setToY(y+240);
        transition.setFromX((Math.random()-0.5)*1000);
        transition.setNode(firstCard);
        transition.play();

        RotateTransition rotTrans = new RotateTransition();
        rotTrans.setDuration(Duration.millis(330));
        rotTrans.setFromAngle(50);
        rotTrans.setToAngle(0);
        rotTrans.setNode(firstCard);
        rotTrans.play();

        drawCards[indexOfCard] = firstCard;
        mainPane.getChildren().add(drawCards[indexOfCard]);
        drawCards[indexOfCard].toBack();
        indexOfCard++;

    }

    private void createDealerCards(int x, int y, int value, int sort){
        DealerCardComponent firstCard = new DealerCardComponent(value, sort);

        firstCard.setLayoutX(dealerPos);
        firstCard.setLayoutY(-240);

        ImageView imageView = new ImageView(firstCard.imageToLoad(sort));
        imageView.setX(dealerPos);
        imageView.setY(-240);
        imageView.setFitWidth(60);
        imageView.setFitHeight(110);

        firstCard.setGraphic(imageView);

        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.millis(350));
        transition.setToX(0);
        transition.setToY(310);
        transition.setFromX((Math.random()-0.5)*1000);
        transition.setNode(firstCard);
        transition.play();

        RotateTransition rotTrans = new RotateTransition();
        rotTrans.setDuration(Duration.millis(330));
        rotTrans.setFromAngle(300);
        rotTrans.setToAngle(0);
        rotTrans.setNode(firstCard);
        rotTrans.play();

        dealerPos+=87;

        dealerCards[dealerNumCards] = firstCard;
        mainPane.getChildren().add(dealerCards[dealerNumCards]);
        dealerCards[dealerNumCards].toBack();
    }

    public void noButtons(){
        stopGame=true;
    }

    private void stopGame(){
        for (int i = 0; i < 5; i++){
            mainPane.getChildren().remove(drawCards[i]);
            drawCards[i] = null;
        }

        for (int i = 0; i < 5; i++){
            mainPane.getChildren().remove(dealerCards[i]);
            dealerCards[i] = null;
        }

        indexOfCard = 0;
        stopGame=false;
        dealerPos = 100;
        dealerNumCards = 0;
    }

    private void clearDealerCards(int index){

            mainPane.getChildren().remove(dealerCards[index]);
            dealerCards[index] = null;

    }


    private void createButtons(){

        ButtonComponent samtalsButton = new ButtonComponent(game.getPlayerSamtals());
        mainPane.getChildren().add(samtalsButton);

        samtalsButton.setLayoutX(244);
        samtalsButton.setLayoutY(569);
        samtalsButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-padding: -5px -5px -5px -5px; -fx-font-size:21; -fx-background-image: url('ButtonUpBlackJack.png');");

        samtalsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            }
        });

        ButtonComponent button = new ButtonComponent("Halda");
        mainPane.getChildren().add(button);

        button.setLayoutX(157);
        button.setLayoutY(740);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.hold();
                //game.stopGame();

                for (int i = dealerNumCards; i < game.dealerIndex; i++){
                    createDealerCards(0,0,game.getDealerCardValue(i),game.getDealerCardSort(i));
                    dealerNumCards++;
                }

                updateDealerSamtals();

                int winner = game.getWinnerIndex();
                    displayWin(winner);
            }
        });

        ButtonComponent button2 = new ButtonComponent("Draga Annað");
        mainPane.getChildren().add(button2);

        button2.setLayoutX(331);
        button2.setLayoutY(740);

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                if(!stopGame){
                    game.nextRound();
                    samtalsButton.setText(game.getPlayerSamtals());
                    updateDealerSamtals();

                    for (int i = dealerNumCards; i < game.dealerIndex; i++){
                        createDealerCards(0,0,game.getDealerCardValue(i),game.getDealerCardSort(i));
                        dealerNumCards++;
                    }

                    if (game.getPlayerGameNumCards()==3){
                        if(!cardDone[0]){
                            createCard(158,421,game.getCardValue(2), game.getCardSort(2));
                            cardDone[0] = true;
                        }
                    }

                    if (game.getPlayerGameNumCards()==4) {
                        if (!cardDone[1]) {
                            createCard(330, 421, game.getCardValue(3), game.getCardSort(3));
                            cardDone[1] = true;
                        }
                    }

                    if (game.getPlayerGameNumCards()==5){
                        if(!cardDone[2]) {
                            createCard(158, 366, game.getCardValue(4), game.getCardSort(4));
                            cardDone[2] = true;
                        }
                        }

                    if(game.stopGame){
                        int winner = game.getWinnerIndex();
                        displayWin(winner);
                    }
                    }
                }

        });

        ButtonComponent buttonNewGame = new ButtonComponent("Nýr Leikur");
        mainPane.getChildren().add(buttonNewGame);

        buttonNewGame.setLayoutX(-28);
        buttonNewGame.setLayoutY(-14);

        buttonNewGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                clearWinner();
                game.startNewGame();
                samtalsButton.setText(game.getPlayerSamtals());
                stopGame = true;
                stopGame();
                createCard(158, 476, game.getCardValue(0), game.getCardSort(0));
                createCard(330, 476, game.getCardValue(1), game.getCardSort(1));

                createDealerSamtals();
                Arrays.fill(cardDone, false);


                createDealerCards(0,0,game.getDealerCardValue(0),game.getDealerCardSort(0));
                dealerNumCards++;



                if(game.stopGame){
                    int winner = game.getWinnerIndex();
                    displayWin(winner);
                }

            }
        });





    }

    private void createBackground(){
        Image backgroundImage = new Image("BlackJackBg.png", WIDTH,HEIGHT,false,false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(background));
    }


    private Label samtalsDealer = new Label("Dealer: " + game.getDealerSamtals().toString());

    private void updateDealerSamtals(){ samtalsDealer.setText("Dealer: " + game.getDealerSamtals().toString()); }

    private void createDealerSamtals(){
        mainPane.getChildren().remove(samtalsDealer);
        samtalsDealer.setText("Dealer: " + game.getDealerSamtals().toString());
        samtalsDealer.setAlignment(Pos.CENTER);
        samtalsDealer.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size:19;");
        samtalsDealer.setLayoutX(251);
        samtalsDealer.setLayoutY(0);
        samtalsDealer.setPrefWidth(150);
        samtalsDealer.setPrefHeight(70);
        mainPane.getChildren().add(samtalsDealer);
    }

    private ImageView resultView = new ImageView();

    public void displayWin(int winner){

        if (winner==0) {
            Image img = new Image("YouWin22.png", 582,330,false,false);
            resultView.setImage(img);
        }

        else if (winner==1) {
            Image img = new Image("DealerWin22.png", 582,330,false,false);
            resultView.setImage(img);
        }

        else if (winner==2) {
            Image img = new Image("Jafnt22.png", 582,330,false,false);
            resultView.setImage(img);
        }

        else {
            Image img = new Image("Jafnt22.png", 582,330,false,false);
            resultView.setImage(img);
        }

        resultView.setX(32);
        resultView.setY(250);
        resultView.setFitWidth(0);
        resultView.setFitHeight(0);
        mainPane.getChildren().add(resultView);

        resultView.toFront();


        RotateTransition rotTrans = new RotateTransition();
        rotTrans.setDuration(Duration.millis(210));
        rotTrans.setFromAngle(40);
        rotTrans.setToAngle(0);
        rotTrans.setNode(resultView);
        rotTrans.play();

        ScaleTransition scaleTrans = new ScaleTransition();
        scaleTrans.setDuration(Duration.millis(210));
        scaleTrans.setToX(1);
        scaleTrans.setToY(1);
        scaleTrans.setFromX(0);
        scaleTrans.setFromX(0);
        scaleTrans.setNode(resultView);
        scaleTrans.play();


    }

    public void clearWinner(){
        mainPane.getChildren().remove(resultView);
    }

    public void hideDealerCars(){
        Rectangle rect = new Rectangle();
        rect.setLayoutX(dealerPos);
        rect.setLayoutY(50);
        rect.setWidth(80);
        rect.setHeight(110);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        mainPane.getChildren().add(rect);

    }


}
