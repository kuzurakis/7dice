package com.sevendice.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Locale;
import java.util.ResourceBundle;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Locale defaultLocale = new Locale("ru");
        ResourceBundle bundle = ResourceBundle.getBundle("i18n.messages", defaultLocale);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"), bundle);
        Scene scene = new Scene(loader.load());
        stage.setTitle(bundle.getString("app.title"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}