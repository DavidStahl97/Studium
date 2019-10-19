package com.thm.javafxmvc.model;

import java.util.HashMap;
import java.util.Map;

import javafx.stage.Stage;

/**
 * Daten, die innerhalb der Anwendung gebraucht werden, werden in Beans gespeichert.
 * Diese Klassen speichern nur Werte und haben keine andere Aufgabe!
 *
 * @author Alexander Gr.
 * @see http://blog.axxg.de
 *
 */
public class DataBean {

    private Stage primaryStage = null;

    private Map<String, String> namePwMap = null;


    public DataBean(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.namePwMap = new HashMap<>();
    }


    public Map<String, String> getNamePwMap() {
        return namePwMap;
    }


    public Stage getPrimaryStage() {
        return primaryStage;
    }


}
