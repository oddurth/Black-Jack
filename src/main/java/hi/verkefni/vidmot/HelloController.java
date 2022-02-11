package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.Stokkur;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    private TextField nafn;

    @FXML
    private Label playerName;

    private Stokkur s = new Stokkur();
    private Game game = new Game();


    @FXML
    protected void nyrLeikurClick() {
        game.startNewGame();
    }

    @FXML
    protected void dragaAnnadClick() {
        game.nextRound();
    }

    @FXML
    protected void holdClick() {
        game.hold();
    }

    @FXML
    protected void onTextInput() {
        game.setPlayerName(nafn.getText());
        playerName.setText(nafn.getText());
    }

}