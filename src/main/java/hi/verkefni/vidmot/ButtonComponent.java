package hi.verkefni.vidmot;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class ButtonComponent extends Button {
    private final String Button_Up_Style = "-fx-background-color: transparent; -fx-text-fill: white; -fx-padding: -5px -5px -5px -5px; -fx-font-size:18; -fx-background-image: url('ButtonUpBlackJack.png');";
    private final String Button_Over_Style = "-fx-background-color: transparent; -fx-background-image: url('ButtonOverBlackJack2.jpg');";

    public ButtonComponent(String text){
        setText(text);
        setPrefHeight(78);
        setPrefWidth(165);
        setStyle(Button_Up_Style);
       // initButtonListeners();
    }

    private void setButtonOverStyle() {
        setStyle(Button_Over_Style);
        setPrefHeight(70);
        setLayoutY(getLayoutY()+4);
    }

    private void setButtonUpStyle() {
        setStyle(Button_Up_Style);
        setPrefHeight(70);
        setLayoutY(getLayoutY()+4);
    }

    private void setNewScore(String score){
        setText(score);
    }

    private void initButtonListeners(){
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    setButtonOverStyle();
                }
            }
        });

        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    setButtonUpStyle();
                }
            }
        });

        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    setButtonUpStyle();
                }
            }
        });

    }



}
