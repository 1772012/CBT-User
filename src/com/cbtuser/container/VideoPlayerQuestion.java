package com.cbtuser.container;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 * @author Kafka Febianto Agiharta - 1772012
 *
 * VideoPlayerQuestion is used for create video based question.
 */
public class VideoPlayerQuestion extends BorderPane {

    /**
     * Block below contains each attributes of VideoPlayerQuestion
     */
    private MediaPlayer player;
    private Media media;
    private MediaView mediaView = new MediaView();
    private MediaController controller;
    private StackPane pane = new StackPane();
    private VBox statusBox = new VBox();
    private ImageView statusImage = new ImageView(new Image(
            "com/cbtuser/view/css/images/play.png"));

    /**
     * Block below is constructor of class
     *
     * @param path
     */
    public VideoPlayerQuestion(String path) {

        /**
         * Block below for create media player, controller and media status
         */
        this.media = new Media(path);
        this.player = new MediaPlayer(this.media);
        this.player.setVolume(0.5);
        this.mediaView.setMediaPlayer(this.player);
        this.mediaView.setFitHeight(337);
        this.mediaView.setFitWidth(600);
        this.mediaView.setPreserveRatio(false);
        this.controller = new MediaController(this.player);
        this.controller.setId("mediabar-controller");
        this.statusBox.getChildren().add(this.statusImage);
        this.statusBox.setAlignment(Pos.CENTER);
        this.statusBox.setId("video-status-paused");
        this.statusImage.setFitHeight(75);
        this.statusImage.setFitWidth(75);

        /**
         * This property used for listening updates of media progress value
         */
        this.player.currentTimeProperty().addListener((Observable o) -> {
            updatesValues();
        });

        /**
         * When clicked, media changes its status to played or paused
         */
        this.statusBox.setOnMouseClicked((e) -> {
            this.mediaView.toFront();
            this.player.play();
            this.controller.getBtnMediaControl().setId("button-pause");
        });
        this.mediaView.setOnMouseClicked((e) -> {
            this.statusBox.toFront();
            this.player.pause();
            this.controller.getBtnMediaControl().setId("button-play");
        });
        this.controller.getBtnMediaControl().setOnAction((ActionEvent e) -> {
            MediaPlayer.Status sts = player.getStatus();
            if (sts == MediaPlayer.Status.PLAYING) {
                this.statusBox.toFront();
                this.controller.getBtnMediaControl().setId("button-play");
                player.pause();
            } else {
                this.mediaView.toFront();
                this.controller.getBtnMediaControl().setId("button-pause");
                player.play();
            }
        });

        /**
         * Code block below is for set the MediaView properties
         */
        this.pane.setMinSize(600, 337);
        this.pane.setMinSize(600, 337);
        this.pane.setMinSize(600, 337);
        this.pane.getChildren().addAll(this.mediaView, this.statusBox);

        /**
         * Code block below is for set the class properties
         */
        setMinSize(600, 412);
        setPrefSize(600, 412);
        setMaxSize(600, 412);
        setCenter(this.pane);
        setBottom(this.controller);

    }

    /**
     * This code block below for updating slider while video is played
     */
    protected void updatesValues() {
        Platform.runLater(() -> {
            this.getSdrMediaControl().setValue(
                    ((this.player.getCurrentTime().toMillis() / this.player.
                    getTotalDuration().toMillis()) * 100));

        });
    }

    /**
     * Getter method section
     */
    public MediaPlayer getPlayer() {
        return player;
    }

    public Button getBtnMediaControl() {
        return this.controller.getBtnMediaControl();
    }

    public Slider getSdrMediaControl() {
        return this.controller.getSdrMediaControl();
    }

    public MediaController getController() {
        return controller;
    }

    public MediaView getMediaView() {
        return mediaView;
    }

    public VBox getStatusBox() {
        return statusBox;
    }

}
