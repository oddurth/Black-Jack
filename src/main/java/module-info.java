module hi.verkefni.vidmot {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires Spil21Library;

    opens hi.verkefni.vidmot to javafx.fxml;
    exports hi.verkefni.vidmot;
}