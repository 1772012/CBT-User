package com.cbtuser;

import com.cbtuser.util.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Kafka Febianto Agiharta (1772012)
 */
public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/LoginView.fxml"));
        GridPane pane = loader.load();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Login Form");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setFullScreenExitHint("No Escape :)");
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        HibernateUtil.getSessionFactory().close();
    }
    
    

}
