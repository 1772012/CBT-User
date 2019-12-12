package com.cbtuser.container;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;

/**
 *
 * @author Kafka Febianto Agiharta - 1772012
 */
public class MediaBarController extends HBox {

    //  Initialization of objects
    private Slider videoSlider = new Slider();
    private Slider volumeSlider = new Slider();
    private Button btnPlay = new Button();
    private ImageView volImage = new ImageView(new Image(
            "com/cbtuser/view/css/images/volume.png"));
    private MediaPlayer player;
    private Label lblDuration = new Label("00:00");

    //  Constructor
    public MediaBarController(MediaPlayer player) {

        //  Set MediaPlayer
        this.player = player;
        this.player.currentTimeProperty().addListener(((Observable o) -> {
            updatesValues();
        }));

        //  Set play Button
        btnPlay.setPrefWidth(40);
        btnPlay.setId("button-play");
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

        //  Set video Slider
        videoSlider.setValue(0);
        videoSlider.setId("media-progress-bar");
        videoSlider.valueProperty().addListener((Observable o) -> {
            if (videoSlider.isPressed()) {
                this.player.seek(this.player.getMedia().getDuration().multiply(
                        videoSlider.getValue() / 100));
            }
        });

        // Set duration Label
        lblDuration.setId("label-black");
        lblDuration.textProperty().bind(
                Bindings.createStringBinding(() -> {
                    Duration time = this.player.getCurrentTime();
                    return String.format("%02d:%02d",
                            (int) time.toMinutes(),
                            (int) time.toSeconds() % 60);
                },
                        this.player.currentTimeProperty()));

        //  Set volume ImageView
        volImage.setFitHeight(30);
        volImage.setFitWidth(30);

        //  Set volume Slider
        volumeSlider.setPrefWidth(60);
        volumeSlider.setValue(100);
        volumeSlider.setId("volume-progress-bar");
        volumeSlider.valueProperty().addListener((Observable o) -> {
            if (volumeSlider.isPressed()) {
                this.player.setVolume(volumeSlider.getValue() / 100);
            }
        });

        //  Set class attributes
        setStyle("-fx-spacing: 8; -fx-padding: 8");
        setAlignment(Pos.CENTER);
        setPadding(new Insets(5, 10, 5, 10));
        HBox.setHgrow(this.videoSlider, Priority.ALWAYS);

        //  Add objects into class
        getChildren().add(btnPlay);
        getChildren().add(videoSlider);
        getChildren().add(lblDuration);
        getChildren().add(volImage);
        getChildren().add(volumeSlider);
    }

    //  Function to updates media values
    protected void updatesValues() {
        Platform.runLater(() -> {
            videoSlider.setValue(
                    ((this.player.getCurrentTime().toMillis() / this.player.
                    getTotalDuration().toMillis()) * 100));
        });
    }

    //  Getter / Setter
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
