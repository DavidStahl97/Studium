package com.thm.javafxmvc;

import com.thm.javafxmvc.eingabe.EingabeVC;
import com.thm.javafxmvc.model.DataBean;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * @author Alexander Gr.
 * @see http://blog.axxg.de
 *
 */
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Sessionscope /Applikationscope Beans inizitalisieren!
        // muessen von Controllern weitergegeben werden
        DataBean dataBean = new DataBean(primaryStage);


        // Ersten Controller aufrufen
        EingabeVC eingabeVC = new EingabeVC(dataBean);
        eingabeVC.show();
    }
}