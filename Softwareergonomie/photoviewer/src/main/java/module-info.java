module com.thm.photoviewer {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.iconli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.dashicons;

    requires flatter;
    requires java.prefs;
    requires java.desktop;

    opens com.thm.photoviewer to javafx.fxml;

    exports com.thm.photoviewer;
}