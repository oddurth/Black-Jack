package hi.verkefni.vidmot;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardComponent extends Button {
    private final String Card2 = "-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size:17; -fx-background-image: url('Spil42.png');";
    private final String Card3 = "-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size:17; -fx-background-image: url('Spil43.png');";
    private final String Card4 = "-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size:17; -fx-background-image: url('Spil44.png');";
    private final String Card5 = "-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size:17; -fx-background-image: url('Spil45.png');";
    private final String Card6 = "-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size:17; -fx-background-image: url('Spil46.png');";
    private final String Card7 = "-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size:17; -fx-background-image: url('Spil47.png');";
    private final String Card8 = "-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size:17; -fx-background-image: url('Spil48.png');";
    private final String Card9 = "-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size:17; -fx-background-image: url('Spil49.png');";
    private final String Card10 = "-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size:17; -fx-background-image: url('Spil410.png');";
    private final String CardJ = "-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size:17; -fx-background-image: url('Spil4G.png');";
    private final String CardQ = "-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size:17; -fx-background-image: url('Spil4D.png');";
    private final String CardK = "-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size:17; -fx-background-image: url('Spil4K.png');";
    private final String CardA = "-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size:17; -fx-background-image: url('Spil4A.png');";

    Image Hjarta = new Image("Hjarta.png", getPrefWidth(),getPrefHeight(),false,false);
    Image Spadi = new Image("Spadi.png", getPrefWidth(),getPrefHeight(),false,false);
    Image Tigull = new Image("Tigull.png", getPrefWidth(),getPrefHeight(),false,false);
    Image Lauf = new Image("Lauf.png", getPrefWidth(),getPrefHeight(),false,false);





    public CardComponent(int value, int sort){
        setPrefHeight(254);
        setPrefWidth(166);

        //af einhverjum ástæðum var switch ekki að virka í þetta þannig ég brute forceaði þetta bara
        if(value==2){
            setStyle(Card2);
        }

        if(value==3){
            setStyle(Card3);
        }

        if(value==4){
            setStyle(Card4);
        }

        if(value==5){
            setStyle(Card5);
        }

        if(value==6){
            setStyle(Card6);
        }

        if(value==7){
            setStyle(Card7);
        }

        if(value==8){
            setStyle(Card8);
        }

        if(value==9){
            setStyle(Card9);
        }


        if(value==10){
            setStyle(Card10);
        }

        if(value==11){
            setStyle(CardJ);
        }

        if(value==12){
            setStyle(CardQ);
        }

        if(value==13){
            setStyle(CardK);
        }

        if(value==14){
            setStyle(CardA);
        }


        ImageView imageView = new ImageView(imageToLoad(sort));
        imageView.setX(getLayoutX());
        imageView.setY(getLayoutY());



    }

    public Image imageToLoad(int sort){
        if(sort==1){

            return Hjarta;
        }

        if(sort==2){
            return Spadi;
        }

        if(sort==3){
            return Tigull;
        }

        if(sort==4){
            return Lauf;
        }

        return Hjarta;
    }





}

