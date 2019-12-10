package com.cbtuser.container;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

/**
 *
 * @author Kafka Febianto Agiharta - 1772012
 */
public class MediaBarController extends HBox {

    private Slider videoSlider = new Slider();
    private Slider volumeSlider = new Slider();
    private Button btnPlay = new Button();
    private ImageView volImage = new ImageView(new Image(
            "file:css/images/volume.png"));
    private MediaPlayer player;

    public MediaBarController(MediaPlayer player) {
        this.player = player;

        this.setStyle("-fx-spacing: 8; -fx-padding: 8");

        setAlignment(Pos.CENTER);
        setPadding(new Insets(5, 10, 5, 10));

        volumeSlider.setPrefWidth(60);
        volumeSlider.setMinWidth(30);
        volumeSlider.setValue(100);
        volumeSlider.setId("volume-progress-bar");

        videoSlider.setValue(0);
        videoSlider.setId("media-progress-bar");

        HBox.setHgrow(this.videoSlider, Priority.ALWAYS);

        btnPlay.setPrefWidth(40);
        btnPlay.setId("button-play");

        volImage.setFitHeight(30);
        volImage.setFitWidth(30);

        getChildren().add(btnPlay);
        getChildren().add(videoSlider);
        getChildren().add(volImage);
        getChildren().add(volumeSlider);

        btnPlay.setOnAction((ActionEvent e) -> {

            Status sts = this.player.getStatus();

            if (sts == Status.PLAYING) {
                btnPlay.setId("button-play");
                this.player.pause();

            } else {
                btnPlay.setId("button-pause");
                this.player.play();
            }
        });

        this.player.currentTimeProperty().addListener(((Observable o) -> {
            updatesValues();
        }));

        videoSlider.valueProperty().addListener((Observable o) -> {
            if (videoSlider.isPressed()) {
                this.player.seek(this.player.getMedia().getDuration().multiply(
                        videoSlider.getValue() / 100));
            }
        });

        volumeSlider.valueProperty().addListener((Observable o) -> {
            if (volumeSlider.isPressed()) {
                this.player.setVolume(volumeSlider.getValue() / 100);
            }
        });
    }

    protected void updatesValues() {
        Platform.runLater(() -> {
            videoSlider.setValue(
                    ((this.player.getCurrentTime().toMillis() / this.player.
                    getTotalDuration().toMillis()) * 100));
        });
    }

    public Slider getVideoSlider() {
        return videoSlider;
    }

    public Button getBtnPlay() {
        return btnPlay;
    }

    public MediaPlayer getPlayer() {
        return this.player;
    }

}
