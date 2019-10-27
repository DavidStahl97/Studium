module com.thm.photoviewer {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.thm.photoviewer to javafx.fxml;
    opens com.thm.photoviewer.controller to javafx.fxml;
    exports com.thm.photoviewer;
    exports com.thm.photoviewer.controller;
}