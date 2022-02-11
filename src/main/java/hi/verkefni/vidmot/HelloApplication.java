package hi.verkefni.vidmot;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {



    @Override
    public void start(Stage stage) throws IOException {
       // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 652, 867);

        ViewManager manager = new ViewManager();
        stage = manager.getMainStage();

        Image icon = new Image("BlackJackLogo.png");
        stage.getIcons().add(icon);


        stage.setTitle("Blackjack");
        stage.setResizable(false);
        //stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}