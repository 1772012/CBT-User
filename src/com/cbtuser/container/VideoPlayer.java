package com.cbtuser.container;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 *
 * @author Kafka Febianto Agiharta - 1772012
 */
public class VideoPlayer extends BorderPane {

    private Media media;
    private MediaPlayer player;
    private MediaView view;
    private HBox pane;
    private MediaBarController controller;

    public VideoPlayer(String file) {
        this.pane = new HBox();
        this.media = new Media(file);
        this.player = new MediaPlayer(this.media);
        this.view = new MediaView(this.player);
        this.controller = new MediaBarController(this.player);

        this.player.setOnPlaying(() -> {
            this.controller.getVideoSlider().setValue((this.player.
                    getCurrentTime().toMillis() / this.player.getTotalDuration().
                            toMillis()) * 100);
        });

        this.view.setOnMouseClicked((e) -> {
            if (this.player.getStatus() == MediaPlayer.Status.PLAYING) {
                this.player.pause();
                this.controller.getBtnPlay().setId("button-play");
            } else {
                this.player.play();
                this.controller.getBtnPlay().setId("button-pause");
            }
        });

        setWidth(600);
        setPrefWidth(600);
        setMaxWidth(600);

        this.pane.setMaxWidth(600);
        this.pane.setPrefWidth(600);
        this.pane.setAlignment(Pos.CENTER);

        this.view.setFitWidth(700);

        pane.getChildren().add(view);

        setCenter(pane);

        setBottom(this.controller);
        setStyle("-fx-background-color:#0068ac");
    }

    public MediaPlayer getPlayer() {
        return player;
    }

    public MediaBarController getController() {
        return controller;
    }

}
