package org.example.pokerjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    private DeckManager dm = new DeckManager();
    @Override
    public void start(Stage stage) throws IOException {

        VBox vBox = new VBox(15);
        HBox cardDisplayHBox = new HBox(5);
        VBox allContent = new VBox(20);
        cardDisplayHBox.setLayoutY(100);
        Image pokerBackground = new Image(getClass().getResourceAsStream("pokerbilde.jpg"));

        ImageView backgroundImageView = new ImageView(pokerBackground);

        backgroundImageView.setFitHeight(600);
        backgroundImageView.setFitWidth(1000);
        backgroundImageView.setPreserveRatio(false);


        StackPane root = new StackPane();
        root.getChildren().add(backgroundImageView);

        Button dealHand = new Button("Deal Hand");
        Text dealHandResult = new Text();

        Button checkFlush = new Button("Check flush");
        Text checkFlushResult = new Text();

        Button checkSpadeQueen = new Button("Check spade queen");
        Text spadeQueenResult = new Text();
        Button checkSum = new Button("Check sum");
        Text checkSumResult = new Text();

        Button checkHearts = new Button("Check hearts");
        Text checkHeartsResult = new Text();

        checkFlush.setDisable(true);
        checkSpadeQueen.setDisable(true);
        checkSum.setDisable(true);
        checkHearts.setDisable(true);

        dealHand.setOnAction(e -> {
            List<PlayingCard> hand = dm.dealHand();
            cardDisplayHBox.getChildren().clear();
            for (PlayingCard card : hand) {
                StackPane cardGraphic = dm.cardGraphic(card);
                cardDisplayHBox.getChildren().add(cardGraphic);
            }

            dealHandResult.setText("Hand dealt: " + hand.toString());
            checkFlushResult.setText(" ");
            spadeQueenResult.setText(" ");
            checkSumResult.setText(" ");
            checkHeartsResult.setText(" ");
            checkFlush.setDisable(false);
            checkSpadeQueen.setDisable(false);
            checkSum.setDisable(false);
            checkHearts.setDisable(false);

        });


        checkFlush.setOnAction(e -> {
            boolean isFlush = dm.checkFlush();
            checkFlushResult.setText("Is flush: " + isFlush);
        });

        checkSpadeQueen.setOnAction(e -> {
            boolean hasSpadeQueen= dm.spadeQueen();
            spadeQueenResult.setText("Spade queen in hand: " + hasSpadeQueen);


        });
        checkSum.setOnAction(e -> {
            int sum = dm.getSum();
            checkSumResult.setText("Sum: " + sum);


        });
        checkHearts.setOnAction(e -> {
            String heart = dm.checkHearts();
            checkHeartsResult.setText("Hearts: " + heart);


        });
        vBox.getChildren().addAll(dealHand,dealHandResult,checkFlush, checkFlushResult, checkSpadeQueen, spadeQueenResult,
                checkHearts, checkHeartsResult, checkSum, checkSumResult);

        allContent.getChildren().addAll(vBox, cardDisplayHBox);
        root.getChildren().addAll(allContent);

        Scene scene = new Scene(root, 1000, 600);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}