package org.example.pokerjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Image pokerBackground = new Image(getClass().getResourceAsStream("pokerbilde.jpg"));

        ImageView backgroundImageView = new ImageView(pokerBackground);

        backgroundImageView.setFitHeight(600);
        backgroundImageView.setFitWidth(1000);
        backgroundImageView.setPreserveRatio(false);


        StackPane root = new StackPane();
        root.getChildren().add(backgroundImageView);

        Button dealHand = new Button("Deal Hand");
        Button checkHand = new Button("Check hand");
        Button checkFlush = new Button("Check flush");
        Button checkSpadeQueen = new Button("Check spade queen");
        Button checkSum = new Button("Check sum");
        Button checkHearts = new Button("Check hearts");

        root.getChildren().add(dealHand);
        root.getChildren().add(checkHand);

        Scene scene = new Scene(root, 1000, 600);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}